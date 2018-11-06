package com.answern.logback.config;

import com.answern.logback.config.aop.AopAspects;
import com.answern.logback.config.aop.AopMethodServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 需求名称:
 * 类描述:[一句话描述该类的功能]<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/10/26 11:49]  <br/>
 * 版本:[v1.0]   <br/>
 */
@Configuration
//@EnableConfigurationProperties(CMQProducerProperties.class)
@Import({ThreadAsyncConfig.class,CMQProducerProperties.class})
public class AutoConfigurationLogBack {

    @Bean
    public AopMethodServer aopMethodServer(){
        System.out.println("Load aopMethodServer");
        return new  AopMethodServer();
    }
    @Bean
    public AopAspects aopAspects(){
        return new AopAspects();
    }



}
