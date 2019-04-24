package com.highteam.router.oauth2.provider;

import org.springframework.security.oauth2.common.exceptions.InvalidScopeException;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.OAuth2RequestValidator;
import org.springframework.security.oauth2.provider.TokenRequest;

import java.util.Set;

public class CustomOAuth2RequestValidator implements OAuth2RequestValidator {

	@Override
	public void validateScope(AuthorizationRequest authorizationRequest, ClientDetails client) throws InvalidScopeException {
		validateScope(authorizationRequest.getScope(), client.getScope());
	}

	@Override
	public void validateScope(TokenRequest tokenRequest, ClientDetails client) throws InvalidScopeException {
		validateScope(tokenRequest.getScope(), client.getScope());
	}

	private void validateScope(Set<String> requestScopes, Set<String> clientScopes) {
		if (clientScopes != null && !clientScopes.isEmpty()) {
			for (String scope : requestScopes) {
				if (!clientScopes.contains(scope)) {
					throw new InvalidScopeException("Invalid scope: " + scope, clientScopes);
				}
			}
		}
	}
}
