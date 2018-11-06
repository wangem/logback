package com.answern.logback.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "answern.cmq")
public class CMQProducerProperties {
    /**
     * cmq 访问url
     */
    private String  queue_endpoint = "http://cmq-queue-bj.api.qcloud.com";
    /**
     * cmq secret_id"
     */
    private String  secret_id      = "AKIDbGrIbjMqpT5YIsSdnsmU0Kf8arwtqbP2";
    /**
     * cmq secret_key"
     */
    private String  secret_key     = "qZL0f8QWZRDxZ2MYZP6g5QadVKWwSp14";
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
