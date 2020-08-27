package com.maidi.saas.service;

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
public interface CommonTaskService {

    Map tree();

    Map subtree(SearchDict dict);

    Map taskInfo(int id, int type);

    List<TreeVo> getProjects(int id);

    ProductVo getProductById(int id);

    List<TreeVo> listTree(SearchDict dict);

    List<TaskCommentVo> getTaskListById(int id);

    List<TaskInfo> queryTaskInfo(SearchDict dict);

    List<TaskQuery> queryTask(SearchDict dict);

    int saveTask(CommonTaskVo taskVo);

    void updateProduct(ProductVo productVo);

    int saveProduct(ProductVo productVo);

    int saveTaskGroup(TaskGroupVo groupVo);

    int updateTask(Map params);

    void saveAndUpdateRecord(TaskRecordVo recordVo);

    int saveAttachment(AttachmentVo attachmentVo);

    List<AttachmentVo> getAttachmentList(int hostId);
}
