package com.maidi.saas.dao;

import com.maidi.saas.entity.vo.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Classname CommonDao
 * @Description TODO
 * @Date 2020/6/8 14:39
 * @Created by hjchen
 */
public interface CommonDao {

    List<Item> getOptions(@Param("tableName") String tableName,@Param("type") String type);
    void insertUser(Map map);
    void insertDict(Map map);

}
