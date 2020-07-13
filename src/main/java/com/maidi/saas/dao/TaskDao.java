package com.maidi.saas.dao;

import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.*;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname TaskDao
 * @Description TODO
 * @Date 2020/6/18 14:39
 * @Created by hjchen
 */
public interface TaskDao {

    List<TimeSheetVo> getTimeSheet();

    List<TreeVo> getProjects();

    TreeVo getTreeById(@Param("id") int id);

    List<TreeVo> listTree(@Param("projectId") int projectId, @Param("parentId") int parentId, @Param("level") int level);

    int getType(int templateId);

    List<TaskCommentVo> getTaskListById(int id);

    TaskVo getTaskById(int id);

    List<TaskVo> getAll();

    List<TaskInfo> queryTaskInfo(SearchDict dict);

    void saveTimeSheet(TimeSheetVo sheetVo);

    void updateTaskById(TaskVo taskVo);

    List<TaskQuery> queryTask(SearchDict dict);

    void deleteTaskById(int id);

    void updateStatus(Map map);

    int saveTask(TaskVo taskVo);

    int saveTaskComment(TaskCommentVo commentVo);

    int saveTaskLog(TaskRemarkVo remarkVo);

    void saveTemplate(TemplateVo templateVo);

    List<TaskLogVo> queryTaskLog(SearchDict dict);
}
