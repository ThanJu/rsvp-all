package com.highteam.router.request.dataRegister;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.common.m.PageList;
import com.highteam.router.common.m.PageParam;
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
import java.util.List;
import java.util.Map;

/**
 * 查询翻页注册信息
 * */
@Service
public class FetchDataRegisterPageList extends AbstractRouteAdapater {
    @Autowired
    private DataRegisterMapper dataRegisterMapper;

    @Override
    public Object getResponse(AppRequest appRequest, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> resultMap = new HashMap<>();
        JSONObject requestParam = JSON.parseObject(JSON.toJSONString(appRequest.getModel()));
        DataRegister dataRegisterDto = requestParam.getObject("dataRegister", DataRegister.class);
        Integer start = requestParam.getInteger("start");
        Integer limit = requestParam.getInteger("limit");
        if(dataRegisterDto == null){
            throw new BusinessException("请求参数不正确！");
        }
        PageParam<DataRegister> pageParam = new PageParam<>(dataRegisterDto);
        if(start != null){
            pageParam.setStart(start);
        }
        if(limit != null){
            pageParam.setLimit(limit);
        }
        List<DataRegister> list = dataRegisterMapper.selectPageListByParam(pageParam);
        int count = dataRegisterMapper.selectPageListCount(pageParam);
        return PageList.createPageList(list,count,pageParam);
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("dataRegister-dataRegister-fetchDataRegisterPageList").toString();
    }
}
