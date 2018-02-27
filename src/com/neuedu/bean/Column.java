package com.neuedu.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.FIELD)//这个注解只能写在属性上面
@Retention(RetentionPolicy.RUNTIME)//在整个运行当中有效
public @interface Column {

	String value();
}
