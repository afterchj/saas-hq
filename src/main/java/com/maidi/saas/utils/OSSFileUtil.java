package com.maidi.saas.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.File;

/**
 * @Classname OSSFileUtil
 * @Description TODO
 * @Date 2020/07/23 15:33
 * @Created by hjchen
 */
public class OSSFileUtil {
    private static OSS ossClient;
    private static String endpoint;
    private static String accessKeyId;
    private static String accessKeySecret;
    private static String bucketName;
    private static String fileHost;

    static {
        endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        accessKeyId = "LTAI4G1dSiMJ8FQsYN26zSZ7";
        accessKeySecret = "R6l66VPAXsY30cf7xU7vt1Ia0naN8Z";
        bucketName = "qiyuan-2020";
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        fileHost = "ssm";
    }

    public static String upload(String fileName, File file) {
        // 创建OSSClient实例。
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String targetFile = fileHost + "/" + fileName;
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, targetFile, file);
        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
        // ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);
        // 上传文件。
        ossClient.putObject(putObjectRequest);
        // 关闭OSSClient。
        ossClient.shutdown();
        return targetFile;
    }

    public static void delete(String objectName) {
        // 创建OSSClient实例。
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 删除文件。
        ossClient.deleteObject(bucketName, objectName);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void list() {
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // ossClient.listObjects返回ObjectListing实例，包含此次listObject请求的返回结果。
        ObjectListing objectListing = ossClient.listObjects(bucketName,"ssm");
        // objectListing.getObjectSummaries获取所有文件的描述信息。
        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            System.out.println(" - " + objectSummary.getKey() + "  " + "(size = " + objectSummary.getSize() + ")");
        }
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void main(String[] args) {
        File file = new File("E:/mnt/ECODE维护.docx");
        String fileName = "ECODE维护.docx";
        String targetFile = fileHost + "/" + fileName;
//        upload(fileName, file);
//        delete(targetFile);
        list();
    }

}
