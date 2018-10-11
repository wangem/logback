package com.answern.logback.config.aop;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 需求名称:自定义一个注解<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/9/17 20:52]  <br/>
 * 版本:[v1.0]   <br/>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ClassLog {

    /**
     * 系统名称
     * @return
     */
    String sysName();
    /**
     * 日志信息
     * @return
     */
    String logInfo();
}
