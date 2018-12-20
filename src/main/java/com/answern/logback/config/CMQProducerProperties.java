package com.answern.logback.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wem
 * CMQ 消息发送配置
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "answern.cmq")
public class CMQProducerProperties {

    /**
     * cmq queue_name"
     */
    private String  queue_name     = "loggerQueue";

    public String getQueue_endpoint() {
        return queue_endpoint;
    }

    public String getSecret_id() {
        return secret_id;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public String getQueue_name() {
        return queue_name;
    }

    public void setQueue_endpoint(String queue_endpoint) {
        this.queue_endpoint = queue_endpoint;
    }

    public void setSecret_id(String secret_id) {
        this.secret_id = secret_id;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public void setQueue_name(String queue_name) {
        this.queue_name = queue_name;
    }
}
