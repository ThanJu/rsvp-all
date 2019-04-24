package com.highteam.router.common.vcode;

import com.highteam.router.common.util.AESUtil;
import com.highteam.router.common.util.MD5Util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ValidateCodeControl {

	private HttpServletRequest request;

	private HttpServletResponse response;

	private ValidateCodeModel validateCodeMode = new ValidateCodeModel();

	public ValidateCodeControl(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public ValidateCodeControl(HttpServletRequest request,
			HttpServletResponse response,ValidateCodeModel validateCodeMode) {
		this.request = request;
		this.response = response;
		this.validateCodeMode = validateCodeMode;
	}

	public void createNewCookie(String vcode) {
		Cookie cookie = this.getCookie();
		if(vcode!=null) {
			vcode = vcode.toUpperCase();
		}

		if (cookie != null) {
			cookie.setValue(encryption(vcode));
		} else {
			cookie = new Cookie(this.validateCodeMode.getCookieName(),
					encryption(vcode));
		}


		cookie.setPath("/");
		cookie.setDomain(this.validateCodeMode.getDomain());
		cookie.setHttpOnly(true);
		cookie.setMaxAge(this.validateCodeMode.getAge());
		response.addCookie(cookie);
	}

	public boolean eqCookie(String vcode) {
		boolean bl = false;
		if (vcode == null) {
			throw new RuntimeException("验证码为空");
		}
		Cookie cookie = this.getCookie();
		if (cookie == null) {
			throw new RuntimeException("无效的验证码");
		}
		vcode = vcode.toUpperCase();
		if (this.encryption(vcode).equals(cookie.getValue())) {
			bl = true;
		} else {
			throw new RuntimeException("无效的验证码");
		}

		return bl;
	}

	private Cookie getCookie() {
		Cookie[] cookies = this.request.getCookies();
		Cookie r = null;
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if (this.validateCodeMode.getCookieName().equals(cookie.getName())) {
					r = cookie;
					break;
				}
			}
		}
		return r;
	}

	public String encryption(String str) {
		String cookiesStr = "";
		if (null!=str &&!"".equals(str)) {
//			cookiesStr = AESUtil.encrypt(str,
//					this.validateCodeMode.getEncryptKey());
			cookiesStr = MD5Util.string2MD5(str+this.validateCodeMode.getEncryptKey());
		}
		return cookiesStr;
	}

	public String decryption(String str) {
		String cookiesStr = "";
		if (null!=str &&!"".equals(str)) {
			cookiesStr = AESUtil.detrypt(str,
					this.validateCodeMode.getEncryptKey());
		}
		return cookiesStr;
	}

}
