package com.maidi.saas.service.impl;

import com.maidi.saas.dao.TaskDao;
import com.maidi.saas.entity.vo.*;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Classname TaskServiceImpl
 * @Description TODO
 * @Date 2020/6/12 13:28
 * @Created by hjchen
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public TaskVo getById(int id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public List<TaskCommentVo> getTaskListById(int id) {
        return taskDao.getTaskListById(id);
    }

    @Override
    public List<TaskVo> getAllTasks() {
        return taskDao.getAll();
    }

    @Override
    public List<TaskQuery> queryTask(SearchDict dict) {
        return taskDao.queryTask(dict);
    }

    @Override
    public int save(TaskVo taskVo) {
        return taskDao.saveTask(taskVo);
    }

    @Override
    public int saveTaskComment(TaskCommentVo commentVo) {
        return taskDao.saveTaskComment(commentVo);
    }

    @Override
    public void saveTimeSheet(TimeSheetVo sheetVo) {
        taskDao.saveTimeSheet(sheetVo);
    }

    @Override
    public void saveTemplate(TemplateVo templateVo) {
        taskDao.saveTemplate(templateVo);
    }

    @Override
    public int getType(Integer templateId) {
        return taskDao.getType(templateId);
    }

    @Override
    public void saveTaskLog(TaskRemarkVo remarkVo) {
        taskDao.saveTaskLog(remarkVo);
    }

    @Override
    public List<TaskLogVo> queryTaskLog(SearchDict dict) {
        return taskDao.queryTaskLog(dict);
    }

    @Override
    public List<TimeSheetVo> getTimeSheet() {
        return taskDao.getTimeSheet();
    }

    @Override
    public void deleteTaskById(int id) {
        taskDao.deleteTaskById(id);
    }

    @Override
    public List<TreeVo> listTree(int projectId, int parentId, int level) {
        return taskDao.listTree(projectId, parentId, level);
    }

    @Override
    public List<TreeVo> getProjects() {
        return taskDao.getProjects();
    }

    @Override
    public List<TaskInfo> getTaskInfo(SearchDict dict) {
        if (dict.getFlag() == 2) {
            dict.setTaskId(dict.getId());
        } else {
            dict.setProjectId(dict.getId());
        }
        return taskDao.queryTaskInfo(dict);
    }
}
