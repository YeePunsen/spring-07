package com.neuedu.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.FIELD)//���ע��ֻ��д����������
@Retention(RetentionPolicy.RUNTIME)//���������е�����Ч
public @interface Column {

	String value();
}
