package com.maidi.saas.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @Classname IdUtil
 * @Description TODO
 * @Date 2020/07/10 15:04
 * @Created by hjchen
 */
public class IdUtil {

    public static int paresId(String str) {
        int id = 0;
        if (StringUtils.isNotBlank(str)) {
            if (str.contains("_")) {
                id = Integer.parseInt(str.substring(str.lastIndexOf("_") + 1, str.length()));
            } else {
                id = Integer.parseInt(str);
            }
        }
        return id;
    }
}
