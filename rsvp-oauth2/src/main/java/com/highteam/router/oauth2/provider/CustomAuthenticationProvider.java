package com.highteam.router.oauth2.provider;

import com.highteam.router.oauth2.model.CustomOAuth2AuthenticationInfo;
import com.highteam.router.oauth2.service.OAuth2AuthenService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import java.util.ArrayList;
import java.util.Map;

public class CustomAuthenticationProvider implements AuthenticationProvider,
		ApplicationContextAware {

	private ApplicationContext context;
	
	protected void checkVCode(Map<String, String> map) {
		boolean enableVcode = map.get("__enableVcode")==null?false:Boolean.parseBoolean(map.get("__enableVcode"));
		
		if(enableVcode) {
			boolean _enableVcode_Success =  map.get("__enableVcode_Success")==null?false:Boolean.parseBoolean(map.get("__enableVcode_Success"));
			if(!_enableVcode_Success) {
				throw new RuntimeException(map.get("__enableVcode_Mess"));
			}
		}
	}
	

	@SuppressWarnings("unchecked")
	public Authentication authenticate(Authentication arg0)
			throws AuthenticationException {
		try {
			UsernamePasswordAuthenticationToken upToken = (UsernamePasswordAuthenticationToken) arg0;

			OAuth2AuthenService service = context.getBean(OAuth2AuthenService.class);
			return this.createSuccessAuthentication(service.auth(upToken), arg0);
		} catch (Exception e) {
			
			String msg ="";
			
			if(e.getCause() ==null) {
				msg = e.getMessage();
			}else {
				msg = e.getCause().getMessage();
			}
			
			throw new OAuth2Exception(msg) {
				
				private static final long serialVersionUID = 1480851380201531986L;

				@Override
				public int getHttpErrorCode() {
					return 200;
				}
				
				
			};
		}
		
	}

	public boolean supports(Class<?> arg0) {
		return (UsernamePasswordAuthenticationToken.class
				.isAssignableFrom(arg0));
	}

	protected Authentication createSuccessAuthentication(Object principal,
			Authentication authentication) {
		
		if(principal == null){
			return  null;
		}
		
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
				principal, authentication.getCredentials(),
				new ArrayList<GrantedAuthority>());
		
		result.setDetails(authentication.getDetails());
		return result;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context = arg0;
	}

}
