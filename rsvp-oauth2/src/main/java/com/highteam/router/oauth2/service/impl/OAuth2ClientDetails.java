package com.highteam.router.oauth2.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Set;


public class OAuth2ClientDetails implements ClientDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7308013060368873050L;
	protected String clientId;
	protected Set<String> resourceIds;
	protected boolean secretRequired;
	protected String clientSecret;
	protected boolean scoped;
	public Set<String> scope;
	public Set<String> authorizedGrantTypes;
	public Set<String> registeredRedirectUri;
	public Collection<GrantedAuthority> authorities;
	public Integer accessTokenValiditySeconds;
	public Integer refreshTokenValiditySeconds;
	public Map<String, Object> additionalInformation;
	
	private boolean autoApprove =true;
	
	public OAuth2ClientDetails(String clientId,String clientSecret, Set<String> scope,
	Set<String> authorizedGrantTypes, Collection<GrantedAuthority> authorities)
	{
		this.clientId=clientId;
		this.clientSecret =clientSecret;
		this.scope=scope;
		this.authorizedGrantTypes=authorizedGrantTypes;
		this.authorities=authorities;
		
	}
	public String getClientId() {
		return clientId;
	}
	public Set<String> getResourceIds() {
		return resourceIds;
	}
	public boolean isSecretRequired() {
		return secretRequired;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public boolean isScoped() {
		return scoped;
	}
	public Set<String> getScope() {
		return scope;
	}
	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}
	public Set<String> getRegisteredRedirectUri() {
		return registeredRedirectUri;
	}
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}
	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}
	public Map<String, Object> getAdditionalInformation() {
		return additionalInformation;
	}
	@Override
	public boolean isAutoApprove(String scope) {
		return autoApprove;
	}
	

}
