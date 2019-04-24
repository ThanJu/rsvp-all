package com.highteam.router.oauth2.interceptor;


import com.highteam.router.oauth2.config.OAuth2Config;
import com.highteam.router.oauth2.model.UserAccessToken;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.servlet.http.HttpServletRequest;


public class BaseInfoResolver {

	private HttpServletRequest req;

	private TokenStore tokenStore;

	public BaseInfoResolver(HttpServletRequest req,  TokenStore tokenStore) {
		this.req = req;
		this.tokenStore = tokenStore;
	}
	
	public UserAccessToken getToken() {
		UserAccessToken accessToken = null;
		String author = req.getHeader("Authorization");
		String access_token = null;
		if (author != null) {
			String[] s = author.split(" ");
			if (s.length > 1) {
				access_token = s[1];
			}
		}

		if (access_token == null) {
			access_token = req.getParameter(OAuth2Config.ACCESS_TOKEN);
		}

		OAuth2AccessToken o = null;
		if (access_token != null) {
			o = tokenStore.readAccessToken(access_token);
			if(o!=null) {
				accessToken = new UserAccessToken();
				accessToken.setAccess_token(o.getValue());
				accessToken.setRefresh_token(o.getRefreshToken().getValue());
				accessToken.setExpires_in(o.getExpiresIn());
			}
		}
		return accessToken;
	}

	public Object getUserInfo() {

		String author = req.getHeader("Authorization");
		String access_token = null;
		if (author != null) {
			String[] s = author.split(" ");
			if (s.length > 1) {
				access_token = s[1];
			}
		}

		if (access_token == null) {
			access_token = req.getParameter(OAuth2Config.ACCESS_TOKEN);
		}

		OAuth2Authentication o = null;
		if (access_token != null) {
			o = tokenStore.readAuthentication(access_token);
		}
		
		return o == null ? null : o.getPrincipal();
	}
	
	public void remove() {
		
		String author = req.getHeader("Authorization");
		String access_token = null;
		if (author != null) {
			String[] s = author.split(" ");
			if (s.length > 1) {
				access_token = s[1];
			}
		}

		if (access_token == null) {
			access_token = req.getParameter(OAuth2Config.ACCESS_TOKEN);
		}
		if (access_token != null) {
			DefaultOAuth2AccessToken ac = new DefaultOAuth2AccessToken(access_token);
			tokenStore.removeAccessToken(ac);
		}
	}

}
