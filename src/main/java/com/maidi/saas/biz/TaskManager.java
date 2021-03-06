package com.maidi.saas.biz;

import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.CommonTaskVo;

import java.util.Map;

/**
 * @Classname TaskManager
 * @Description TODO
 * @Date 2020/08/19 15:11
 * @Created by hjchen
 */
public interface TaskManager {

    Map tree();

    Map subtree(SearchDict dict);

    Map taskInfo(int id, int type);
}
