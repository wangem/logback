package com.answern.logback.server;

import com.answern.logback.base.BaseLogger;
import com.answern.logback.config.CMQProducerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;

/**
 * 需求名称:
 * 类描述:[一句话描述该类的功能]<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/10/12 14:37]  <br/>
 * 版本:[v1.0]   <br/>
 */
public class CMQServer {

    private CMQQueueProducer cmqQueueProducer;
    @Autowired
    private CMQProducerProperties cmqProducerProperties;

    public CMQServer(CMQProducerProperties cmqProducerProperties){
        this.cmqProducerProperties =cmqProducerProperties;
        this.cmqQueueProducer = new CMQQueueProducer(cmqProducerProperties.getQueue_endpoint(),cmqProducerProperties.getSecret_id(),cmqProducerProperties.getSecret_key());
    }
    public CMQServer(){
    }
    private Logger logger = LoggerFactory.getLogger(CMQServer.class);
    public  String sendMessageQueue(String message) {
         try {
            return cmqQueueProducer.sendMessage(cmqProducerProperties.getQueue_name(), message);
        } catch (Exception e) {
            logger.error("sendMessageQueue exception",e);
            LinkedHashMap map = new LinkedHashMap();
            map.put("massage","CMQ logger message send error");
            BaseLogger.loggerRecord(cmqProducerProperties,map);
        }
        return null;
    }
}
