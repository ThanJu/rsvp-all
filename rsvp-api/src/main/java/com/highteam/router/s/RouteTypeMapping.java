package com.highteam.router.s;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RouteTypeMapping {

	String value();
	
	RouteTypeEnum returnType() default RouteTypeEnum.JSON;
	
    String version() default RouteVersion.VERSION;
}
