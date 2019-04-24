package com.highteam.router.service.impl;

import com.highteam.router.m.UserInfo;
import com.highteam.router.oauth2.model.CustomOAuth2AuthenticationInfo;
import com.highteam.router.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public UserInfo passwordLogin(CustomOAuth2AuthenticationInfo info) {
        return null;
    }

    @Override
    public UserInfo qrCodeLogin(CustomOAuth2AuthenticationInfo info) {
        return null;
    }
    @Override
    public UserInfo phoneLogin(CustomOAuth2AuthenticationInfo info) {
        return null;
    }
}
