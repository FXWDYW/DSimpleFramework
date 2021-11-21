package org.dyw.simple.framework.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 这个注解用来标注DSimple标准组件.
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DSimpleBean {
        String name();
        DSimpleBeanType type() default DSimpleBeanType.Prototype;
}