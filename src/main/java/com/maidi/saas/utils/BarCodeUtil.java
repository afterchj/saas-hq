package com.maidi.saas.utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.*;

/**
 *生成条形码
 *@Author zhaojing
 *@Date 2020/8/14 15:35
 */
@Slf4j
@Configuration
@Component
public class BarCodeUtil {

    /**
     *生成文件条形码图片
     *@Name    getBarCode
     *@params  [msg]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/8/18 14:30
     */
    public static String getBarCode(String msg){
        String upload=null;
        try {
            File file=new File("E://java资源//"+msg+".jpg");
            OutputStream ous=new FileOutputStream(file);
            if(StringUtils.isEmpty(msg) || ous==null)
                return upload;
            //选择条形码类型(好多类型可供选择)
            Code128Bean bean=new Code128Bean();
            //设置长宽
            final double moduleWidth=0.20;
            final int resolution=150;
            bean.setModuleWidth(moduleWidth);
            bean.doQuietZone(false);
            String format = "image/png";
            // 输出流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format,
                    resolution, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            //生成条码
            bean.generateBarcode(canvas,msg);
            canvas.finish();

            //将生成的条形码图片上传至文件服务器
            //File file1 = new File("E://java资源//"+msg+".jpg");
            upload = AliYunOSSUtilS.upload(file);
            System.out.println(upload);
            //删除本地文件
            if (file.isFile() && file.exists()) {
             file.delete();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
     return  upload;
    }

    /**
     *生成版本号
     *@Name    creatVersion
     *@params  [version]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/8/21 10:50
     */
    public static String creatVersion(String version){
        Integer i1;
        Integer i2;
        if(StringUtils.isEmpty(version)){
            return "V1.0";
        }else{
            String two = version.substring(1, 2);
            String four = version.substring(3, 4);
            if(four.equals("9")){
                i1=Integer.valueOf(two).intValue()+1;
                i2=0;
            }else{
                i1=Integer.valueOf(two).intValue();
                i2=Integer.valueOf(four).intValue()+1;
            }
        }
        return "V"+i1+"."+i2;
    }

    public static void main(String[] args) {
        //http://qiyuan-2020.oss-cn-hangzhou.aliyuncs.com:80
        String msg = "njvnk1212";
        String path = "E://java资源//"+msg+".jpg";

        getBarCode(msg);

        File file = new File(path);//File类型可以是文件也可以是文件夹
        String upload = AliYunOSSUtilS.upload(file);
        System.out.println(upload);
    }
}
