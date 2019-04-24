package com.highteam.router.common.util;

import com.highteam.router.common.m.BusinessException;

import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

	private final static String CONFIG_PATH="conf/config.properties";

	private static final Properties PROPERTIES = new Properties();

	private ConfigUtil(){}

	static {
		try {
			InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream(CONFIG_PATH);
			PROPERTIES.load(in);
		} catch (Exception e) {
			throw new BusinessException("read config error", "读取config.xml配置错误");
		}
	}
	
	public static String getConfigParam(String key){
		return PROPERTIES.getProperty(key);
	}
}
