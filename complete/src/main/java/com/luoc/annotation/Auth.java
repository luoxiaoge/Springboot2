package com.luoc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author luoc
 * @date 2018/11/19 0019
 * @Time 10:28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Auth {

    String value() default "need Auth";

    boolean auth() default false;

    //Class<?> isAuth() default Class.class;
}
