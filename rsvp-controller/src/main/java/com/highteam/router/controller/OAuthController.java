package com.highteam.router.controller;


import com.highteam.router.common.util.Utils;
import com.highteam.router.common.vcode.ValidateCodeControl;
import com.highteam.router.oauth2.config.OAuth2Config;
import com.highteam.router.oauth2.interceptor.BaseInfoResolver;
import com.highteam.router.oauth2.model.OAuth2Request;
import com.highteam.router.oauth2.provider.UserAuthCookieProvider;
import com.highteam.router.oauth2.service.OAuth2RequestStateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/oauth")
public class OAuthController {

	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	private OAuth2Config config;

	@RequestMapping("/revoke-token")
	@ResponseBody
	public Object revoke(HttpServletRequest servletRequest, HttpServletResponse response) {
		OAuth2Request request = new OAuth2Request();
		try {
			request.setStatus(true);
			request.setCode(OAuth2RequestStateCodeService.OK);
			new BaseInfoResolver(servletRequest,tokenStore).remove();
			new UserAuthCookieProvider(config,response).loginOutCookie(servletRequest);
		}catch (Exception e) {
			e.printStackTrace();
			request.setStatus(false);
			request.setCode(OAuth2RequestStateCodeService.INTERNAL_SERVER_ERROR);
			request.setMsg(e.getMessage());
		}
		return request;
		
	}
	
	@RequestMapping(value="/createcookie",method= RequestMethod.POST)
	@ResponseBody
	public Object createcookie(HttpServletRequest servletRequest,HttpServletResponse response) {
		OAuth2Request request = new OAuth2Request();	
		try {
			request.setStatus(true);
			request.setCode(OAuth2RequestStateCodeService.OK);
			new UserAuthCookieProvider(config,response).createCookie(new BaseInfoResolver(servletRequest,tokenStore).getToken());
		}catch (Exception e) {
			e.printStackTrace();
			request.setStatus(false);
			request.setCode(OAuth2RequestStateCodeService.UNAUTHORIZED);
			request.setMsg(e.getMessage());
		}
		return request;
	}

	@RequestMapping(value="/generateVCode",method= RequestMethod.GET)
	@ResponseBody
	public void createVerifyCode(HttpServletRequest servletRequest,HttpServletResponse response) {
		ValidateCodeControl codeControl = new ValidateCodeControl(servletRequest,response);
		String code = Utils.createRandom(false,4);
		try {
			codeControl.createNewCookie(code);
			Utils.createVCodeImage(response,code);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
