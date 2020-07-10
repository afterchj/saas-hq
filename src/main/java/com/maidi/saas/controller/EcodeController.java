package com.maidi.saas.controller;

import com.maidi.saas.entity.dd.ResultDict;
import com.maidi.saas.entity.vo.EcodeVo;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.Item;
import com.maidi.saas.service.CommonService;
import com.maidi.saas.service.EcodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname EcodeController
 * @Description TODO
 * @Date 2020/6/15 11:03
 * @Created by hjchen
 */

@RestController
@Api(description = "Ecode维护API接口")
@RequestMapping("/ecode")
@Slf4j
public class EcodeController extends BaseController {

    @Autowired
    private EcodeService ecodeService;

    @Autowired
    private CommonService commonService;

    @GetMapping
    @ApiOperation(value = "获取下拉列表", notes = "返回新增ecode需要选择的下拉项")
    public Map option() {
        Map data = new HashMap();
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<Item> projects = commonService.getOptions("sm_project", "");
        List<Item> modules = commonService.getOptions("sm_module", "");
        data.put("project", projects);
        data.put("module", modules);
        result.put("data", data);
        return result;
    }

    @ApiOperation(value = "Ecode查看", notes = "根据ID查询Ecode")
    @RequestMapping(value = "/getEcodeById", method = RequestMethod.GET)
    public Map getProjectById(Integer id) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        EcodeVo projectVo = ecodeService.getEcodeById(id);
        result.put("data", projectVo);
        return result;
    }

    @ApiOperation(value = "Ecode查询", notes = "根据条件查询Ecode列表")
    @RequestMapping(value = "/queryList")
    public Map queryProject(SearchDict dict) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<EcodeVo> projectQueries = ecodeService.queryEcode(dict);
        result.put("data", projectQueries);
        return result;
    }


    @ApiOperation(value = "创建Ecode", notes = " 新增Ecode")
    @RequestMapping(value = "/addEcode", method = RequestMethod.POST)
    public Map create(@RequestBody EcodeVo ecodeVo) {
        log.warn("ecodeVo {}", ecodeVo);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        int id = ecodeService.save(ecodeVo);
        log.warn("id {}", id);
        return result;
    }

    @ApiOperation(value = "修改Ecode", notes = "根据id修改Ecode")
    @RequestMapping(value = "/editEcode", method = RequestMethod.POST)
    public Map edit(@RequestBody(required = false) EcodeVo ecodeVo) {
        log.warn("id {} ecodeVo {}", ecodeVo.getId(), ecodeVo);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        ecodeService.update(ecodeVo);
        return result;
    }

    @ApiOperation(value = "删除Ecode", notes = "根据ID删除Ecode")
    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public Map deleteEcodeById(Integer id) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        ecodeService.deleteById(id);
        return result;
    }

    @ApiOperation(value = "停用Ecode", notes = "批量停用Ecode")
    @RequestMapping(value = "/disenable", method = RequestMethod.GET)
    public Map deleteEcodeById(String id, Integer operatorId, Boolean status) {
        Map params = new HashMap();
        params.put("status", status);
        params.put("operatorId", operatorId);
        log.warn("id {} params {}", id, params);
        String[] ids = id.split(",");
        params.put("list", ids);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        ecodeService.updateStatus(params);
        return result;
    }

}
