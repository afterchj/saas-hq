package com.maidi.saas.utils;

import com.aliyun.oss.*;
import com.aliyun.oss.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *文件上传下载工具类
 *@Author zhaojing
 *@Date 2020/8/14 15:11
 */
@Slf4j
@Configuration
public class AliYunOSSUtilS {

    /**
     * description:单文件上传大小限制配置
     * remark:任意有@Configuration注解的类下添加该方法即可
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize(DataSize.ofMegabytes(80));           //MB
        //设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofMegabytes(100));
        return factory.createMultipartConfig();
    }

    //文件上传
    public static String upload(File file) {
        log.info("=========>OSS文件上传开始：" + file.getName());
        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAI4G1dSiMJ8FQsYN26zSZ7";
        String accessKeySecret = "R6l66VPAXsY30cf7xU7vt1Ia0naN8Z";
        String bucketName = "qiyuan-2020";
        String fileHost = "picture";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());
        if (null == file) {
            return null;
        }
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            if (!ossClient.doesBucketExist(bucketName)) {
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
            }
            String fileUrl = fileHost + "/" + (dateStr + "/" + file.getName());
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
//            Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 *10);
//            String url = ossClient.generatePresignedUrl(bucketName,fileUrl,expiration).toString();
//            System.out.print("这个地址是："+url);
            if (null != result) {
                log.info("==========>OSS文件上传成功,OSS地址：" + fileUrl);
                return fileUrl;
            }
        } catch (OSSException oe) {
            log.error(oe.getMessage());
        } catch (ClientException ce) {
            log.error(ce.getMessage());
        } finally {
            ossClient.shutdown();
        }
        return null;
    }

    //服务器附件一览
    public static List<OSSObjectSummary> list() {
        final int maxKeys = 200;
        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAI4G1dSiMJ8FQsYN26zSZ7";
        String accessKeySecret = "R6l66VPAXsY30cf7xU7vt1Ia0naN8Z";
        String bucketName = "qiyuan-2020";
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ObjectListing objectListing = ossClient.listObjects(new ListObjectsRequest(bucketName).withMaxKeys(maxKeys));
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        return sums;
    }

    //文件下载
    public static OSSObject download(String objectName){
        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAI4G1dSiMJ8FQsYN26zSZ7";
        String accessKeySecret = "R6l66VPAXsY30cf7xU7vt1Ia0naN8Z";
        String bucketName = "qiyuan-2020";
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        OSSObject ossObject = ossClient.getObject(bucketName, objectName);
        return ossObject;
    }

    //删除文件
    public static void delete(String objectName) {
        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAI4G1dSiMJ8FQsYN26zSZ7";
        String accessKeySecret = "R6l66VPAXsY30cf7xU7vt1Ia0naN8Z";
        String bucketName = "qiyuan-2020";
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            ossClient.deleteObject(bucketName, objectName);
        } catch (OSSException oe) {
            log.error(oe.getMessage());
        } catch (ClientException ce) {
            log.error(ce.getMessage());
        } finally {
            ossClient.shutdown();
        }
    }

}



