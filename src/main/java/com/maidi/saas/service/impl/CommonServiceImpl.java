package com.maidi.saas.service.impl;

import com.maidi.saas.dao.CommonDao;
import com.maidi.saas.entity.vo.Item;
import com.maidi.saas.entity.vo.OptionDict;
import com.maidi.saas.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname CommonServiceImpl
 * @Description TODO
 * @Date 2020/6/19 13:53
 * @Created by hjchen
 */

@Service
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
}
