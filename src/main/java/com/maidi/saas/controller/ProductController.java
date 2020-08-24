package com.maidi.saas.controller;

import com.maidi.saas.entity.FilePackageEntity;
import com.maidi.saas.entity.ProductTaskEntity;
import com.maidi.saas.entity.VersionEntity;
import com.maidi.saas.entity.vo.FilePackageInfoEntity;
import com.maidi.saas.exception.BasicException;
import com.maidi.saas.exception.CodeMsg;
import com.maidi.saas.service.ProductService;
import com.maidi.saas.utils.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 生产设计控制层
 *
 * @Author zhaojing
 * @Date 2020/8/18 17:18
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;


    /**
     * 附件打包
     *
     * @return com.maidi.saas.utils.ApiResponse<java.lang.String>
     * @Name filePackage
     * @params [filePackageEntity]
     * @Author zhaojing
     * @creatTime 2020/8/18 17:25
     */
    @RequestMapping("/filePackage")
    ApiResponse<String> filePackage(@RequestBody FilePackageEntity filePackageEntity) {
        ApiResponse<String> response = new ApiResponse<String>();
        try {
            if (StringUtils.isEmpty(filePackageEntity.getFiles()) ||
                    null == filePackageEntity.getTaskId() ||
                    StringUtils.isEmpty(filePackageEntity.getPackageName()) ||
                    StringUtils.isEmpty(filePackageEntity.getCreated())) {
                throw new BasicException();
            }
            productService.filePackage(filePackageEntity);
        } catch (BasicException p) {
            response.setCode(CodeMsg.INTER_ERROR.getCode());
            response.setMessage(CodeMsg.INTER_ERROR.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(CodeMsg.EMPTY_PARAM_ERROR.getCode());
            response.setMessage(CodeMsg.EMPTY_PARAM_ERROR.getMessage());
        }
        return response;
    }

    /**
     * 任务流转
     *
     * @return com.maidi.saas.utils.ApiResponse<java.lang.String>
     * @Name taskRoam
     * @params [productTaskEntity]
     * @Author zhaojing
     * @creatTime 2020/8/19 14:40
     */
    @RequestMapping("/taskRoam")
    ApiResponse<String> taskRoam(@RequestBody ProductTaskEntity productTaskEntity) {
        ApiResponse<String> response = new ApiResponse<String>();
        try {
            if (StringUtils.isEmpty(productTaskEntity.getModularCode()) ||
                    StringUtils.isEmpty(productTaskEntity.getReceiver()) ||
                    StringUtils.isEmpty(productTaskEntity.getTaskType()) ||
                    StringUtils.isEmpty(productTaskEntity.getCreated_by())) {
                throw new BasicException();
            }
            productService.taskRoam(productTaskEntity);
        } catch (BasicException p) {
            response.setCode(CodeMsg.INTER_ERROR.getCode());
            response.setMessage(CodeMsg.INTER_ERROR.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(CodeMsg.EMPTY_PARAM_ERROR.getCode());
            response.setMessage(CodeMsg.EMPTY_PARAM_ERROR.getMessage());
        }
        return response;
    }

    /**
     * 获取附件打包详情
     *
     * @return com.maidi.saas.utils.ApiResponse<com.maidi.saas.entity.vo.FilePackageInfoEntity>
     * @Name getFilePackageDetail
     * @params [filePackageInfoEntity]
     * @Author zhaojing
     * @creatTime 2020/8/20 10:02
     */
    @RequestMapping("/getFilePackageDetail")
    ApiResponse<FilePackageInfoEntity> getFilePackageDetail(@RequestBody FilePackageInfoEntity filePackageInfoEntity) {
        ApiResponse<FilePackageInfoEntity> response = new ApiResponse<FilePackageInfoEntity>();
        FilePackageInfoEntity res = new FilePackageInfoEntity();
        try {
            if (null == filePackageInfoEntity.getTaskId()) {
                throw new BasicException();
            }
            res = productService.getFilePackageDetail(filePackageInfoEntity);
            response.setData(res);
        } catch (BasicException p) {
            response.setCode(CodeMsg.INTER_ERROR.getCode());
            response.setMessage(CodeMsg.INTER_ERROR.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(CodeMsg.EMPTY_PARAM_ERROR.getCode());
            response.setMessage(CodeMsg.EMPTY_PARAM_ERROR.getMessage());
        }
        return response;
    }

    @RequestMapping("/creatVersion")
    ApiResponse<String> creatVersion(@RequestBody VersionEntity VersionEntity) {
        ApiResponse<String> response = new ApiResponse<String>();
        try {
            if (StringUtils.isEmpty(VersionEntity.getCreated()) || null == VersionEntity.getTaskId() || StringUtils.isEmpty(VersionEntity.getIsContain())
                    || StringUtils.isEmpty(VersionEntity.getOldTaskName()) || StringUtils.isEmpty(VersionEntity.getNewTaskName()) || StringUtils.isEmpty(VersionEntity.getType())) {
                throw new BasicException();
            }
            productService.creatVersion(VersionEntity);
        } catch (BasicException p) {
            response.setCode(CodeMsg.INTER_ERROR.getCode());
            response.setMessage(CodeMsg.INTER_ERROR.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(CodeMsg.EMPTY_PARAM_ERROR.getCode());
            response.setMessage(CodeMsg.EMPTY_PARAM_ERROR.getMessage());
        }
        return response;
    }
}
