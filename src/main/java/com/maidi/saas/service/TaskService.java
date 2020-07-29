package com.maidi.saas.service;

import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.*;

import java.util.List;
import java.util.Set;

/**
 * @Classname TaskService
 * @Description TODO
 * @Date 2020/6/8 14:39
 * @Created by hjchen
 */
public interface TaskService {

    TaskVo getById(int id);

    List<TaskCommentVo> getTaskListById(int id);

    List<TaskVo> getAllTasks();

    List<TaskQuery> queryTask(SearchDict dict);

    int save(TaskVo taskVo);

    int saveTaskComment(TaskCommentVo commentVo);

    void saveTimeSheet(TimeSheetVo sheetVo);

    void saveTemplate(TemplateVo templateVo);

    int getType(Integer templateId);

    void saveTaskLog(TaskRemarkVo remarkVo);

    List<TaskLogVo> queryTaskLog(SearchDict dict);

    List<TimeSheetVo> getTimeSheet();

    void deleteTaskById(int id);

    List<TreeVo> listTree(int projectId, int parentId,int level);

    List<TreeVo> getProjects(int id);

    List<TaskInfo> getTaskInfo(SearchDict dict);

    void updateById(TaskVo taskVo);

    void updateTaskComment(TaskCommentVo commentVo);
}
