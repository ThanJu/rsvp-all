package com.highteam.router.oauth2.service.impl;

import com.highteam.router.oauth2.config.OAuth2Config;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class OauthClientDetailService implements ClientDetailsService, Serializable {
	private static final long serialVersionUID = -2911708831119145455L;
	private OAuth2Config config;
	public void setConfig(OAuth2Config config) {
		this.config = config;
		this.id = this.config.getClientId();
		this.secretKey = this.config.getClientSecret();
	}
	private String id;
	private String secretKey;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getSecretKey() {
		return secretKey;
	}



	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}



	public OAuth2Config getConfig() {
		return config;
	}



	@Override
	public ClientDetails loadClientByClientId(String clientId)
			throws ClientRegistrationException {
		
		
		Set<String> authorizedGrantTypes = new HashSet<String>();
		authorizedGrantTypes.add("password");
		authorizedGrantTypes.add("refresh_token");
		authorizedGrantTypes.add("client_credentials");
		authorizedGrantTypes.add("authorization_code");
		authorizedGrantTypes.add("implicit");

		Set<String> scopes = new HashSet<String>();
		scopes.add("ROLE_ADMIN");
		
		
		BaseClientDetails clientDetails = new BaseClientDetails();
		clientDetails.setClientId(config.getClientId());
		clientDetails.setClientSecret(config.getClientSecret());
		clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
		clientDetails.setScope(scopes);
		
		Set<String> approveScopes = new HashSet<String>();
		approveScopes.add("true");
		
		
		Set<String> resourceIds = new HashSet<String>();
		resourceIds.add("springsec");
		
		clientDetails.setResourceIds(resourceIds);
		
		clientDetails.setAutoApproveScopes(approveScopes);
		
		
		clientDetails.setRefreshTokenValiditySeconds(config.getRefeshTokenValidity());
		clientDetails.setAccessTokenValiditySeconds(config.getAccessTokenValidity());
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new GrantedAuthority(){
			/**
			 * 
			 */
			private static final long serialVersionUID = -5765016570295964326L;

			@Override
			public String getAuthority() {
				return "USER";
			}});
		clientDetails.setAuthorities(authorities);
		
		return clientDetails;
	}
}
