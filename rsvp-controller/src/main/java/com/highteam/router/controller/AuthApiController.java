package com.highteam.router.controller;


import com.highteam.router.core.RequestGateWayCore;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.UserInfo;
import com.highteam.router.oauth2.config.OAuth2Config;
import com.highteam.router.s.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/abs")
public class AuthApiController {

	@Autowired
	protected RequestGateWayCore requestGateWayCore;
	
	@Autowired
	protected OAuth2Config config;

	@RequestMapping(value = "/business", method = RequestMethod.POST)
	@ResponseBody
	public Object postindex(@CurrentUser UserInfo userInfo, @RequestBody AppRequest param, HttpServletRequest serRequest,
							HttpServletResponse serResponse) {

		return requestGateWayCore.request(userInfo, param, serRequest, serResponse,null);
	}
	
}
