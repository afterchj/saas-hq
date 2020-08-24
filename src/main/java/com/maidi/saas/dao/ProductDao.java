package com.maidi.saas.dao;

import com.maidi.saas.entity.FilePackageEntity;
import com.maidi.saas.entity.TaskEntity;
import com.maidi.saas.entity.VersionEntity;
import com.maidi.saas.entity.vo.FilePackageInfoEntity;
import com.maidi.saas.entity.ProductTaskEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *dao
 *@Author zhaojing
 *@Date 2020/8/18 17:33
 */
@Mapper
@Component
public interface ProductDao {

    /**
     *附件打包
     *@Name    filePackage
     *@params  [filePackageEntity]
     *@return  void
     *@Author  zhaojing
     *@creatTime  2020/8/18 17:34
     */
    void filePackage(FilePackageEntity filePackageEntity);

    /**
     *任务流转
     *@Name    taskRoam
     *@params  [productTaskEntity]
     *@return  void
     *@Author  zhaojing
     *@creatTime  2020/8/19 14:46
     */
    void taskRoam(ProductTaskEntity productTaskEntity);

    /**
     *获取最大版本号
     *@Name    getMaxVersion
     *@params  [id]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/8/21 10:08
     */
    String getMaxVersion(@Param("id") Long id);

    /**
     *获取附件打包详情
     *@Name    getFilePackageDetail
     *@params  [taskId]
     *@return  com.maidi.saas.entity.vo.FilePackageInfoEntity
     *@Author  zhaojing
     *@creatTime  2020/8/20 10:24
     */
    FilePackageInfoEntity getFilePackageDetail(@Param("taskId") Long taskId);

    /**
     *创建新版本
     *@Name    creatVersion
     *@params  [VersionEntity]
     *@return  void
     *@Author  zhaojing
     *@creatTime  2020/8/21 10:37
     */
    void creatVersion(VersionEntity VersionEntity);

    /**
     *获取版本号
     *@Name    getVersion
     *@params  [taskId]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/8/21 10:44
     */
    String getVersion(@Param("taskId") Long taskId);

    /**
     *生成一套新任务节点
     *@Name    insertTask
     *@params  [taskEntity]
     *@return  void
     *@Author  zhaojing
     *@creatTime  2020/8/21 11:26
     */
    void insertTask(TaskEntity taskEntity);

    /**
     *获取子任务
     *@Name    getSonTask
     *@params  [id]
     *@return  java.lang.Long
     *@Author  zhaojing
     *@creatTime  2020/8/21 15:33
     */
    List<Long> getSonTask(@Param("id") Long id);
}
