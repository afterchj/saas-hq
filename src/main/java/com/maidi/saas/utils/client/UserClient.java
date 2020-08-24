package com.maidi.saas.utils.client;

import com.maidi.saas.entity.UserIdsEntity;
import com.maidi.saas.entity.UserInfoEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *用户基础模块服务间调用
 *@Author zhaojing
 *@Date 2020/6/17 14:50
 */
@Component
@FeignClient("service-zuul")
public interface UserClient {

    /**
     *获取单个人员信息
     *@Name    user
     *@params  [id]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/6/20 8:53
     */
    @GetMapping("/organization/user/{id}")
    String user(@RequestParam("id") int id);

    /**
     *批量获取人员信息
     *@Name    selectByUserIds
     *@params  [t]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/6/20 8:53
     */
    @PostMapping("/organization/user/selectByUserIds")
    String selectByUserIds(@RequestBody(required = false) UserIdsEntity t);

    /**
     *批量获取角色
     *@Name    selectByRoleIds
     *@params  [t]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/6/20 8:55
     */
    @PostMapping("/organization/role/selectByRoleIds")
    String selectByRoleIds(@RequestBody(required = false) UserIdsEntity t);

    /**
     *批量获取部门
     *@Name    selectByRoleIds
     *@params  [t]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/6/20 8:55
     */
    @PostMapping("/organization/dept/selectByDeptIds")
    String selectByDeptIds(@RequestBody(required = false) UserIdsEntity t);

    /**
     *批量获取岗位
     *@Name    selectByRoleIds
     *@params  [t]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/6/20 8:55
     */
    @PostMapping("/organization/job/selectByJobIds")
    String selectByJobIds(@RequestBody(required = false) UserIdsEntity t);

    /**
     *获取用户身份
     *@Name    user
     *@params  [id]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/7/27 16:51
     */
    @GetMapping("/organization/user/selectDJRIdList/{id}")
    String getUserRole(@RequestParam("id") Long id);

    /**
     *根据角色/部门/岗位id获取对应人员集合
     *@Name    selectByParamsIds
     *@params  [userInfoEntity]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/7/29 13:29
     */
    @PostMapping("/organization/user/selectByParamsIds")
    String selectByParamsIds(@RequestBody(required = false) UserInfoEntity userInfoEntity);


}
