package com.answern.logback.server;

import com.answern.logback.base.BaseLogger;
import com.answern.logback.base.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

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
    public CMQServer(){
       cmqQueueProducer = new CMQQueueProducer(Constant.QUEUE_ENDPOINT,Constant.CMQ_SECRETID,Constant.CMQ_SECRETKEY);
    }
    @Value("${spring.queue.logger.name}")
    private String queueName=Constant.CMQ_QUEUENAME;

    private Logger logger = LoggerFactory.getLogger(CMQServer.class);
    public  String sendMessageQueue(String message) {
         try {
            return cmqQueueProducer.sendMessage(queueName, message);
        } catch (Exception e) {
            logger.error("sendMessageQueue exception",e);
            LinkedHashMap map = new LinkedHashMap();
            map.put("massage","CMQ logger message send error");
            BaseLogger.loggerRecord(map);
        }
        return null;
    }
}
