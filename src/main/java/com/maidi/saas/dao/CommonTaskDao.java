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

    List<TreeVo> getProjects(int id);

    ProductVo getProductById(int id);

    List<TreeVo> listProduct(SearchDict dict);

    List<TreeVo> listProductTask(SearchDict dict);

    TreeVo getTreeById(SearchDict dict);

    List<TreeVo> listTree(SearchDict dict);

    int getType(int templateId);

    List<TaskQuery> queryTask(SearchDict dict);

    List<TaskCommentVo> getTaskListById(int id);

    CommonTaskVo getTaskById(int id);

    TaskGroupVo getTaskGroupById(int id);

    List<TaskInfo> queryTaskInfo(SearchDict dict);

    void saveTask(CommonTaskVo taskVo);

    void saveTaskGroup(TaskGroupVo groupVo);

    void saveProduct(ProductVo productVo);


    void updateProduct(ProductVo productVo);

    int updateTask(Map params);

    int saveRecord(TaskRecordVo recordVo);

    int saveUpdate(TaskRecordVo recordVo);

    void saveAttachment(AttachmentVo attachmentVo);

    List<AttachmentVo> getAttachmentList(int hostId);
}
