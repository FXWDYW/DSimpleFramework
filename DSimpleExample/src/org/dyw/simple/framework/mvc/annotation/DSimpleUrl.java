package org.dyw.simple.framework.mvc.annotation;

import org.dyw.simple.framework.orm.annotation.DSimpleDao;

import java.lang.annotation.*;


@Repeatable(DSimpleUrls.class)
public @interface DSimpleUrl {
   String name();
   String path();
}
