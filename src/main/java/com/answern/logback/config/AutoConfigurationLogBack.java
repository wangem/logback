package com.answern.logback.config;

import com.answern.logback.base.BaseLoggerAsync;
import com.answern.logback.base.BaseUtil;
import com.answern.logback.base.ExceptionServer;
import com.answern.logback.config.aop.AopAspects;
import com.answern.logback.config.aop.AopMethodServer;
import com.answern.logback.server.CMQServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 需求名称:
 * 类描述:[一句话描述该类的功能]<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/10/26 11:49]  <br/>
 * 版本:[v1.0]   <br/>
 */
@Configuration
@Import({ThreadAsyncConfig.class,CMQProducerProperties.class, ExceptionServer.class})
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

    @Bean
    public BaseLoggerAsync basLoggerAsync(){
        //启动时调用该方法，将ip存入内存，后续将不再耗费时间
        BaseUtil.getLocalIp();
        return new BaseLoggerAsync();
    }
    @Bean
    public  CMQServer cmqServer(){
        return new CMQServer();
    }

}
