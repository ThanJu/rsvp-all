package com.highteam.router.auth.service.impl;

import com.highteam.router.common.m.BusinessException;
import com.highteam.router.m.UserInfo;
import com.highteam.router.oauth2.model.CustomOAuth2AuthenticationInfo;
import com.highteam.router.oauth2.service.OAuth2AuthenService;
import com.highteam.router.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class OAuth2AuthenServiceImpl implements OAuth2AuthenService {


    @Autowired
    private LoginService loginService;

    @Override
    public Object auth(CustomOAuth2AuthenticationInfo info) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1);
        return userInfo;
    }

    @Override
    public Object auth(UsernamePasswordAuthenticationToken upToken) {

        Map<String, String> map = (Map<String, String>) upToken.getDetails();

        //取消图片验证码
        //this.checkVCode(map);

        CustomOAuth2AuthenticationInfo authInfo = new CustomOAuth2AuthenticationInfo();

        authInfo.setAuthType(map.get("authType"));
        authInfo.setEquipinfo(map.get("equipinfo"));
        authInfo.setClientIp(map.get("clientIp"));

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1);
        try {

            //手机验证码登录
            if ("phone".equals(authInfo.getAuthType())) {
                //取手机号
                //取验证码
                userInfo = loginService.phoneLogin(authInfo);
            }
            //二维码扫描登陆
            else if ("qrCode".equals(authInfo.getAuthType())) {
                //qrCode
                userInfo = loginService.qrCodeLogin(authInfo);
            }
            //密码登陆
            else if("password".equals(authInfo.getAuthType())){
                authInfo.setLoginName(upToken.getPrincipal().toString());
                authInfo.setPassword(upToken.getCredentials().toString());
                userInfo = loginService.passwordLogin(authInfo);
            }
            if (userInfo == null) {
                throw new BusinessException("LOGIN_ERROR", "登录失败");
            }
        } catch (BusinessException e) {
            throw new BusinessException("LOGIN_ERROR", e.getMessage());
        }
        return userInfo;
    }

}
