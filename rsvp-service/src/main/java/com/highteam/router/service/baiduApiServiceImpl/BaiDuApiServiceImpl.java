package com.highteam.router.service.baiduApiServiceImpl;


import com.baidu.aip.face.AipFace;
import com.highteam.router.common.config.BaiduConfig;
import org.json.JSONObject;

import java.util.HashMap;

public class BaiDuApiServiceImpl {

    public JSONObject detect(String image) {
        // 初始化一个AipFace
        AipFace client = new AipFace(BaiduConfig.appId, BaiduConfig.apiKey, BaiduConfig.secretKey);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age,beauty,expression,faceshape,gender,glasses,race,quality,facetype");
        options.put("max_face_num", "10");
        options.put("face_type", "LIVE");

        JSONObject res = client.detect(image, "BASE64", options);
        System.out.println(res.toString(2));
        return res;
    }

    public JSONObject search(String image, String groupId, String userId) {
        AipFace client = new AipFace(BaiduConfig.appId, BaiduConfig.apiKey, BaiduConfig.secretKey);
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");//: 一般
        options.put("liveness_control", "NORMAL");
        if (userId != null) {
            options.put("user_id", userId);//指定用户id即为用户认证
        }
        options.put("max_user_num", "1");

        // 人脸搜索
        JSONObject res = client.search(image, "BASE64", groupId, options);
        return res;

    }

    public static String getGroupUsers(AipFace client, String groupId) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("start", "0");
        options.put("length", "50");

        // 获取用户列表
        JSONObject res = client.getGroupUsers(groupId, options);
        System.out.println(res.toString(2));
        JSONObject user_id_list = (JSONObject) res.get("result");
        return user_id_list.get("user_id_list").toString();
    }
}
