package com.maidi.saas.service;

import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.*;

import java.util.List;
import java.util.Map;

/**
 * @Classname ProjectService
 * @Description TODO
 * @Date 2020/6/8 14:39
 * @Created by hjchen
 */
public interface EcodeService {

    int save(EcodeVo ecodeVo);

    void deleteById(int id);

    void update(EcodeVo ecodeVo);

    EcodeVo getEcodeById(int id);

    List<EcodeVo> queryEcode(SearchDict dict);

    void updateStatus(Map map);
}
