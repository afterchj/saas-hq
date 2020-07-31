package com.maidi.saas.service;

import com.maidi.saas.entity.vo.Item;

import java.util.List;
import java.util.Map;

/**
 * @Classname CommonService
 * @Description TODO
 * @Date 2020/6/19 13:52
 * @Created by hjchen
 */
public interface CommonService {
    List<Item> getOptions(String tableName, String type);

    void insertUsers(Map map);
    void insertDict(String result);
}
