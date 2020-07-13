package com.maidi.saas.biz.impl;

import com.maidi.saas.biz.TaskBiz;
import com.maidi.saas.dao.TaskDao;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.OptionDict;
import com.maidi.saas.entity.vo.TaskInfo;
import com.maidi.saas.entity.vo.TreeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

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
            treeVo.setParent(isParent(null, treeVo, dict.getFlag()));
            if (dict.getFlag() == 2) {
                dict.setTaskId(dict.getId());
//                List<TreeVo> task = taskDao.listTree(0, treeVo.getParentId(), treeVo.getLevel());
                List<TaskInfo> taskInfo = taskDao.queryTaskInfo(dict);
                log.warn("subTaskParam {}", dict);
                treeVo.setTaskInfo(taskInfo);
                result.put("task", treeVo);
//                result.put("taskInfo", taskInfo);
            } else {
                dict.setProjectId(dict.getId());
//                List<TreeVo> subTasks = taskDao.listTree(treeVo.getProjectId(), 0, treeVo.getLevel());
                List<TaskInfo> taskInfo = taskDao.queryTaskInfo(dict);
                log.warn("taskParam {}", dict);
                treeVo.setTaskInfo(taskInfo);
                result.put("task", treeVo);
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
        boolean flag = false;
        if (subTasks != null) {
            if (subTasks.size() > 0) {
                for (TreeVo vo : subTasks) {
                    List<TreeVo> subTask = matchTask(vo, type);
                    if (subTask.size() > 0) flag = true;
                }
            }
        } else {
            List<TreeVo> subTask = matchTask(treeVo, type);
            if (subTask.size() > 0) flag = true;
        }
        return flag;
    }

    private List<TreeVo> matchTask(TreeVo treeVo, int type) {
        List<TreeVo> subTask;
        if (type == 2) {
            subTask = taskDao.listTree(0, treeVo.getParentId(), treeVo.getLevel());
        } else {
            subTask = taskDao.listTree(treeVo.getProjectId(), 0, treeVo.getLevel());
        }
        log.warn("matchTask {}", treeVo);
        return subTask;
    }

    public void buildTree(List<TreeVo> subTasks, int type) {
        for (TreeVo vo : subTasks) {
            List<TaskInfo> tasks = new ArrayList<>();
            vo.setParent(isParent(null, vo, type));
            tasks.add(new TaskInfo());
            if (tasks.size() > 0) {
                vo.setTaskInfo(tasks);
            }
        }
    }
}
