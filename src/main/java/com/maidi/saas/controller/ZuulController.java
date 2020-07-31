package com.maidi.saas.controller;

import com.maidi.saas.service.FeignUserService;
import com.maidi.saas.service.ZuulUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hongjian.chen on 2020/7/14.
 */

@RestController
@Api(description = "用户模块API接口")
public class ZuulController {

    @Autowired
    private FeignUserService feignUserService;

    @Autowired
    private ZuulUserService zuulUserService;

    @GetMapping("/list")
    @ApiOperation(value = "获取用户下拉列表", notes = "ajax异步获取用户列表")
    public String getAllUser() {
        return feignUserService.getAllUser();
    }

    @GetMapping("/item")
    @ApiOperation(value = "获取用户清单", notes = "zuul获取用户列表")
    public String getUsers() {
        return zuulUserService.getAllUser();
    }
}
