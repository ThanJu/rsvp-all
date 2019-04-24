package com.highteam.router.request.dataSign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.dao.DataSignMapper;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.model.DataSign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过id获取活动信息
 */
@Service
public class FetchDataSignById extends AbstractRouteAdapater {

    @Autowired
    private DataSignMapper dataSignMapper;

    @Override
    public Object getResponse(AppRequest appRequest, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> resultMap = new HashMap<>();
        JSONObject requestParam = JSON.parseObject(JSON.toJSONString(appRequest.getModel()));
        Integer id = requestParam.getInteger("dataSignId");
        if(id == null){
            throw new BusinessException("请求参数不正确！");
        }
        DataSign dataSign = dataSignMapper.selectByPrimaryKey(id);
        if(dataSign == null){
            throw new BusinessException("没有找到这条记录");
        }
        return dataSign;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("dataSign-dataSign-fetchDataSignById").toString();
    }

}
