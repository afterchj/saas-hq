package com.maidi.saas.biz.impl;

import com.maidi.saas.biz.TaskManager;
import com.maidi.saas.dao.CommonTaskDao;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.CommonTaskVo;
import com.maidi.saas.entity.vo.TaskGroupVo;
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
    private CommonTaskDao commonTaskDao;

    @Override
    public Map tree() {
        Map result = new HashMap();
        List<TreeVo> projects = commonTaskDao.getProjects(0);
        for (TreeVo treeVo : projects) {
            SearchDict dict = new SearchDict();
            dict.setProjectId(treeVo.getProjectId());
            List<TreeVo> subTasks = commonTaskDao.listTree(dict);
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
        List<TreeVo> subTask = new ArrayList<>();
        String str = dict.getId();
        int id = IdUtil.paresId(str);
        dict.setId(String.valueOf(id));
        if (dict.getFlag() == 0) {
            dict.setProjectId(id);
            subTask = commonTaskDao.listTree(dict);
            buildTree(dict, subTask, dict.getFlag());
        } else if (dict.getFlag() == 1) {
            dict.setParentId(id);
            TreeVo treeVo = commonTaskDao.getTreeById(dict);
            dict.setLevel(treeVo.getLevel() + 1);
            subTask = commonTaskDao.listTree(dict);
            if (subTask.size() == 0) {
                subTask = skipLevel(subTask, treeVo, dict);
            }
            buildTree(dict, subTask, dict.getFlag());

        } else if (dict.getFlag() == 2) {
            dict.setParentId(id);
            subTask = commonTaskDao.listProduct(dict);
            buildTree(dict, subTask, dict.getFlag());
        }
        result.put("data", subTask);
        return result;

    }

    public void buildTree(SearchDict dict, List<TreeVo> subTasks, int flag) {
        int level;
        for (TreeVo vo : subTasks) {
            level = vo.getLevel() + 1;
            if (flag == 0) {
                dict.setProjectId(vo.getProjectId());
            } else if (flag == 1) {
                dict.setParentId(Integer.parseInt(vo.getId()));
                dict.setProjectId(0);
                dict.setTaskId(0);
            } else {
                dict.setParentId(Integer.parseInt(vo.getId()));
                dict.setProjectId(0);
                dict.setTaskId(0);
            }
            dict.setLevel(level);
            nextLevel(dict, vo, flag);
        }
    }

    private void nextLevel(SearchDict dict, TreeVo treeVo, int flag) {
        int level = dict.getLevel();
        List<TreeVo> subTask;
        if (flag == 1) {
            subTask = commonTaskDao.listTree(dict);
            if (subTask.size() == 0) {
                subTask = skipLevel(subTask, treeVo, dict);
            }
            buildTree(dict, subTask, dict.getFlag());
        } else if (flag == 2) {
            subTask = commonTaskDao.listProduct(dict);
        } else {
            dict.setParentId(Integer.parseInt(treeVo.getId()));
            dict.setProjectId(0);
            dict.setTaskId(0);
            subTask = commonTaskDao.listTree(dict);
            if (subTask.size() == 0) {
                flag = 2;
                dict.setParentId(0);
                dict.setTaskId(Integer.parseInt(treeVo.getId()));
                subTask = commonTaskDao.listProduct(dict);
            }
        }
        treeVo.setSubTree(subTask);
        dict.setLevel(level + 1);
        if (subTask.size() > 0) {
            treeVo.setParent(true);
            buildTree(dict, subTask, flag);
        }
    }

    public List<TreeVo> skipLevel(List<TreeVo> subTask, TreeVo treeVo, SearchDict dict) {
        if (subTask.size() == 0) {
            dict.setFlag(2);
            dict.setParentId(0);
            dict.setTaskId(Integer.parseInt(treeVo.getId()));
            treeVo.setParent(false);
            subTask = commonTaskDao.listProduct(dict);
        }
        return subTask;
    }

    @Override
    public Map taskInfo(int id, int type) {
        Map data = new HashMap();
        if (type == 2) {
            TaskGroupVo groupVo = commonTaskDao.getTaskGroupById(id);
            data.put("data", groupVo);
        } else {
            CommonTaskVo commonTaskVo = commonTaskDao.getTaskById(id);
            data.put("data", commonTaskVo);
        }
        return data;
    }
}
