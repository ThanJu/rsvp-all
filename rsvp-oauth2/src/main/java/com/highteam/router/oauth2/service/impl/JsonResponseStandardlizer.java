package com.highteam.router.oauth2.service.impl;

import com.highteam.router.oauth2.model.OAuth2Request;
import com.highteam.router.oauth2.service.OAuth2RequestStateCodeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;

import java.io.IOException;

public class JsonResponseStandardlizer extends MappingJackson2HttpMessageConverter {

	
	TokenEndpoint t;
	
	//将Controller返回的对象封装成JsonObject通用对象
		@Override
		protected void writeInternal(Object object, HttpOutputMessage outputMessage)
				throws IOException, HttpMessageNotWritableException {
		
			if (object instanceof OAuth2Request){
				super.writeInternal(object, outputMessage);
				return;
			}
			
			if (object instanceof Throwable)
			{
				super.write(handleException(object,outputMessage.getHeaders()), MediaType.APPLICATION_JSON, outputMessage);
			}
			else 
			{
				super.write(handleReturnValue(object), MediaType.APPLICATION_JSON, outputMessage);
			}		
		}
		
		
		
		private OAuth2Request handleException(Object object,HttpHeaders t)
		{
			
			OAuth2Request standardResponse = new OAuth2Request();
			standardResponse.setStatus(false);
			
			boolean isv =false;
			
			if( object instanceof OAuth2Exception) {
				standardResponse.setMsg(((OAuth2Exception) object).getMessage());
				standardResponse.setCode(OAuth2RequestStateCodeService.UNAUTHORIZED);
				isv =true;
			}
			
			if(object instanceof RuntimeException && !isv) {
				standardResponse.setMsg(((RuntimeException) object).getMessage());
				standardResponse.setCode(OAuth2RequestStateCodeService.INTERNAL_SERVER_ERROR);
			}
		
			return standardResponse;
		}
		
		private OAuth2Request handleReturnValue(Object object)
		{
			OAuth2Request standardResponse = new OAuth2Request();
			standardResponse.setStatus(true);
			standardResponse.setData(object);	
			standardResponse.setCode(OAuth2RequestStateCodeService.OK);
			return standardResponse;
		}
}
