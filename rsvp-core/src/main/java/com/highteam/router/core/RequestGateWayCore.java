package com.highteam.router.core;


import com.alibaba.fastjson.JSON;
import com.highteam.router.api.BusinessExecuteService;
import com.highteam.router.api.RouteAdapater;
import com.highteam.router.common.m.BusinessException;
import com.highteam.router.log.model.Log;
import com.highteam.router.log.service.LogService;
import com.highteam.router.m.AppRequest;
import com.highteam.router.m.RequestPath;
import com.highteam.router.m.UserInfo;
import com.highteam.router.oauth2.model.OAuth2Request;
import com.highteam.router.oauth2.service.OAuth2RequestStateCodeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


public class RequestGateWayCore {

	private RouteFactory routeFactory;

	private Boolean ifLogging;

	private LogService logService = null;

	public void setIfLogging(Boolean ifLogging) {
		this.ifLogging = ifLogging;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

    public void setRouteFactory(RouteFactory routeFactory) {
		this.routeFactory = routeFactory;
	}

	public OAuth2Request request(UserInfo userInfo, AppRequest param, HttpServletRequest request,
								 HttpServletResponse response, BusinessExecuteService businessExecuteService) {

		OAuth2Request oAuth2Request = new OAuth2Request();
		try {
			
			RequestPath path = new RequestPath(param.getBusinessParam(), param.getVersion());
			RouteAdapater route = routeFactory.getRoute(path.toString());
			if(businessExecuteService!=null) {
				businessExecuteService.preExecute(route);
			}
			oAuth2Request.setData(route.getResponse(param, userInfo,path, request, response));
			oAuth2Request.setStatus(true);
			oAuth2Request.setCode(OAuth2RequestStateCodeService.OK);
		} catch (BusinessException e) {
			e.printStackTrace();
			oAuth2Request.setStatus(false);
			oAuth2Request.setMsg(e.getClass()+":"+e.getMessage());
			oAuth2Request.setCode(OAuth2RequestStateCodeService.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			oAuth2Request.setStatus(false);
			oAuth2Request.setCode(OAuth2RequestStateCodeService.INTERNAL_SERVER_ERROR);
			if (e instanceof NullPointerException) {
				e.printStackTrace();
				oAuth2Request.setMsg("ERROR_NULL_POINTER");
			} else {
				Throwable t = e.getCause();
				int k = 0;
				while (t != null && !(t instanceof BusinessException) && k < 4) {
					k++;
					t.printStackTrace();
					t = t.getCause();
				}
				if (t == null) {
					oAuth2Request.setMsg(e.getClass()+":"+e.getMessage());
				} else {
					oAuth2Request.setMsg(t.getCause().getClass()+":"+ t.getMessage());
				}
			}
		}finally {
			if (ifLogging&&logService != null) {
				Log log = new Log();
				log.setBusinessName(param.getBusinessParam()+"@"+param.getVersion());
				log.setCreateTime(new Date());
				log.setRequestId(UUID.randomUUID().toString());
				log.setHeaders(readHeaders(request));
				log.setRequestData(JSON.toJSONString(param.getModel()));
				log.setResponseData(JSON.toJSONString(oAuth2Request.getData()));
				log.setResponseCode(oAuth2Request.getCode());
				log.setResponseMsg(oAuth2Request.getMsg());
				log.setResponseStatus(oAuth2Request.getStatus());
				logService.recordLog(log);
			}
		}
		return oAuth2Request;
	}

	private Map<String,String> readHeaders(HttpServletRequest request){
		Map<String,String> map = new HashMap<>();
		Enumeration<String> headNames = request.getHeaderNames();
		while (headNames.hasMoreElements()){
			String key = headNames.nextElement();
			String value = request.getHeader(key);
			map.put(key,value);
		}
		return map;
	}
}
