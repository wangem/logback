package com.answern.logback.base;

import com.answern.logback.config.aop.AopMethodServer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
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

    /**
     * 传入打印的日志信息，按顺序打印
     * 例如： map.put("id","1234"); map.put("name","name")
     *     打印为 id:1234,name:name
     * @param mapOrder 传入要打印的日志信息
     */

    public static void loggerRecord(LinkedHashMap mapOrder){
        AopMethodServer aopMethodServer = new AopMethodServer();
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
        aopMethodServer.printLogger(map,true);
    }
}
