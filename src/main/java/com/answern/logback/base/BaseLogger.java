package com.answern.logback.base;

import com.answern.logback.config.CMQProducerProperties;
import com.answern.logback.server.CMQServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 需求名称:
 * 类描述:[一句话描述该类的功能]<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/10/12 11:17]  <br/>
 * 版本:[v1.0]   <br/>
 */
public class BaseLogger {



    private static Logger logger = LoggerFactory.getLogger(BaseLogger.class);
    /**
     * 传入打印的日志Message，按顺序打印
     * 例如： map.put("id","1234"); map.put("name","name")
     *     打印为 id:1234,name:name
     * @param map 传入要打印的日志Message
     */
    public static void loggerRecord(LinkedHashMap map){
        CMQProducerProperties cmqProducerProperties = new CMQProducerProperties();
        loggerRecord( cmqProducerProperties, map);
    }
    /**
     * 传入打印的日志Message，按顺序打印
     * 例如： map.put("id","1234"); map.put("name","name")
     *     打印为 id:1234,name:name
     * @param cmqProducerProperties 如果项目对cmq进行了修改需要传入该类
     * @param mapOrder 传入要打印的日志Message
     */

    public static void loggerRecord(CMQProducerProperties cmqProducerProperties,LinkedHashMap mapOrder){

        LinkedHashMap map = new LinkedHashMap();
        map.put("Process Id", UUID.randomUUID().toString());
        map.put("systemName",BaseUtil.getSystemName());
        map.put("ip",BaseUtil.getLocalIp());
        map.put("time Date",BaseUtil.getFormatTime());
        map.put("time",System.currentTimeMillis());
        map.putAll(mapOrder);
//        map.put("ClassName",point.getTarget().getClass().getName());
//        map.put("MethodName",point.getSignature().getName());
//        map.put("Message",test.logInfo());
        printLogger(cmqProducerProperties,map,true);
    }

    /**
     * 发送打印日志信息到cmq
     * @param cmqProducerProperties
     * @param map
     * @param isPrint
     */
    public static void printLogger(CMQProducerProperties cmqProducerProperties,LinkedHashMap map,boolean isPrint){

        StringBuffer info = new StringBuffer();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entity = (Map.Entry) it.next();
            info.append(entity.getKey());
            info.append(":");
            info.append(entity.getValue());
            if(it.hasNext()){
                info.append(",");
            }
        }
        if(isPrint){
            logger.info(info.toString());
        }
        //将日志Message发送到CMQ
        new CMQServer(cmqProducerProperties).sendMessageQueue(info.toString());
    }

}
