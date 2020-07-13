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
        Map result = new HashMap();
        if (dict.getId() != 0) {
            TreeVo treeVo = taskDao.getTreeById(dict.getId());
            log.warn("treeVo {}", treeVo);
            if (dict.getFlag() == 2) {
                dict.setTaskId(dict.getId());
                List<TreeVo> subTasks = taskDao.listTree(0, treeVo.getParentId(), treeVo.getLevel());
                buildTree(subTasks, dict.getFlag());
                List<TaskInfo> taskInfo = taskDao.queryTaskInfo(dict);
                log.warn("subTaskParam {}", dict);
//                treeVo.setTaskInfo(taskInfo);
                result.put("task", subTasks);
                result.put("taskInfo", taskInfo);
            } else {
                dict.setProjectId(dict.getId());
                List<TreeVo> subTasks = taskDao.listTree(dict.getId(), 0, 0);
                buildTree(subTasks, dict.getFlag());
                List<TaskInfo> taskInfo = taskDao.queryTaskInfo(dict);
                log.warn("taskParam {}", dict);
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

    public boolean isParent(List<TreeVo> subTasks, TreeVo treeVo, int type) {
//        boolean flag = false;
//        if (subTasks != null) {
//            if (subTasks.size() > 0) {
//                for (TreeVo vo : subTasks) {
//                    List<TreeVo> subTask = matchTask(vo, type);
//                    if (subTask.size() > 0) flag = true;
//                }
//            }
//        } else {
//            List<TreeVo> subTask = matchTask(treeVo, type);
//            if (subTask.size() > 0) flag = true;
//        }
        return true;
    }

    private List<TreeVo> matchTask(TreeVo treeVo, int type) {
        log.warn("matchTask {}", treeVo);
        List<TreeVo> subTask;
        if (type == 2) {
            subTask = taskDao.listTree(0, treeVo.getParentId(), treeVo.getLevel() + 1);
        } else {
            subTask = taskDao.listTree(treeVo.getProjectId(), 0, 0);
        }
        return subTask;
    }

    public void buildTree(List<TreeVo> subTasks, int type) {
        for (TreeVo vo : subTasks) {
            if (type == 2) {
                vo.setParent(isParent(subTasks, null, type));
            } else {
                vo.setParent(isParent(null, vo, type));
            }
        }
    }
}
