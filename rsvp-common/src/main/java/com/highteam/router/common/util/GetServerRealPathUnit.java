package com.highteam.router.common.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class GetServerRealPathUnit {

    public static String  getPath(String filepath){

        File upload = null;
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) path = new File("");
            upload = new File(path.getAbsolutePath(),filepath);
            if(!upload.exists()) upload.mkdirs();//如果不存在则创建目录
            String realPath = upload + "/";
            return realPath;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("获取服务器路径发生错误！");
        }
    }
}
