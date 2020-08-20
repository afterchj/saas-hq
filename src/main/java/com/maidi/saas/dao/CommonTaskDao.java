package com.maidi.saas.dao;

import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Classname TaskDao
 * @Description TODO
 * @Date 2020/6/18 14:39
 * @Created by hjchen
 */
public interface CommonTaskDao {

    List<TimeSheetVo> getTimeSheet();

    TimeSheetVo getTimeSheetById(int id);

    CommonTree getCommonTreeById(int id);

    List<TreeVo> getProjects(int id);

    List<TreeVo> getProducts(int id);

    List<TreeVo> listProduct(SearchDict dict);

    TreeVo getTreeById(SearchDict dict);

    List<TreeVo> listTree(SearchDict dict);

    List<CommonTree> listCommonTree(@Param("parentId") Integer parentId, @Param("level") int level);

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

    int saveTaskLog(TaskLogVo taskLogVo);

    void saveTemplate(TemplateVo templateVo);

    List<TaskLogVo> queryTaskLog(SearchDict dict);

    void updateTaskComment(TaskCommentVo commentVo);

    void updateTimeSheetById(TimeSheetVo sheetVo);

    void deleteSheetById(int id);
}
