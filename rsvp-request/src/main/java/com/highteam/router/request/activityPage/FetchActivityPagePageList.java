package com.highteam.router.request.activityPage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.common.m.PageList;
import com.highteam.router.common.m.PageParam;
import com.highteam.router.dao.ActivityPageMapper;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.model.ActivityPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询可翻页活动页面列表
 * */
@Service
public class FetchActivityPagePageList extends AbstractRouteAdapater {
    @Autowired
    private ActivityPageMapper activityPageMapper;

    @Override
    public Object getResponse(AppRequest appRequest, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> resultMap = new HashMap<>();
        JSONObject requestParam = JSON.parseObject(JSON.toJSONString(appRequest.getModel()));
        ActivityPage activityPageDto = requestParam.getObject("activityPage", ActivityPage.class);
        Integer start = requestParam.getInteger("start");
        Integer limit = requestParam.getInteger("limit");
        if(activityPageDto == null){
            throw new BusinessException("请求参数不正确！");
        }
        PageParam<ActivityPage> pageParam = new PageParam<>(activityPageDto);
        if(start != null){
            pageParam.setStart(start);
        }
        if(limit != null){
            pageParam.setLimit(limit);
        }
        List<ActivityPage> list = activityPageMapper.selectPageListByParam(pageParam);
        int count = activityPageMapper.selectPageListCount(pageParam);
        return PageList.createPageList(list,count,pageParam);
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("activityPage-activityPage-fetchActivityPagePageList").toString();
    }
}
