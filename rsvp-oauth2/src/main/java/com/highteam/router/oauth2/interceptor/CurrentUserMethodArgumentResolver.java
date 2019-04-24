package com.highteam.router.oauth2.interceptor;

import com.highteam.router.s.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;


public class CurrentUserMethodArgumentResolver implements
		HandlerMethodArgumentResolver {

	@Autowired
	private TokenStore tokenStore;
	
	org.springframework.web.method.support.HandlerMethodArgumentResolverComposite r;
	

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if (parameter.hasParameterAnnotation(CurrentUser.class)) {
			return true;
		}
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest r = (HttpServletRequest) webRequest.getNativeRequest();
		return new BaseInfoResolver(r,tokenStore).getUserInfo();
	}

}
