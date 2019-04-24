package com.highteam.router.oauth2.exception;

import com.highteam.router.oauth2.model.OAuth2Request;
import com.highteam.router.oauth2.service.OAuth2RequestStateCodeService;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.DefaultOAuth2ExceptionRenderer;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletResponse;

public class CommerceOAuth2ExceptionRenderer extends DefaultOAuth2ExceptionRenderer {

	public void handleHttpEntityResponse(HttpEntity<?> responseEntity, ServletWebRequest webRequest) throws Exception {

		if (responseEntity instanceof ResponseEntity<?> && responseEntity.getBody() instanceof OAuth2Exception) {
			OAuth2Exception exception = (OAuth2Exception) responseEntity.getBody();
			OAuth2Request request = new OAuth2Request();
			request.setCode(OAuth2RequestStateCodeService.UNAUTHORIZED);
			request.setMsg(exception.getOAuth2ErrorCode() + ":" + exception.getMessage());

			ResponseEntity<OAuth2Request> response = new ResponseEntity<OAuth2Request>(request,
					responseEntity.getHeaders(), HttpStatus.OK);

			HttpOutputMessage outputMessage = createHttpOutputMessage(webRequest);

			new MappingJackson2HttpMessageConverter().write(response.getBody(), MediaType.APPLICATION_JSON,
					outputMessage);
		} else {
			super.handleHttpEntityResponse(responseEntity, webRequest);
		}
		
	}

	private HttpOutputMessage createHttpOutputMessage(NativeWebRequest webRequest) throws Exception {
		HttpServletResponse servletResponse = (HttpServletResponse) webRequest.getNativeResponse();
		return new ServletServerHttpResponse(servletResponse);
	}

}
