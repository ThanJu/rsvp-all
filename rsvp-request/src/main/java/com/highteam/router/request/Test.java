package com.highteam.router.request;

import com.highteam.router.api.AbstractRouteAdapater;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Service
public class Test extends AbstractRouteAdapater {
    @Override
    public Object getResponse(AppRequest param, UserInfo userInfo, RequestPath path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return userInfo;
    }

    @Override
    public String getRoutePath() {
        return new RequestPath("test-test-test").toString();
    }


}
