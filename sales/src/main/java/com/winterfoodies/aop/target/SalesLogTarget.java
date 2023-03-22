package com.winterfoodies.aop.target;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//2023.03.05 //3. AOP의 타겟이 되는 놈을 만든다.
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface SalesLogTarget {

}
