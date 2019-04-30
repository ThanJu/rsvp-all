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
 * 根据注册信息参数查询信息
 */
@Service
public class FetchRegisterBySearch extends AbstractRouteAdapater {
    @Autowired
    private DataRegisterMapper dataRegisterMapper;

    @Override
    public Object getResponse(AppRequest appRequest, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<>();
        JSONObject requestParam = JSON.parseObject(JSON.toJSONString(appRequest.getModel()));
        int activityInfoId = requestParam.getInteger("activityInfoId");
        String searchVal = requestParam.getString("searchVal");
        if (activityInfoId == 0) {
            throw new BusinessException("请求参数不正确！");
        }
        DataRegister dataRegister = new DataRegister();
        dataRegister.setActivityInfoId(activityInfoId);
        dataRegister.setQrCode(searchVal);
        dataRegister.setUserName(searchVal);
        dataRegister.setWorkPhone(searchVal);
        List<DataRegister> dataRegisterList = dataRegisterMapper.selectBySearch(dataRegister);
        return dataRegisterList;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("dataRegister-dataRegister-fetchRegisterBySearch").toString();
    }
}
