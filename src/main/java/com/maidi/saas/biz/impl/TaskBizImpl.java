package com.maidi.saas.biz.impl;

import com.maidi.saas.biz.TaskBiz;
import com.maidi.saas.dao.TaskDao;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.TaskInfo;
import com.maidi.saas.entity.vo.TreeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Classname TaskBizImpl
 * @Description TODO
 * @Date 2020/06/24 13:08
 * @Created by hjchen
 */
@Service
@Slf4j
public class TaskBizImpl implements TaskBiz {

    @Autowired
    private TaskDao taskDao;

    @Override
    public Map treeMap(SearchDict dict) {
        if (dict.getFlag() == 0) {
            dict.setProjectId(dict.getId());
        } else {
            dict.setTaskId(dict.getId());
        }
        Map result = new HashMap();
        if (dict.getId() != 0) {
            if (dict.getFlag() == 0) {
                dict.setProjectId(dict.getId());
                List<TreeVo> subTasks = taskDao.listTree(dict.getProjectId(), null, 0);
                buildTree(subTasks, dict.getFlag());
                List<TaskInfo> taskInfo = taskDao.queryTaskInfo(dict);
                log.warn("taskParam {}", dict);
                result.put("task", subTasks);
                result.put("taskInfo", taskInfo);
            } else {
                TreeVo treeVo = taskDao.getTreeById(dict.getTaskId(), null);
                log.warn("treeVo {}", treeVo);
                dict.setTaskId(dict.getId());
                List<TreeVo> subTasks = taskDao.listTree(0, treeVo.getParentId(), treeVo.getLevel());
                if (subTasks.size() == 0) {
                    subTasks.add(treeVo);
                }
                buildTree(subTasks, dict.getFlag());
                List<TaskInfo> taskInfo = taskDao.queryTaskInfo(dict);
                log.warn("subTaskParam {}", dict);
                result.put("task", subTasks);
                result.put("taskInfo", taskInfo);
            }
        } else {
            log.warn("projectParam {}", dict);
            List<TreeVo> projects = taskDao.getProjects();
            buildTree(projects, dict.getFlag());
            result.put("project", projects);
        }
        return result;
    }

    public boolean isParent(TreeVo treeVo, int type) {
        boolean flag = false;
        List<TreeVo> subTask = matchTask(treeVo, type);
        if (subTask.size() > 0) flag = true;
        return flag;
    }

    private List<TreeVo> matchTask(TreeVo treeVo, int type) {
        log.warn("matchTask {}", treeVo);
        List<TreeVo> subTask;
        if (type == 0) {
            subTask = taskDao.listTree(treeVo.getProjectId(), null, 0);
        } else {
            subTask = taskDao.listTree(0, treeVo.getParentId(), treeVo.getLevel());
        }
        return subTask;
    }

    public void buildTree(List<TreeVo> subTasks, int type) {
        for (TreeVo vo : subTasks) {
            vo.setParent(isParent(vo, type));
        }
    }
}
