package com.maidi.saas.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maidi.saas.dao.CommonDao;
import com.maidi.saas.entity.vo.DictVo;
import com.maidi.saas.entity.vo.Item;
import com.maidi.saas.entity.vo.OptionDict;
import com.maidi.saas.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Classname CommonServiceImpl
 * @Description TODO
 * @Date 2020/6/19 13:53
 * @Created by hjchen
 */

@Service
@Slf4j
public class CommonServiceImpl implements CommonService {


    @Autowired
    private CommonDao commonDao;

    @Override
    public List<Item> getOptions(String tableName, String type) {
        return commonDao.getOptions(tableName, type);
    }

    @Override
    public void insertUsers(Map map) {
        commonDao.insertUser(map);
    }

    @Override
    public void insertDict(String result) {
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONObject data = Optional.ofNullable(jsonObject).map(object -> object.getJSONObject("data")).orElse(null);
        String stage = Optional.ofNullable(data).map(object -> object.getString("stage")).orElse("nothing");
        String type = Optional.ofNullable(data).map(object -> object.getString("type")).orElse("nothing");
        List<DictVo> stages = JSON.parseArray(stage, DictVo.class);
        List<DictVo> types = JSON.parseArray(type, DictVo.class);
        Map params1 = new HashMap();
        Map params2 = new HashMap();
        params1.put("list", stages);
        params1.put("type", "1");
        params2.put("list", types);
        params2.put("type", "2");
        log.warn("params1 {}",params1);
        log.warn("params2 {}",params2);
        commonDao.insertDict(params1);
        commonDao.insertDict(params2);
    }
}
