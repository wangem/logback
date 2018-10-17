package com.answern.logback.config.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需求名称:自定义一个方法注解<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/9/17 20:52]  <br/>
 * 版本:[v1.0]   <br/>
 */
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodLog {

    /**
     * 自定义日志信息
     * @return
     */
    String logInfo() default "";

    /**
     * 是否本系统打印，默认为打印
     * @return
     */
    boolean isTrue() default true;
}
