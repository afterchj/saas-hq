package com.maidi.saas.utils;


import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @Classname IdGenerator
 * @Description TODO
 * @Date 2020/6/3 10:28
 * @Created by hjchen
 */

@Slf4j
@Component
public class IdGenerator {
    private long workerId = 0;

    @PostConstruct
    void init() {
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器 workerId: {}", workerId);
        } catch (Exception e) {
            log.warn("获取机器 ID 失败", e);
            workerId = NetUtil.getLocalhost().hashCode();
            log.info("当前机器 workerId: {}", workerId);
        }
    }

    /**
     * 获取一个批次号，形如 2019071015301361000101237
     * <p>
     * 数据库使用 char(25) 存储
     *
     * @param tenantId 租户ID，5 位
     * @param module   业务模块ID，2 位
     * @return 返回批次号
     */
    public synchronized String batchId(int tenantId, int module) {
        String prefix = DateTime.now().toString(DatePattern.PURE_DATETIME_MS_PATTERN);
        return prefix + tenantId + module + RandomUtil.randomNumbers(3);
    }

    @Deprecated
    public synchronized String getBatchId(int tenantId, int module) {
        return batchId(tenantId, module);
    }

    /**
     * 生成的是不带-的字符串，类似于：b17f24ff026d40949c85a24f4f375d42
     *
     * @return
     */
    public String simpleUUID() {
        return IdUtil.simpleUUID();
    }

    /**
     * 生成的UUID是带-的字符串，类似于：a5c8a5e8-df2b-4706-bea4-08d0939410e3
     *
     * @return
     */
    public String randomUUID() {
        return IdUtil.randomUUID();
    }

    private Snowflake snowflake = IdUtil.createSnowflake(workerId, 1);


    public synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long dataCenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, dataCenterId);
        return snowflake.nextId();
    }

    /**
     * 生成类似：5b9e306a4df4f8c54a39fb0c
     * <p>
     * ObjectId 是 MongoDB 数据库的一种唯一 ID 生成策略，
     * 是 UUID version1 的变种，详细介绍可见：服务化框架－分布式 Unique ID 的生成方法一览。
     *
     * @return
     */
    public String objectId() {
        return ObjectId.next();
    }

    public static String generateAccount(int length) {
        String account;
        do {
            account = getCharAndNum(length);
        } while (!IdGenerator.check(account));
        return account;
    }

    private static String getCharAndNum(int length) {
        String val = "";
        String charOrNum;
        int num1 = 0;
        int num2 = 0;
        String reg = "^.*\\d{3}.*$";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            if (num1 == 5) {
                if (num2 == 0) {
                    val = val.substring(0, val.length() - 1);
                    i--;
                    num1--;
                }
                charOrNum = "num";
            } else if (num2 == 3) {
                if (val.matches(reg)) {
                    val = val.substring(0, val.length() - 1);
                    i--;
                    num2--;
                }
                charOrNum = "char";
            } else {
                charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            }
            int isDuplicateNum;
            int randomValue;
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                // int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                do {
                    isDuplicateNum = 0;
                    randomValue = 65 + random.nextInt(26);
                    char[] arr = val.toCharArray();
                    for (int j = 0; j < arr.length; j++) {
                        if (randomValue == arr[j]) {
                            isDuplicateNum++;
                        }
                    }
                } while (isDuplicateNum == 2);
                val += (char) randomValue;
                num1++;
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                if (num2 == 2) {
                    do {
                        isDuplicateNum = 0;
                        randomValue = random.nextInt(10);
                        String[] arr = val.split("");
                        for (int j = 0; j < arr.length; j++) {
                            if (String.valueOf(randomValue).equals(arr[j])) {
                                isDuplicateNum++;
                            }
                        }
                    } while (isDuplicateNum == 2);
                } else {
                    randomValue = random.nextInt(10);
                }
                val += String.valueOf(randomValue);
                num2++;
            }
        }
        return val;
    }


    public static boolean check(String str) {
        char[] arr = str.toCharArray();
        boolean flag = true;
        for (int i = 1; i < arr.length - 1; i++) {
            int firstIndex = (int) arr[i - 1];
            int secondIndex = (int) arr[i];
            int thirdIndex = (int) arr[i + 1];
            if ((thirdIndex - secondIndex == 1) && (secondIndex - firstIndex == 1)) {
                flag = false;
            }
        }
        return flag;
    }

    public static String generateToken() {
        String token = "";
        try {
            token = UUID.randomUUID().toString().replaceAll("-", "");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return token;
    }
}
