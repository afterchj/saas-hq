package com.maidi.saas;

import com.alibaba.fastjson.JSON;
import com.maidi.saas.entity.vo.TaskRecordVo;
import com.maidi.saas.utils.PingYinUtil;
import org.junit.Test;
import sun.rmi.runtime.Log;

import java.time.LocalDate;

/**
 * @Classname MyTest
 * @Description TODO
 * @Date 2020/07/14 10:28
 * @Created by hjchen
 */

public class MyTest {

    @Test
    public void testStr() {
        System.out.println(JSON.toJSONString(new TaskRecordVo()));
        String str = "p_1";
        String suffix = str.substring(str.indexOf("_") + 1, str.length());
        System.out.println(suffix);
        System.out.println(String.format("project_%s", PingYinUtil.getFirstSpell("测试项目爱")));
        System.out.println(PingYinUtil.getFullSpell("测试项目爱"));
        System.out.println(String.format("V_%s", LocalDate.now()));
    }
}
