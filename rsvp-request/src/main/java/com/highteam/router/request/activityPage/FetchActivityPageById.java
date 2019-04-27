package com.highteam.router.request.activityPage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.common.m.BusinessException;
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
import java.util.Map;

/**
 * 通过id查询活动配置页面
 */
@Service
public class FetchActivityPageById extends AbstractRouteAdapater {

    @Autowired
    private ActivityPageMapper activityPageMapper;

    @Override
    public Object getResponse(AppRequest appRequest, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> resultMap = new HashMap<>();
        JSONObject requestParam = JSON.parseObject(JSON.toJSONString(appRequest.getModel()));
        Integer id = requestParam.getInteger("activityPageId");
        if(id == null){
            throw new BusinessException("请求参数不正确！");
        }
        ActivityPage activityPage = activityPageMapper.selectByPrimaryKey(id);
        if(activityPage == null){
            throw new BusinessException("没有找到这条记录");
        }
        return activityPage;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("activityPage-activityPage-fetchActivityPageById").toString();
    }

}
