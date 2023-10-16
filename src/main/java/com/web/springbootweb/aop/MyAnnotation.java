package com.web.springbootweb.aop;

import java.lang.annotation.*;

/**
 * @description:
 * @author: ywz
 * @time: 2023/10/16 23:25
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {


    String getName() default "yangwz";

    String getAge() default "18";
}
