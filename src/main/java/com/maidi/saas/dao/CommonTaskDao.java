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

    ProductVo getProductById(int id);

    List<TreeVo> listProduct(SearchDict dict);

    List<TreeVo> listProductTask(SearchDict dict);

    TreeVo getTreeById(SearchDict dict);

    List<TreeVo> listTree(SearchDict dict);

    List<CommonTree> listCommonTree(@Param("parentId") Integer parentId, @Param("level") int level);

    int getType(int templateId);

    List<TaskCommentVo> getTaskListById(int id);

    CommonTaskVo getTaskById(int id);

    TaskGroupVo getTaskGroupById(int id);

    List<TaskInfo> queryTaskInfo(SearchDict dict);

    void saveTimeSheet(TimeSheetVo sheetVo);

    List<TaskQuery> queryTask(SearchDict dict);

    void deleteTaskById(int id);

    void updateStatus(Map map);

    void saveTask(CommonTaskVo taskVo);

    void saveTaskGroup(TaskGroupVo groupVo);

    void saveProduct(ProductVo productVo);

    int saveTaskComment(TaskCommentVo commentVo);

    int saveTaskLog(TaskLogVo taskLogVo);

    void saveTemplate(TemplateVo templateVo);

    List<TaskLogVo> queryTaskLog(SearchDict dict);

    void updateTaskComment(TaskCommentVo commentVo);

    void updateTimeSheetById(TimeSheetVo sheetVo);

    void deleteSheetById(int id);

    void updateProduct(ProductVo productVo);

    int updateTask(Map params);

    int saveRecord(TaskRecordVo recordVo);

    int saveUpdate(TaskRecordVo recordVo);

    void saveAttachment(AttachmentVo attachmentVo);

    List<AttachmentVo> getAttachmentList(int hostId);
}
