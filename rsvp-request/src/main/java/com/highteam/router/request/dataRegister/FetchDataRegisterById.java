package com.highteam.router.request.dataRegister;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.dao.DataRegisterMapper;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.model.DataRegister;
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
public class FetchDataRegisterById extends AbstractRouteAdapater {

    @Autowired
    private DataRegisterMapper dataRegisterMapper;

    @Override
    public Object getResponse(AppRequest appRequest, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> resultMap = new HashMap<>();
        JSONObject requestParam = JSON.parseObject(JSON.toJSONString(appRequest.getModel()));
        Integer id = requestParam.getInteger("dataRegisterId");
        if(id == null){
            throw new BusinessException("请求参数不正确！");
        }
        DataRegister dataRegister = dataRegisterMapper.selectByPrimaryKey(id);
        if(dataRegister == null){
            throw new BusinessException("没有找到这条记录");
        }
        return dataRegister;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("dataRegister-dataRegister-fetchDataRegisterById").toString();
    }

}
