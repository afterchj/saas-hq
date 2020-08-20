package com.maidi.saas.biz.impl;

import com.maidi.saas.biz.TaskManager;
import com.maidi.saas.dao.CommonTaskDao;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.TreeVo;
import com.maidi.saas.utils.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname TaskManagerImpl
 * @Description TODO
 * @Date 2020/08/19 15:12
 * @Created by hjchen
 */

@Slf4j
@Service
public class TaskManagerImpl implements TaskManager {

    @Autowired
    private CommonTaskDao taskDao;

    @Override
    public Map tree() {
        Map result = new HashMap();
        List<TreeVo> projects = taskDao.getProjects(0);
        List<TreeVo> subTasks;
        SearchDict dict = new SearchDict();
        for (TreeVo treeVo : projects) {
            dict.setProjectId(treeVo.getProjectId());
            subTasks = taskDao.listTree(dict);
            if (subTasks.size() > 0) {
                treeVo.setSubTree(subTasks);
                treeVo.setParent(true);
                buildTree(dict, subTasks, 0);
            }
        }
        result.put("data", projects);
        return result;
    }

    @Override
    public Map subtree(SearchDict dict) {
        Map result = new HashMap();
        List<TreeVo> subTasks = new ArrayList<>();
        String str = dict.getId();
        int id = IdUtil.paresId(str);
        dict.setId(String.valueOf(id));
        if (dict.getFlag() == 0) {
            dict.setProjectId(id);
            subTasks = taskDao.listTree(dict);
            buildTree(dict, subTasks, dict.getFlag());
            log.warn("dict {} size {}", dict, subTasks.size());
        } else if (dict.getFlag() == 1) {
            dict.setParentId(id);
            TreeVo treeVo = taskDao.getTreeById(dict);
            dict.setLevel(treeVo.getLevel() + 1);
            subTasks = taskDao.listTree(dict);
            if (subTasks.size() == 0) {
                dict.setFlag(2);
                dict.setParentId(0);
                dict.setTaskId(Integer.parseInt(treeVo.getId()));
                subTasks = taskDao.listProduct(dict);
            }
            buildTree(dict, subTasks, dict.getFlag());
        } else if (dict.getFlag() == 2) {
            dict.setParentId(id);
            subTasks = taskDao.listProduct(dict);
            buildTree(dict, subTasks, dict.getFlag());
        }
        result.put("data", subTasks);
        return result;

    }

    public void buildTree(SearchDict dict, List<TreeVo> subTasks, int flag) {
        int level;
        for (TreeVo vo : subTasks) {
            level = vo.getLevel() + 1;
            if (flag == 0) {
                dict.setProjectId(vo.getProjectId());
            } else if (flag==1){
                dict.setParentId(Integer.parseInt(vo.getId()));
                dict.setProjectId(0);
                dict.setTaskId(0);
            }else {
                dict.setParentId(Integer.parseInt(vo.getId()));
                dict.setProjectId(0);
                dict.setTaskId(0);
            }
            dict.setLevel(level);
            subTask(dict, vo, flag);
        }
    }

    private void subTask(SearchDict dict, TreeVo treeVo, int flag) {
        int level = dict.getLevel();
        List<TreeVo> subTask;
        if (flag == 1) {
            subTask = taskDao.listTree(dict);
            if (subTask.size() == 0) {
                dict.setFlag(2);
                dict.setParentId(0);
                dict.setTaskId(Integer.parseInt(treeVo.getId()));
                subTask = taskDao.listProduct(dict);
            }
            buildTree(dict, subTask, dict.getFlag());
            log.warn("dict {} size {}",dict,subTask.size());
        } else if (flag == 2) {
            subTask = taskDao.listProduct(dict);
        } else {
            dict.setParentId(Integer.parseInt(treeVo.getId()));
            dict.setProjectId(0);
            dict.setTaskId(0);
            subTask = taskDao.listTree(dict);
            log.warn("subDict {}", dict);
            if (subTask.size() == 0) {
                flag = 2;
                dict.setParentId(0);
                dict.setTaskId(Integer.parseInt(treeVo.getId()));
                subTask = taskDao.listProduct(dict);
            }
        }
        treeVo.setSubTree(subTask);
        dict.setLevel(level + 1);
        if (subTask.size() > 0) {
            treeVo.setParent(true);
            buildTree(dict, subTask, flag);
        }
    }

}
