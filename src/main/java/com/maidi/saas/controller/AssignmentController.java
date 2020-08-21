package com.maidi.saas.controller;

import com.maidi.saas.entity.dd.ResultDict;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.CommonTaskVo;
import com.maidi.saas.entity.vo.ProductVo;
import com.maidi.saas.entity.vo.TaskGroupVo;
import com.maidi.saas.service.CommonTaskService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname AssignmentController
 * @Description TODO
 * @Date 2020/08/14 14:15
 * @Created by hjchen
 */
@RestController
@RequestMapping("/assignment")
@Slf4j
public class AssignmentController extends BaseController {

    @Autowired
    private CommonTaskService commonTaskService;

    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public Map tree() {
        Map result = commonTaskService.tree();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        return result;
    }

    @RequestMapping(value = "/subtree", method = RequestMethod.GET)
    public Map subtree(SearchDict dict) {
        Map result = commonTaskService.subtree(dict);
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        return result;
    }

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public Map addGroup(@RequestBody(required = false) TaskGroupVo groupVo) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        int id = commonTaskService.saveTaskGroup(groupVo);
        result.put("id", id);
        return result;
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public Map addTask(@RequestBody(required = false) CommonTaskVo taskVo) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        int id = commonTaskService.saveTask(taskVo);
        result.put("id", id);
        return result;
    }


    @ApiOperation(value = "查看任务详情", notes = "根据id查看任务详情")
    @RequestMapping(value = "/taskInfo", method = RequestMethod.GET)
    public Map getTaskInfo(Integer id, Integer type) {
        Map result = new HashMap();
        if (id == null || type == null) {
            result.put("code", ResultDict.PARAMS_BLANK.getCode());
            result.put("msg", ResultDict.PARAMS_BLANK.getValue());
            return result;
        }
        Map data = commonTaskService.taskInfo(id, type);
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        result.putAll(data);
        return result;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Map addTask(@RequestBody(required = false) ProductVo productVo) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        int id = commonTaskService.saveProduct(productVo);
        result.put("id", id);
        return result;
    }

    @ApiOperation(value = "查看产品任务详情", notes = "根据id查看产品任务详情")
    @RequestMapping(value = "/productInfo", method = RequestMethod.GET)
    public Map productInfo(Integer id) {
        Map result = new HashMap();
        if (id == null) {
            result.put("code", ResultDict.PARAMS_BLANK.getCode());
            result.put("msg", ResultDict.PARAMS_BLANK.getValue());
            return result;
        }
        ProductVo product = commonTaskService.getProductById(id);
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        result.put("data", product);
        return result;
    }

    @ApiOperation(value = "修改产品任务", notes = "根据id修改产品任务")
    @RequestMapping(value = "/modifyProduct", method = RequestMethod.POST)
    public Map updateById(@RequestBody(required = false) ProductVo productVo) {
        Map result = new HashMap();
        commonTaskService.modifyProduct(productVo);
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        return result;
    }
}
