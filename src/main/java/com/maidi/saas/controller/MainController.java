package com.maidi.saas.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maidi.saas.entity.dd.ResultDict;
import com.maidi.saas.entity.vo.Item;
import com.maidi.saas.entity.vo.OptionDict;
import com.maidi.saas.entity.vo.UserVo;
import com.maidi.saas.service.CommonService;
import com.maidi.saas.service.ProjectService;
import com.maidi.saas.service.ZuulUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname MainController
 * @Description TODO
 * @Date 2020/6/19 15:59
 * @Created by hjchen
 */

@RestController
@Slf4j
public class MainController extends BaseController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private ZuulUserService zuulUserService;

    @RequestMapping("/batch")
    public String batchInsertUser() {
        String result = zuulUserService.getAllUser();
        JSONObject jsonObject = JSONObject.parseObject(result);
        String data = jsonObject.getString("data");
        List<UserVo> items = JSON.parseArray(data, UserVo.class);
        Map params = new HashMap();
        params.put("list", items);
        commonService.insertUsers(params);
        return "ok";
    }

    @RequestMapping(value = "/user/item", method = RequestMethod.GET)
    public Map users() {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<Item> users = commonService.getOptions("sm_user",null);
        result.put("data", users);
        return result;
    }

    @RequestMapping(value = "/dict/item", method = RequestMethod.GET)
    public Map dicts() {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<Item> dicts = commonService.getOptions("sm_dict","");
        result.put("data", dicts);
        return result;
    }
}
