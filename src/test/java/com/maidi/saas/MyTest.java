package com.maidi.saas;

import org.junit.Test;

/**
 * @Classname MyTest
 * @Description TODO
 * @Date 2020/07/14 10:28
 * @Created by hjchen
 */
public class MyTest {

    @Test
    public void testStr() {
        String str = "p_1";
        String sufrix = str.substring(str.indexOf("_")+1, str.length());
        System.out.println(sufrix);
    }
}
