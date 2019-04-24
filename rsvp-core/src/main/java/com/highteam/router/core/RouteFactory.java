package com.highteam.router.core;

import com.highteam.router.api.RouteAdapater;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;


public class RouteFactory implements ApplicationContextAware {

	private Map<String, RouteAdapater> map = new HashMap<String, RouteAdapater>();

	private String defaultRoutePath;

	public void init() {
		Map<String, RouteAdapater> _map = applicationContext.getBeansOfType(RouteAdapater.class);
		String _;
		for (RouteAdapater p : _map.values()) {
			_ = p.getRoutePath();
			map.put(_, p);
		}
	}

	public RouteAdapater getRoute(String key) {
		if (key == null || "".equals(key)) {
			key = defaultRoutePath;
		}
		RouteAdapater r = map.get(key);
		if (r == null) {
			r = map.get(defaultRoutePath);
		}
		return r;
	}

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		applicationContext = arg0;
	}

	public void setDefaultRoutePath(String defaultRoutePath) {
		this.defaultRoutePath = defaultRoutePath;
	}

}
