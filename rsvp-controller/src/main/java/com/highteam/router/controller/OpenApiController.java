package com.highteam.router.controller;

import com.highteam.router.api.BusinessExecuteService;
import com.highteam.router.api.RouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.UserInfo;
import com.highteam.router.s.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                if(adpater.requiredAuthor()){
                    throw new BusinessException("AUTH_ERROR","This is a protected request!");
                }
            }
        });
    }


}
