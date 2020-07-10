package com.maidi.saas.biz.impl;

import com.maidi.saas.biz.TaskBiz;
import com.maidi.saas.dao.TaskDao;
import com.maidi.saas.entity.vo.OptionDict;
import com.maidi.saas.entity.vo.TreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname TaskBizImpl
 * @Description TODO
 * @Date 2020/06/24 13:08
 * @Created by hjchen
 */
@Service
public class TaskBizImpl implements TaskBiz {

    @Autowired
    private TaskDao TaskDao;

    @Override
    public Map treeMap() {
        Map result = new HashMap();
        List<OptionDict> projects = TaskDao.getProjects();
        for (OptionDict dict : projects) {
            Set<TreeVo> tasks = TaskDao.listTree(dict.getId(), 0, 1);
            if (tasks.size() > 0) {
                dict.setTask(tasks);
                for (TreeVo vo : tasks) {
                    Set<TreeVo> subTasks = TaskDao.listTree(0, vo.getId(), vo.getLevel() + 1);
                    if (subTasks.size() > 0) {
                        vo.setTask(subTasks);
                        buildTree(subTasks);
                    }
                }
            }
        }
        result.put("project", projects);
        return result;
    }

    public void buildTree(Set<TreeVo> subTasks) {
        for (TreeVo vo : subTasks) {
            Set<TreeVo> tasks = TaskDao.listTree(0, vo.getId(), vo.getLevel() + 1);
            if (tasks.size() > 0) {
                vo.setTask(tasks);
            }
        }
    }
}
