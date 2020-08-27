package com.maidi.saas.service.impl;

import com.maidi.saas.biz.TaskManager;
import com.maidi.saas.dao.CommonTaskDao;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.*;
import com.maidi.saas.service.CommonTaskService;
import com.maidi.saas.utils.PingYinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @Classname TaskDao
 * @Description TODO
 * @Date 2020/6/18 14:39
 * @Created by hjchen
 */
@Service
public class CommonTaskServiceImpl implements CommonTaskService {

    @Autowired
    private CommonTaskDao commonTaskDao;

    @Autowired
    private TaskManager taskManager;

    @Override
    public Map tree() {
        return taskManager.tree();
    }

    @Override
    public Map subtree(SearchDict dict) {
        return taskManager.subtree(dict);
    }

    @Override
    public Map taskInfo(int id, int type) {
        return taskManager.taskInfo(id, type);
    }

    @Override
    public List<TreeVo> getProjects(int id) {
        return null;
    }

    @Override
    public ProductVo getProductById(int id) {
        return commonTaskDao.getProductById(id);
    }

    @Override
    public List<TreeVo> listTree(SearchDict dict) {
        return null;
    }

    @Override
    public List<TaskCommentVo> getTaskListById(int id) {
        return null;
    }

    @Override
    public List<TaskInfo> queryTaskInfo(SearchDict dict) {
        return null;
    }

    @Override
    public List<TaskQuery> queryTask(SearchDict dict) {
        return null;
    }

    @Override
    public void updateProduct(ProductVo productVo) {
        commonTaskDao.updateProduct(productVo);
    }

    @Override
    public int saveProduct(ProductVo productVo) {
        productVo.setCode(String.format("product_%s", PingYinUtil.getFirstSpell(productVo.getProductName())));
        productVo.setVersion(String.format("V_%s", LocalDate.now()));
        commonTaskDao.saveProduct(productVo);
        return productVo.getId();
    }

    @Override
    public int saveTask(CommonTaskVo taskVo) {
        taskVo.setCode(String.format("product_%s", PingYinUtil.getFirstSpell(taskVo.getName())));
        taskVo.setVersion(String.format("V_%s", LocalDate.now()));
        commonTaskDao.saveTask(taskVo);
        return taskVo.getId();
    }

    @Override
    public int saveTaskGroup(TaskGroupVo groupVo) {
        groupVo.setCode(String.format("product_%s", PingYinUtil.getFirstSpell(groupVo.getName())));
        groupVo.setVersion(String.format("V_%s", LocalDate.now()));
        commonTaskDao.saveTaskGroup(groupVo);
        return groupVo.getId();
    }

    @Override
    public int updateTask(Map params) {
        return commonTaskDao.updateTask(params);
    }

    @Override
    public void saveAndUpdateRecord(TaskRecordVo recordVo) {
        commonTaskDao.saveRecord(recordVo);
        commonTaskDao.saveUpdate(recordVo);
    }

    @Override
    public int saveAttachment(AttachmentVo attachmentVo) {
        commonTaskDao.saveAttachment(attachmentVo);
        return attachmentVo.getId();
    }

    @Override
    public List<AttachmentVo> getAttachmentList(int hostId) {
        return commonTaskDao.getAttachmentList(hostId);
    }
}
