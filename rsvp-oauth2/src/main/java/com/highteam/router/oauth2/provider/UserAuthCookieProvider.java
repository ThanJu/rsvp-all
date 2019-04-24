package com.highteam.router.oauth2.provider;


import com.highteam.router.oauth2.config.OAuth2Config;
import com.highteam.router.oauth2.model.UserAccessToken;
import com.highteam.router.oauth2.u.AESUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class UserAuthCookieProvider {

	private OAuth2Config oAuth2Config;

	private HttpServletResponse response;

	public UserAuthCookieProvider(OAuth2Config oAuth2Config, HttpServletResponse response) {
		this.oAuth2Config = oAuth2Config;
		this.response = response;
	}

	// other cookie
	public void createOtherCookie(HttpServletRequest request, String name, String value) {
		Cookie[] cs = request.getCookies();
		Cookie c = null;
		if (cs != null) {
			for (Cookie cookie : cs) {
				if (name.equals(cookie.getName())) {
					c = cookie;
					c.setValue(AESUtil.encrypt(value, oAuth2Config.getAesKey()));
					break;
				}
			}
		}
		if (c == null) {
			c = new Cookie(name, AESUtil.encrypt(value, oAuth2Config.getAesKey()));
		}
		c.setDomain(oAuth2Config.getDomain());
		c.setPath("/");
		c.setMaxAge(-1);
		c.setHttpOnly(true);
		c.setSecure(oAuth2Config.isSecure());
		response.addCookie(c);
	}

	public String getOtherCookie(HttpServletRequest request, String name) {
		Cookie[] cs = request.getCookies();
		String r = null;
		if (cs == null) {
			return r;
		}
		for (Cookie cookie : cs) {
			if (name.equals(cookie.getName())) {
				r = cookie.getValue();
				r = AESUtil.detrypt(r, oAuth2Config.getAesKey());
				break;
			}
		}
		return r;
	}

	// 缓存数据用cookie
	public void createCafCookie(HttpServletRequest request, String value) {
		Cookie[] cs = request.getCookies();
		Cookie c = null;
		if (cs != null) {
			for (Cookie cookie : cs) {
				if (oAuth2Config.getCaf().equals(cookie.getName())) {
					c = cookie;
					c.setValue(AESUtil.encrypt(value, oAuth2Config.getAesKey()));
					break;
				}
			}
		}
		if (c == null) {
			c = new Cookie(oAuth2Config.getCaf(), AESUtil.encrypt(value, oAuth2Config.getAesKey()));
		}
		c.setDomain(oAuth2Config.getDomain());
		c.setPath("/");
		c.setMaxAge(-1);
		c.setHttpOnly(true);
		c.setSecure(oAuth2Config.isSecure());
		response.addCookie(c);
	}

	// 缓存数据用cookie
	public String getCafCookie(HttpServletRequest request) {
		Cookie[] cs = request.getCookies();
		String r = null;
		if (cs == null) {
			return r;
		}
		for (Cookie cookie : cs) {
			if (oAuth2Config.getCaf().equals(cookie.getName())) {
				r = cookie.getValue();
				r = AESUtil.detrypt(r, oAuth2Config.getAesKey());
				break;
			}
		}

		return r;
	}

	public void createCookie(UserAccessToken token) {

		if (token != null) {
			String access_token = token.getAccess_token();
			String a = access_token + "#" + (new Date().getTime()) + "#" + token.getExpires_in();
			Cookie c = new Cookie(oAuth2Config.getAccessTokenKey(), AESUtil.encrypt(a, oAuth2Config.getAesKey()));
			c.setDomain(oAuth2Config.getDomain());
			c.setPath("/");
			c.setMaxAge(-1);
			c.setHttpOnly(true);
			c.setSecure(oAuth2Config.isSecure());
			response.addCookie(c);

			Cookie c2 = new Cookie(oAuth2Config.getRefeshTokenKey(),
					AESUtil.encrypt(token.getRefresh_token(), oAuth2Config.getAesKey()));
			c2.setDomain(oAuth2Config.getDomain());
			c2.setPath("/");
			c2.setMaxAge(-1);
			c2.setHttpOnly(true);
			c2.setSecure(oAuth2Config.isSecure());
			response.addCookie(c2);
		}
	}

	public UserAccessToken getTokenByCookie(HttpServletRequest request) {
		UserAccessToken token = new UserAccessToken();
		Cookie[] cs = request.getCookies();
		if (cs == null)
			return token;
		for (Cookie cookie : cs) {
			if (oAuth2Config.getAccessTokenKey().equals(cookie.getName())) {
				String a = AESUtil.detrypt(cookie.getValue(), oAuth2Config.getAesKey());
				if (a != null) {
					String[] _r = a.split("#");
					if (_r != null && _r.length >= 3) {
						long l = new Date().getTime();
						long o = Long.parseLong(_r[1]);
						long e = Long.parseLong(_r[2]);
						token.setAccess_token(_r[0]);
						token.setExpires_in((int) (e - (l - o) / 1000));
					}
				}
			}
			if (oAuth2Config.getRefeshTokenKey().equals(cookie.getName())) {
				token.setRefresh_token(AESUtil.detrypt(cookie.getValue(), oAuth2Config.getAesKey()));
			}
		}
		return token;

	}

	public void loginOutCookie(HttpServletRequest request) {
		Cookie[] cs = request.getCookies();
		if (cs == null)
			return;
		for (Cookie cookie : cs) {
			if (oAuth2Config.getAccessTokenKey().equals(cookie.getName())
					|| oAuth2Config.getRefeshTokenKey().equals(cookie.getName())) {
				Cookie c = new Cookie(cookie.getName(), null);
				c.setDomain(oAuth2Config.getDomain());
				c.setPath("/");
				c.setMaxAge(0);
				c.setHttpOnly(true);
				c.setSecure(oAuth2Config.isSecure());
				response.addCookie(c);
			}

		}

	}

}
