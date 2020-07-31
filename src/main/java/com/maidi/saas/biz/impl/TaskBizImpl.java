package com.maidi.saas.biz.impl;

import com.maidi.saas.biz.TaskBiz;
import com.maidi.saas.dao.TaskDao;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.CommonTree;
import com.maidi.saas.entity.vo.TaskInfo;
import com.maidi.saas.entity.vo.TreeVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
        String str = dict.getId();
        int id = 0;
        if (StringUtils.isNotBlank(str)) {
            if (str.contains("_")) {
                id = Integer.parseInt(str.substring(str.lastIndexOf("_") + 1, str.length()));
            } else {
                id = Integer.parseInt(str);
            }
        }
        dict.setId(String.valueOf(id));
        if (dict.getFlag() == 0) {
            dict.setProjectId(id);
        } else {
            dict.setTaskId(id);
        }
        log.warn("dict {},id {}", dict, id);
        if (id != 0) {
            if (dict.getFlag() == 0) {
                List<TreeVo> subTasks = taskDao.listTree(id, null, 1);
                buildTree(dict, subTasks, dict.getFlag());
                result.put("task", subTasks);
            } else {
                TreeVo treeVo = taskDao.getTreeById(dict.getTaskId(), null);
                log.warn("treeVo {}", treeVo);
                dict.setTaskId(id);
                List<TreeVo> subTasks = taskDao.listTree(0, Integer.valueOf(treeVo.getId()), treeVo.getLevel() + 1);
                if (subTasks.size() == 0) {
                    subTasks.add(treeVo);
                }
                buildTree(dict, subTasks, dict.getFlag());
                result.put("task", subTasks);
            }
        } else {
            List<TreeVo> projects = taskDao.getProjects(0);
            buildTree(dict, projects, dict.getFlag());
            result.put("project", projects);
        }
        return result;
    }

    @Override
    public Map treeTimeSheet(int id) {
        Map result = new HashMap();
        if (id != 0) {
            CommonTree commonTree = taskDao.getCommonTreeById(id);
            log.warn("treeVo {}", commonTree);
            List<CommonTree> subTree = taskDao.listCommonTree(commonTree.getId(), commonTree.getLevel() + 1);
            if (subTree.size() == 0) {
                subTree.add(commonTree);
            }
            buildTree(subTree);
            result.put("data", subTree);
        } else {
            List<CommonTree> commonTrees = taskDao.listCommonTree(0, 1);
            buildTree(commonTrees);
            result.put("data", commonTrees);
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
        List<TreeVo> subTask;
        if (type == 0) {
            if (treeVo.getParentId() == null) {
                subTask = taskDao.listTree(treeVo.getProjectId(), null, 0);
            } else {
                subTask = taskDao.listTree(treeVo.getProjectId(), Integer.valueOf(treeVo.getId()), treeVo.getLevel() + 1);
            }
        } else {
            subTask = taskDao.listTree(0, Integer.valueOf(treeVo.getId()), treeVo.getLevel() + 1);
        }
        return subTask;
    }

    public void buildTree(SearchDict dict, List<TreeVo> subTasks, int type) {
        List<TaskInfo> taskInfo;
        for (TreeVo vo : subTasks) {
            log.warn("buildTree {} type {}", vo, type);
            if (type == 0) {
                dict.setProjectId(vo.getProjectId());
                taskInfo = taskDao.queryTaskInfo(dict);
            } else {
                dict.setTaskId(Integer.parseInt(dict.getId()));
                taskInfo = taskDao.queryTaskInfo(dict);
            }
            if (taskInfo.size() == 0) {
                taskInfo.add(new TaskInfo());
            }
            vo.setTaskInfo(taskInfo);
            vo.setParent(isParent(vo, type));
        }
    }

    public void buildTree(List<CommonTree> subTree) {
        for (CommonTree commonTree : subTree) {
            log.warn("commonTree {}", commonTree);
            commonTree.setParent(haveSub(commonTree));
        }
    }

    public boolean haveSub(CommonTree commonTree) {
        boolean flag = false;
        List<CommonTree> subTree = taskDao.listCommonTree(commonTree.getId(), commonTree.getLevel() + 1);
        if (subTree.size() > 0) flag = true;
        return flag;
    }

}
