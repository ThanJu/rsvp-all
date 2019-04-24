package com.highteam.router.request.activitySignWay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.common.m.PageList;
import com.highteam.router.common.m.PageParam;
import com.highteam.router.dao.ActivitySignWayMapper;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.model.ActivitySignWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询翻页活动列表
 * */
@Service
public class FetchActivitySignWayPageList extends AbstractRouteAdapater {
    @Autowired
    private ActivitySignWayMapper activitySignWayMapper;

    @Override
    public Object getResponse(AppRequest appRequest, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> resultMap = new HashMap<>();
        JSONObject requestParam = JSON.parseObject(JSON.toJSONString(appRequest.getModel()));
        ActivitySignWay activitySignWayDto = requestParam.getObject("activitySignWay", ActivitySignWay.class);
        Integer start = requestParam.getInteger("start");
        Integer limit = requestParam.getInteger("limit");
        if(activitySignWayDto == null){
            throw new BusinessException("请求参数不正确！");
        }
        PageParam<ActivitySignWay> pageParam = new PageParam<>(activitySignWayDto);
        if(start != null){
            pageParam.setStart(start);
        }
        if(limit != null){
            pageParam.setLimit(limit);
        }
        List<ActivitySignWay> list = activitySignWayMapper.selectPageListByParam(pageParam);
        int count = activitySignWayMapper.selectPageListCount(pageParam);
        return PageList.createPageList(list,count,pageParam);
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("activitySignWay-activitySignWay-fetchActivitySignWayPageList").toString();
    }
}
