package com.answern.logback.config.aop;


import java.lang.annotation.*;

/**
 * 需求名称:自定义一个Controller注解<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/9/17 20:52]  <br/>
 * 版本:[v1.0]   <br/>
 */
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {

    /**
     * 系统名称
     * @return
     */
    String logInfo() default "";

    /**
     * 是否本系统打印，默认为打印
     * @return
     */
    boolean isTrue() default true;
}
