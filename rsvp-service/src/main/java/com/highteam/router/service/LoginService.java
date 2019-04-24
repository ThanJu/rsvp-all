package com.highteam.router.service;
import com.highteam.router.m.UserInfo;
import com.highteam.router.oauth2.model.CustomOAuth2AuthenticationInfo;
import org.springframework.stereotype.Service;

public interface LoginService {

    UserInfo passwordLogin(CustomOAuth2AuthenticationInfo info);

    UserInfo qrCodeLogin(CustomOAuth2AuthenticationInfo info);

    UserInfo phoneLogin(CustomOAuth2AuthenticationInfo info);
}
