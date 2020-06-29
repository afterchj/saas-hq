package com.maidi.saas.dao;

import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.*;

import java.util.List;
import java.util.Map;

/**
 * @Classname EcodeDao
 * @Description TODO
 * @Date 2020/6/8 14:39
 * @Created by hjchen
 */
public interface EcodeDao {

    EcodeVo getEcodeById(int id);

    int saveEcode(EcodeVo ecodeVo);

    void updateEcodeById(EcodeVo ecodeVo);

    List<EcodeVo> queryEcode(SearchDict map);

    void deleteEcodeById(int id);

    void updateStatus(Map map);
}
