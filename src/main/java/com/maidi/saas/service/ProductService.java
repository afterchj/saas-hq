package com.maidi.saas.service;

import com.maidi.saas.entity.FilePackageEntity;
import com.maidi.saas.entity.VersionEntity;
import com.maidi.saas.entity.vo.FilePackageInfoEntity;
import com.maidi.saas.entity.ProductTaskEntity;
import org.springframework.stereotype.Service;


/**
 *生产设计service
 *@Author zhaojing
 *@Date 2020/8/18 17:26
 */
@Service
public interface ProductService {

    /**
     *文件打包
     *@Name    filePackage
     *@params  [filePackageEntity]
     *@return  void
     *@Author  zhaojing
     *@creatTime  2020/8/18 17:27
     */
    void filePackage(FilePackageEntity filePackageEntity) throws Exception;

    /**
     *任务流转
     *@Name    taskRoam
     *@params  [productTaskEntity]
     *@return  void
     *@Author  zhaojing
     *@creatTime  2020/8/19 14:40
     */
    void taskRoam(ProductTaskEntity productTaskEntity);

    /**
     *获取附件打包详情
     *@Name    getFilePackageDetail
     *@params  [filePackageInfoEntity]
     *@return  com.maidi.saas.entity.vo.FilePackageInfoEntity
     *@Author  zhaojing
     *@creatTime  2020/8/20 10:01
     */
    FilePackageInfoEntity getFilePackageDetail(FilePackageInfoEntity filePackageInfoEntity);

    /**
     *创建新版本
     *@Name    creatVersion
     *@params  [versionEntity]
     *@return  void
     *@Author  zhaojing
     *@creatTime  2020/8/21 10:39
     */
    void creatVersion(VersionEntity versionEntity);
}
