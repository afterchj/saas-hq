package com.maidi.saas.service.impl;



import com.alibaba.fastjson.JSONObject;
import com.maidi.saas.dao.ProductDao;
import com.maidi.saas.entity.*;
import com.maidi.saas.entity.vo.FilePackageInfoEntity;
import com.maidi.saas.service.ProductService;
import com.maidi.saas.utils.BarCodeUtil;
import com.maidi.saas.utils.client.RentClient;
import com.maidi.saas.utils.client.TaskClient;
import com.maidi.saas.utils.client.UserClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


/**
 *生产设计实现层
 *@Author zhaojing
 *@Date 2020/8/18 17:29
 */
@Service
public class ProductImpl implements ProductService{

    @Autowired
    ProductDao productDao;

    /**
     * 岩松文件服务器
     */
    @Autowired
    RentClient rentClient;

    /**
     * 赵静系统基础功能服务器
     */
    @Autowired
    TaskClient taskClient;

    /**
     * 中道人员服务器
     */
    @Autowired
    UserClient userClient;

    /**
     * 生成条形码工具类
     */
    @Autowired
    BarCodeUtil barCodeUtil;

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public void filePackage(FilePackageEntity filePackageEntity) throws Exception {
        //TODO 调取岩松文件打包，获取文件条形码
        filePackageEntity.setBarcode(null);

        //生成版本号
        String maxVersion = productDao.getMaxVersion(filePackageEntity.getTaskId());
        filePackageEntity.setVersion(BarCodeUtil.creatVersion(maxVersion));

        //包含文件数
        String[] split = filePackageEntity.getFiles().split(",");
        List<String> strings = Arrays.asList(split);
        filePackageEntity.setFileNum(strings.size());

        productDao.filePackage(filePackageEntity);
    }

    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    @Override
    public void taskRoam(ProductTaskEntity productTaskEntity) {
        //插入本地任务
        productDao.taskRoam(productTaskEntity);

        //TODO 调取赵静发起任务
        TaskReplyLaunchEntity taskReplyLaunchEntity=new TaskReplyLaunchEntity();
        taskReplyLaunchEntity.setSponsor(productTaskEntity.getCreated_by());//发起人
        taskReplyLaunchEntity.setInfoId(productTaskEntity.getId());//生成的信息id
        taskReplyLaunchEntity.setStartCode(productTaskEntity.getModularCode());//发起模块
        taskReplyLaunchEntity.setReceiveCode(productTaskEntity.getModularCode());//接收模块
        taskReplyLaunchEntity.setReceiver(productTaskEntity.getReceiver());//任务接收人
        taskReplyLaunchEntity.setTaskType(productTaskEntity.getTaskType());//任务类别
        taskReplyLaunchEntity.setDescribe(productTaskEntity.getDescribe());//任务描述
        taskReplyLaunchEntity.setEnclosure(productTaskEntity.getEnclosure());//附件
        taskReplyLaunchEntity.setTaskFrom(productTaskEntity.getTaskFrom());//任务来源
        String s = taskClient.launchTask(taskReplyLaunchEntity);
        System.out.println(s);
    }



    @Override
    public FilePackageInfoEntity getFilePackageDetail(FilePackageInfoEntity filePackageInfoEntity) {
        //获取详情
        FilePackageInfoEntity res=productDao.getFilePackageDetail(filePackageInfoEntity.getTaskId());
        if(null==res){
            return null;
        }
        //处理创建人
        String userInfo = userClient.user(Integer.valueOf(res.getCreated()).intValue());
        if(!StringUtils.isEmpty(userInfo)){
            JSONObject obj=(JSONObject) JSONObject.parse(userInfo);
            JSONObject data = (JSONObject) obj.get("data");
            UserClientEntity userClientEntity = (UserClientEntity)JSONObject.toJavaObject(data, UserClientEntity.class);
            res.setCreated(userClientEntity.getUsername());
        }

        //统计包含产品数量
        getSon(filePackageInfoEntity.getTaskId());

        //统计包含任务数量

        //生成文件条形码图片
        if(!StringUtils.isEmpty(res.getBarcode())){
            res.setBarcode(BarCodeUtil.getBarCode(res.getBarcode()));
        }

        return res;
    }

    /**
     * 递归统计该任务节点下的所有子任务和任务分组
     * @param taskId
     * @return
     */
    private String getSon(Long taskId){
        List<Long> sonTask = productDao.getSonTask(taskId);
        StringBuffer sb=new StringBuffer();
        if(null!=sonTask&&sonTask.size()>0){
            for (Long l:sonTask) {
                sb.append(sonTask+",");
                getSon(l);
            }
        }
        return sb.substring(0,sb.length()-1);
    }

    @Override
    public void creatVersion(VersionEntity versionEntity) {
        //生成版本号
        String version = productDao.getVersion(versionEntity.getTaskId());
        versionEntity.setVersion(BarCodeUtil.creatVersion(version));

        //复制任务节点
        TaskEntity taskEntity=new TaskEntity ();
        taskEntity.setVersion(BarCodeUtil.creatVersion(version));
        taskEntity.setName(versionEntity.getNewTaskName());
        taskEntity.setId(versionEntity.getTaskId());
        productDao.insertTask(taskEntity);
        //包含下级节点
        if("1".equals(versionEntity.getIsContain())){
            //查询子节点
            switch(versionEntity.getType())
            {
                case "1"://项目
                    //查子分组


                    break;

                case "2"://任务分组



                    break;

                case "3"://产品



                    break;

                case "4"://任务



                    break;
            }


        }
        productDao.creatVersion(versionEntity);

    }
}