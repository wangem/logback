package com.answern.logback.server;

import com.answern.logback.base.BaseLogger;
import com.answern.logback.base.Constant;
import com.answern.logback.config.CMQProducerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private CMQProducerProperties cmqProducerProperties;
//    public CMQServer(){
//         cmqQueueProducer = new CMQQueueProducer(this.cmqProducerProperties.getQueue_endpoint(), this.cmqProducerProperties.getSecret_id(),   this.cmqProducerProperties.getSecret_key());
//    }
    public CMQServer(CMQProducerProperties cmqProducerProperties){
     //   PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(CMQProducerProperties.class);
        this.cmqProducerProperties =cmqProducerProperties;

      //  Object cMQQueueProducer = ContextLoader.getCurrentWebApplicationContext().getBean("CMQProducerProperties");
//        this.cmqQueueProducer = new CMQQueueProducer(Constant.QUEUE_ENDPOINT, Constant.CMQ_SECRET_ID, Constant.CMQ_SECRET_KEY);
        this.cmqQueueProducer = new CMQQueueProducer(cmqProducerProperties.getQueue_endpoint(),cmqProducerProperties.getSecret_id(),cmqProducerProperties.getSecret_key());
    }

    private Logger logger = LoggerFactory.getLogger(CMQServer.class);
    public  String sendMessageQueue(String message) {
         try {
//            return cmqQueueProducer.sendMessage(Constant.CMQ_QUEUE_NAME, message);
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
