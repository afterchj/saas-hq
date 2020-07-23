package com.maidi.saas.utils;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Classname OssPropertiesUtils
 * @Description TODO
 * @Date 2020/07/23 15:24
 * @Created by hjchen
 */
@Component
@Data
public class OssPropertiesUtils implements InitializingBean {

    @Value("${oss.file.endpoint}")
    private String endPoint;

    @Value("${oss.file.keyId}")
    private String keyId;

    @Value("${oss.file.keySecret}")
    private String keySecret;

    @Value("${oss.file.bucketName}")
    private String bucketName;

    @Value("${oss.file.fileHost}")
    private String fileHost;

    public static String ENDPOINT;
    public static String KEYID;
    public static String KEYSECRET;
    public static String BUCKETNAME;
    public static String FILEHOST;

    @Override
    public void afterPropertiesSet() throws Exception {
        ENDPOINT = endPoint;
        KEYID = keyId;
        KEYSECRET = keySecret;
        BUCKETNAME = bucketName;
        FILEHOST = fileHost;
    }
}
