package com.highteam.router.request.dataSign;

import com.alibaba.fastjson.JSON;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.dao.DataSignMapper;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.service.baiduApiServiceImpl.BaiDuApiServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class FaceDiscernSign extends AbstractRouteAdapater {

    private  BaiDuApiServiceImpl baiDuApiService = new BaiDuApiServiceImpl();

    @Autowired
    private DataSignMapper dataSignMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Object getResponse(AppRequest param, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        com.alibaba.fastjson.JSONObject requestParam = com.alibaba.fastjson.JSONObject.parseObject(JSON.toJSONString(param.getModel()));
        Map<String, Object> map = new HashMap<>();
        try {
            //保存人脸照片
//            String day = new SimpleDateFormat("yyyyMMdd").format(new Date());
//            String basePath = GetServerRealPathUnit.getPath("/static/img_drs/" + day + "/");
//            //项目根目录
//            String path = request.getScheme() + ":" + File.separator + File.separator + request.getServerName() + ":" + request.getServerPort() + File.separator;
//            String packageId = request.getParameter("packageId");
//            String fileName = packageId + new Date().getTime() + ".png";
//            String filePath = basePath + fileName;
//            FileUtil.GenerateFilePath(filePath);
//            FileUtil.decoderBase64File(imgStr, filePath);

            //默认传入的参数带类型等参数：data:image/png;base64,
            String imgStr = requestParam.getString("image");
            if (null != imgStr) {
                imgStr = imgStr.substring(imgStr.indexOf(",") + 1);
            }

            //人脸识别
            org.json.JSONObject faceObj = baiDuApiService.detect(imgStr);
            //人脸搜索
            JSONObject jsonObject = baiDuApiService.search(imgStr, "star",null);


            //返回验证结果，
            map.put("compareObj", jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("dataSign-dataSign-faceDiscernSign").toString();
    }
}
