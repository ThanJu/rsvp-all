package com.highteam.router.request.dataSign;

import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.dao.DataSignMapper;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.service.baiduApiServiceImpl.BaiDuApiServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class faceDiscernSign  extends AbstractRouteAdapater {

    @Autowired
    private BaiDuApiServiceImpl baiDuApiService;

    @Autowired
    private DataSignMapper dataSignMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Object getResponse(AppRequest param, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) throws Exception {

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
            String imgStr = request.getParameter("image");
            if (null != imgStr) {
                imgStr = imgStr.substring(imgStr.indexOf(",") + 1);
            }

            //人脸识别
            org.json.JSONObject faceObj = baiDuApiService.detect(imgStr);
            //人脸搜索
            JSONObject jsonObject = baiDuApiService.search(imgStr, "star");

//            map.put("compareObj", jsonObject.toString());
//            map.put("faceObj", faceObj.toString());

            //返回验证结果，却有此人
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

    @Override
    public boolean requiredAuthor() {
        return false;
    }
}
