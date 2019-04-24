package com.highteam.router.oauth2.filter;


import com.highteam.router.common.vcode.ValidateCodeControl;
import com.highteam.router.common.vcode.ValidateCodeModel;
import com.highteam.router.oauth2.config.OAuth2Config;
import com.highteam.router.oauth2.model.UserAccessToken;
import com.highteam.router.oauth2.provider.HttpRequetHeaderWrapper;
import com.highteam.router.oauth2.provider.HttpRequetParameterWrapper;
import com.highteam.router.oauth2.provider.UserAuthCookieProvider;
import com.highteam.router.oauth2.u.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证之前调用 1.根据cookie获取access_token 和refush_token
 * @author shitao
 */
public class OAuthUrlWrapperFilter implements Filter {

	@Autowired
	private OAuth2Config oAuth2Config;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		if(httpRequest.getRequestURI()!=null && httpRequest.getRequestURI().indexOf("/oauth/token")!=-1) {
			
			//认证
			final ValidateCodeModel vm = new ValidateCodeModel();
			vm.setDomain(oAuth2Config.getDomain());
			
			String _enableVcode_Success ="true";
			String _enableVcode_Mess ="";
			
			if(oAuth2Config.isEnableVcode()) {
				httpRequest.setCharacterEncoding("utf-8");
				try {
					new ValidateCodeControl(httpRequest, httpResponse, vm).eqCookie(httpRequest.getParameter(oAuth2Config.getvCodeParam()));
				}catch (Exception e) {
					_enableVcode_Mess = e.getMessage();
					_enableVcode_Success ="false";
				}
			}
			HttpRequetParameterWrapper w = new HttpRequetParameterWrapper(httpRequest);
			w.addParameter("equipinfo", HttpUtil.getEquipinfo(httpRequest));
			w.addParameter("clientIp", HttpUtil.getIpAddr(httpRequest));
			w.addParameter("__enableVcode",String.valueOf(oAuth2Config.isEnableVcode()));
			w.addParameter("__enableVcode_Success",_enableVcode_Success);
			w.addParameter("__enableVcode_Mess", _enableVcode_Mess);
			filterChain.doFilter(w, httpResponse);
		}else {
			
			String author = httpRequest.getHeader("Authorization");
			
			if(author != null && author.startsWith("bearer")) {
				
				filterChain.doFilter(httpRequest, httpResponse);
			} 
			else {

				String reqP = httpRequest.getParameter(OAuth2Config.ACCESS_TOKEN);
				
				if(reqP!=null && !"".equals(reqP)) {
					filterChain.doFilter(httpRequest, httpResponse);
				}
				else {
					
					HttpRequetHeaderWrapper headerWrapper = new HttpRequetHeaderWrapper(httpRequest);
					
					UserAuthCookieProvider userAuthCookie = new UserAuthCookieProvider(oAuth2Config, httpResponse);
					UserAccessToken token = userAuthCookie.getTokenByCookie(httpRequest);
					
					if(token.getAccess_token() !=null && !"".equals(token.getAccess_token())) {
						headerWrapper.addHeader("Authorization", "bearer "+token.getAccess_token());
					}
					
					filterChain.doFilter(headerWrapper, httpResponse);
				}
			}
			
			
			
		}
		
	}

	@Override
	public void destroy() {
	}

	public void setoAuth2Config(OAuth2Config oAuth2Config) {
		this.oAuth2Config = oAuth2Config;
	}

}
