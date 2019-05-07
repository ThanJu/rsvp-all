package com.highteam.router.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.BusinessExecuteService;
import com.highteam.router.api.RouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.UserInfo;
import com.highteam.router.oauth2.model.OAuth2Request;
import com.highteam.router.s.CurrentUser;
import org.json.JSONStringer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/obs")
public class OpenApiController extends AuthApiController {

    @RequestMapping(value = "/business", method = RequestMethod.POST)
    @ResponseBody
    public Object postindex(@CurrentUser UserInfo userInfo, @RequestBody AppRequest param, HttpServletRequest serRequest,
                            HttpServletResponse serResponse) {
        return requestGateWayCore.request(userInfo, param, serRequest, serResponse, new BusinessExecuteService() {
            @Override
            public void preExecute(RouteAdapater adpater) {
                if (adpater.requiredAuthor()) {
                    throw new BusinessException("AUTH_ERROR", "This is a protected request!");
                }
            }
        });
    }

    /**
     * 消费者接口，面向生产者推送
     * 百度人脸注册
     *
     * @param serRequest
     * @param serResponse
     * @param br
     * @return
     */
    @RequestMapping(value = "/faceRegister", method = RequestMethod.POST)
    public Object pushReception( HttpServletRequest serRequest,HttpServletResponse serResponse, BufferedReader br) {
        AppRequest param= new AppRequest();
        //body部分
        String inputLine;
        String str = "";
        Map<String, Object> map = new HashMap<>();
        try {
            //取请求body信息
            while ((inputLine = br.readLine()) != null) {
                str += inputLine;
            }
            br.close();
            //"str:{\"optType\":3,\"applyId\":3311,\"uUserId\":\"17611030057\",\"projectToken\":\"228C80FEA87149E293C6F960D2F3817E\"}";
            String paramStr = str.substring(str.indexOf("{"), str.lastIndexOf("}") + 1);
            JSONObject jsonObj = JSON.parseObject(paramStr);
            param.setModel(JSONObject.toJavaObject(jsonObj, Map.class));
            param.setBusinessParam("dataRegister-dataRegister-faceRegister");
            map.put("logId", param.getModel().get("logId"));
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        OAuth2Request oAuth2Request = requestGateWayCore.request(new UserInfo(), param, serRequest, serResponse, null);
        if (oAuth2Request.getStatus()){
            map.put("errorCode", 0);
            map.put("errorMsg", "同步成功");
        }else{
            map.put("errorCode", 1);
            map.put("errorMsg", "同步失败");
        }
        return  map;
    }


}
