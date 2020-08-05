package com.maidi.saas.controller;

import com.alibaba.fastjson.JSONObject;
import com.maidi.saas.entity.dd.ResultDict;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.*;
import com.maidi.saas.service.CommonService;
import com.maidi.saas.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Classname MainController
 * @Description TODO
 * @Date 2020/6/6 11:03
 * @Created by hjchen
 */

@RestController
@Api(description = "项目管理API接口")
@RequestMapping("/project")
@Slf4j
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private CommonService commonService;

    @GetMapping
    @ApiOperation(value = "获取项目下拉列表", notes = "表单下拉列表数据初始化")
    public Map list() {
        Map data = new HashMap();
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<Item> users = commonService.getOptions("sm_user", "");
        List<Item> stage = commonService.getOptions("sm_dict", "1");
        List<Item> type = commonService.getOptions("sm_dict", "2");
        List<Item> customer = commonService.getOptions("sm_customer", "");
        List<Item> customerGrade = commonService.getOptions("sm_customer_grade", "");
        List<Item> customerType = commonService.getOptions("sm_customer_type", "");
        data.put("user", users);
        data.put("stage", stage);
        data.put("type", type);
        data.put("customer", customer);
        data.put("customerGrade", customerGrade);
        data.put("customerType", customerType);
        result.put("data", data);
        return result;
    }

    @ApiOperation(value = "获取项目下拉列表", notes = "ajax异步获取项目列表", produces = "application/json")
    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public Map optionList() {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<OptionDict> optionDicts = projectService.getAllProjects();
        result.put("data", optionDicts);
        return result;
    }

    @ApiOperation(value = "获取客户详情", notes = "获取客户详情", produces = "application/json")
    @RequestMapping(value = "/customerInfo", method = RequestMethod.GET)
    public Map getCustomerInfo(int id) {
        Map result = new HashMap(id);
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        CustomerVo customerVo = projectService.getCustomerInfoById(id);
        result.put("data", customerVo);
        return result;
    }

    @ApiOperation(value = "项目查看", notes = "根据ID查询项目")
    @RequestMapping(value = "/getProjectById", method = RequestMethod.GET)
    public Map getProjectById(Integer id) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        ProjectVo projectVo = projectService.getProjectById(id);
        result.put("data", projectVo);
        return result;
    }

    @ApiOperation(value = "测试项目查询", notes = " 测试项目查询")
    @RequestMapping(value = "/queryProjects", method = RequestMethod.POST)
    public Map getAll(@RequestBody(required = false) SearchDict dict) {
        log.warn("params {}", dict);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<ProjectQuery> projectQueries = projectService.queryProject(dict);
        result.put("data", projectQueries);
        return result;
    }

    @ApiOperation(value = "项目查询", notes = "根据条件查询项目列表")
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public Map queryProject(SearchDict dict) {
        log.warn("dict {}", dict);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
//        PageHelper.startPage(dict.getPageNum(), dict.getPageSize());
        List<ProjectQuery> projectQueries = projectService.queryProject(dict);
//        PageInfo<ProjectQuery> pageInfo = new PageInfo<>(projectQueries);
        result.put("data", projectQueries);
        return result;
    }


    @ApiOperation(value = "创建项目", notes = "新增项目")
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public Map queryProjects(@RequestBody(required = false) String param) {
        log.warn("param {}", param);
        ProjectVo projectVo = JSONObject.parseObject(param, ProjectVo.class);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        int id = projectService.save(projectVo);
        result.put("id", id);
        return result;
    }

    @ApiOperation(value = "测试创建项目", notes = "测试新增项目")
    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public Map add(ProjectVo projectVo) {
        log.warn("params {}", projectVo);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        int id = projectService.save(projectVo);
        log.warn("id {}", id);
        return result;
    }

    @ApiOperation(value = "修改项目", notes = "根据id修改项目")
    @RequestMapping(value = "/editProject", method = RequestMethod.POST)
    public Map edit(@RequestBody(required = false) ProjectVo projectVo) {
        log.warn("projectVo {} ", projectVo);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        projectService.update(projectVo);
        return result;
    }

    @ApiOperation(value = "调整项目阶段", notes = "根据id调整项目阶段")
    @RequestMapping(value = "/updateStage", method = RequestMethod.POST)
    public Map updateStage(@RequestBody(required = false) ProjectVo projectVo) {
        log.warn("projectVo {} ", projectVo);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        projectService.updateStage(projectVo);
        return result;
    }

    @ApiOperation(value = "删除项目", notes = "根据ID删除项目")
    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public Map deleteProjectById(Integer id) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        projectService.delete(id);
        return result;
    }
}
