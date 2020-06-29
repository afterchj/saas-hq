package com.maidi.saas.service.impl;

import com.maidi.saas.dao.EcodeDao;
import com.maidi.saas.entity.vo.EcodeVo;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.service.EcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname EcodeServiceImpl
 * @Description TODO
 * @Date 2020/6/15 13:53
 * @Created by hjchen
 */

@Service
public class EcodeServiceImpl implements EcodeService {

    @Autowired
    private EcodeDao ecodeDao;

    @Override
    public int save(EcodeVo ecodeVo) {
        ecodeDao.saveEcode(ecodeVo);
        return ecodeVo.getId();
    }

    @Override
    public void deleteById(int id) {
        ecodeDao.deleteEcodeById(id);
    }

    @Override
    public void update(EcodeVo ecodeVo) {
        ecodeDao.updateEcodeById(ecodeVo);
    }

    @Override
    public EcodeVo getEcodeById(int id) {
        return ecodeDao.getEcodeById(id);
    }

    @Override
    public List<EcodeVo> queryEcode(SearchDict dict) {
        return ecodeDao.queryEcode(dict);
    }

    @Override
    public void updateStatus(Map map) {
        ecodeDao.updateStatus(map);
    }
}
