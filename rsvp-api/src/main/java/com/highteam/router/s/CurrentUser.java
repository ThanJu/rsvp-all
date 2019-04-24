package com.highteam.router.s;


import java.lang.annotation.*;


@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

	/**
     * 
     *
     * @return
     */
    String value() default "_user_content";

	
}
