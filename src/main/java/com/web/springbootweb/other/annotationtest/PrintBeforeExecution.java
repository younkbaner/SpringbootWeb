package com.web.springbootweb.other.annotationtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/28 17:00
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PrintBeforeExecution {
}
