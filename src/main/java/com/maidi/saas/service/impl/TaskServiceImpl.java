package com.maidi.saas.service.impl;

import com.maidi.saas.dao.TaskDao;
import com.maidi.saas.entity.TaskComment;
import com.maidi.saas.entity.TaskLog;
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
        int id = Integer.parseInt(dict.getId());
        if (dict.getFlag() == 2) {
            dict.setTaskId(id);
        } else {
            dict.setProjectId(id);
        }
        List<TaskQuery> taskQueries = taskDao.queryTask(dict);
        for (TaskQuery taskQuery : taskQueries) {
            List<TaskCommentVo> taskComments = taskQuery.getContent();
            TaskCommentVo commentVo = new TaskCommentVo();
            commentVo.setNotes(taskQuery.getDescription());
            commentVo.setCompleteRate(taskQuery.getPercentage());
            commentVo.setOperator(taskQuery.getPrincipal());
            taskComments.add(commentVo);
        }
        return taskQueries;
    }

    @Override
    public int save(TaskVo taskVo) {
        taskDao.saveTask(taskVo);
        return taskVo.getId();
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
    public void saveTaskLog(TaskLogVo taskLogVo) {
        taskDao.saveTaskLog(taskLogVo);
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
    public TimeSheetVo getTimeSheetById(int id) {
        return taskDao.getTimeSheetById(id);
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
    public List<TreeVo> getProjects(int id) {
        return taskDao.getProjects(id);
    }

    @Override
    public List<TaskInfo> getTaskInfo(SearchDict dict) {
        int id = Integer.parseInt(dict.getId());
        if (dict.getFlag() == 2) {
            dict.setTaskId(id);
        } else {
            dict.setProjectId(id);
        }
        return taskDao.queryTaskInfo(dict);
    }

    @Override
    public void updateById(TaskVo taskVo) {
        taskDao.updateTaskById(taskVo);
    }

    @Override
    public void updateTaskComment(TaskCommentVo commentVo) {
        taskDao.updateTaskComment(commentVo);
    }

    @Override
    public void updateTimeSheetById(TimeSheetVo sheetVo) {
        taskDao.updateTimeSheetById(sheetVo);
    }

    @Override
    public void deleteSheetById(int id) {
        taskDao.deleteSheetById(id);
    }

}
