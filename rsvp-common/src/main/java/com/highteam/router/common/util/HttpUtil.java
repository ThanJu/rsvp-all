package com.highteam.router.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取IP
 * @author shitao
 *
 */
public class HttpUtil {

	/**
	 * get IP
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * get Use-Agent
	 * @param request
	 * @return
	 */
	public static String getEquipinfo(HttpServletRequest request){
		return request.getHeader("User-Agent");
	}
}
