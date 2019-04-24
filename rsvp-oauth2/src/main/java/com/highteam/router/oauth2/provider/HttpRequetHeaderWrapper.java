package com.highteam.router.oauth2.provider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class HttpRequetHeaderWrapper  extends HttpServletRequestWrapper{

	private Map<String, String> customers = new HashMap<String, String>();

	public HttpRequetHeaderWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getHeader(String name) {
		String value = this.customers.get(name);
		if (value != null)
			return value;
		return super.getHeader(name);
	}

	@Override
	public Enumeration<String> getHeaders(String name) {
		Set<String> values = new HashSet<String>();
		String value = this.customers.get(name);
		if(value != null)
			values.add(value);
		
		Enumeration<String> supers = super.getHeaders(name);
		while (supers.hasMoreElements())
			values.add(supers.nextElement());
		return Collections.enumeration(values);
	}

	@Override
	public Enumeration<String> getHeaderNames() {
		Set<String> names = new HashSet<String>(this.customers.keySet());
		Enumeration<String> supers = super.getHeaderNames();
		while (supers.hasMoreElements())
			names.add(supers.nextElement());
		return Collections.enumeration(names);
	}

	public void addHeader(String name, String value) {
		this.customers.put(name, value);
	}
}
