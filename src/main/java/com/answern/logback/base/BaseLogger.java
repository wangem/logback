package com.answern.logback.base;

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
     * 传入打印的日志信息，按顺序打印
     * 例如： map.put("id","1234"); map.put("name","name")
     *     打印为 id:1234,name:name
     * @param mapOrder 传入要打印的日志信息
     */

    public static void loggerRecord(LinkedHashMap mapOrder){

        LinkedHashMap map = new LinkedHashMap();
        map.put("流程Id", UUID.randomUUID().toString());
        map.put("系统名称",BaseUtil.getSystemName());
        map.put("ip",BaseUtil.getLocalIp());
        map.put("当前时间",BaseUtil.getFormatTime());
        map.put("time",System.currentTimeMillis());
        map.putAll(mapOrder);
//        map.put("类名称",point.getTarget().getClass().getName());
//        map.put("方法名称",point.getSignature().getName());
//        map.put("信息",test.logInfo());
        printLogger(map,true);
    }

    /**
     *整理输出信息
     * @param map
     */
    public static void printLogger(LinkedHashMap map,boolean isPrint){
        CMQServer cmqServer   = new CMQServer();


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
        //将日志信息发送到CMQ
        cmqServer.sendMessageQueue(info.toString());
    }

}
