package com.highteam.router.oauth2.provider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class HttpRequetParameterWrapper extends HttpServletRequestWrapper {

	private Map<String, String> customers = new HashMap<String, String>();

	public HttpRequetParameterWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = this.customers.get(name);
		if (value != null)
			return value;
		return super.getParameter(name);
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] supers = super.getParameterValues(name);
		if (this.customers.get(name) == null)
			return supers;

		if (supers == null)
			return new String[] { this.customers.get(name) };

		String[] values = new String[supers == null ? 1 : supers.length + 1];
		values[0] = this.customers.get(name);
		System.arraycopy(supers, 0, values, 1, supers.length);
		return values;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		Set<String> names = new HashSet<String>(this.customers.keySet());
		Enumeration<String> supers = super.getParameterNames();
		while (supers.hasMoreElements())
			names.add(supers.nextElement());
		return Collections.enumeration(names);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> params = new HashMap<String, String[]>();
		Map<String, String[]> supers = super.getParameterMap();
		if (params != null)
			params.putAll(supers);

		if (this.customers.size() > 0)
			for (Map.Entry<String, String> e : this.customers.entrySet()) {
				String key = e.getKey();
				String value = e.getValue();
				if (params.get(key) == null) {
					params.put(key, new String[] { value });
				} else {
					String[] values = new String[params.get(key).length + 1];
					values[0] = value;
					System.arraycopy(params.get(key), 0, values, 1, params.get(key).length);
					params.put(key, values);
				}
			}
		return params;
	}
	
	public void addParameter(String name, String value) {
		this.customers.put(name, value);
	}
}
