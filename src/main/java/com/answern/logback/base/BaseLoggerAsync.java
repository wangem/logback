package com.answern.logback.base;

import com.answern.logback.config.CMQProducerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class BaseLoggerAsync {

    @Autowired
    private CMQProducerProperties cmqProducerProperties;

    /**
     * 传入打印的日志Message，按顺序打印
     * 例如： map.put("id","1234"); map.put("name","name")
     *     打印为 id:1234,name:name
     * @param map 传入要打印的日志Message
     */
    @Async("asyncServiceExecutors")
    public  void loggerRecord(LinkedHashMap map){
        new BaseLoggerAsync().loggerRecordAsync( cmqProducerProperties, map);
    }
    /**
     * 传入打印的日志Message，按顺序打印
     * @param logInfo 传入要打印的日志Message
     */
    @Async("asyncServiceExecutors")
    public  void loggerRecord(String logInfo){
        LinkedHashMap map = new LinkedHashMap();
        map.put("logInfo",logInfo);
        new BaseLoggerAsync().loggerRecordAsync( cmqProducerProperties, map);
    }
    /**
     * 传入打印的日志Message，按顺序打印
     * 例如： map.put("id","1234"); map.put("name","name")
     *     打印为 id:1234,name:name
     * @param map 传入要打印的日志Message
     * @param isPrint 传入本系统是否需要打印该日志
     */
    @Async("asyncServiceExecutors")
    public  void loggerRecord(LinkedHashMap map,Boolean isPrint){
        new BaseLoggerAsync().loggerRecordAsync( cmqProducerProperties, map,isPrint);
    }
    /**
     * 传入打印的日志Message，按顺序打印
     * @param logInfo 传入要打印的日志Message
     * @param isPrint 是否本系统打印
     */
    @Async("asyncServiceExecutors")
    public  void loggerRecord(String logInfo,Boolean isPrint){
        LinkedHashMap map = new LinkedHashMap();
        map.put("logInfo",logInfo);
        new BaseLoggerAsync().loggerRecordAsync( cmqProducerProperties, map,isPrint);
    }
    /**
     * 传入打印的日志Message，按顺序打印
     * 例如： map.put("id","1234"); map.put("name","name")
     *     打印为 id:1234,name:name
     * @param cmqProducerProperties 如果项目对cmq进行了修改需要传入该类
     * @param map 传入要打印的日志Message
     */
    @Async("asyncServiceExecutors")
    public  void loggerRecord(CMQProducerProperties cmqProducerProperties,LinkedHashMap map){
        BaseLogger.loggerRecord( cmqProducerProperties, map);
    }
    /**
     * 传入打印的日志Message，按顺序打印
     * 例如： map.put("id","1234"); map.put("name","name")
     *     打印为 id:1234,name:name
     * @param cmqProducerProperties 如果项目对cmq进行了修改需要传入该类
     * @param map 传入要打印的日志Message
     */
    @Async("asyncServiceExecutors")
    public  void loggerRecord(CMQProducerProperties cmqProducerProperties,LinkedHashMap map,Boolean isPrint){
        BaseLogger.loggerRecord( cmqProducerProperties, map,isPrint);
    }


    void loggerRecordAsync(CMQProducerProperties cmqProducerProperties, LinkedHashMap map){
        BaseLogger.loggerRecord( cmqProducerProperties, map);
    }

    void loggerRecordAsync(CMQProducerProperties cmqProducerProperties,LinkedHashMap map,Boolean isPrint){
        BaseLogger.loggerRecord( cmqProducerProperties, map,isPrint);
    }
}
