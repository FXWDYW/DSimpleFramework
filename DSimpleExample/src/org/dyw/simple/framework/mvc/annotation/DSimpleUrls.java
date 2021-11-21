package org.dyw.simple.framework.mvc.annotation;

import org.dyw.simple.framework.mvc.core.DSimple;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DSimpleUrls {
    DSimpleUrl[] value();
}
