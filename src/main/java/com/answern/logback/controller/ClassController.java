package com.answern.logback.controller;

import com.answern.logback.base.BaseLoggerAsync;
import com.answern.logback.base.BaseLogger;
import com.answern.logback.config.annotation.ControllerLog;
import com.answern.logback.config.annotation.PrintLog;
import com.answern.logback.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;

/**
 * 需求名称:
 * 类描述:[一句话描述该类的功能]<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/10/11 16:44]  <br/>
 * 版本:[v1.0]   <br/>
 */
@RestController
@RequestMapping("/classcontroller")
@ControllerLog
public class ClassController {
    @Autowired
    ClassService classService;
    @Autowired
    BaseLoggerAsync basLoggerAsync;

    @RequestMapping("index")
    public String indexController(HttpServletRequest request){
        System.out.println( "this currentThread=="+Thread.currentThread().getName());
//        try {
           // Thread.sleep(200);
            long l = System.currentTimeMillis();

            LinkedHashMap map = new LinkedHashMap();
            map.put("this is oo","ooooooooooo");
            BaseLogger.loggerRecord(map);
            System.out.println("time==="+(System.currentTimeMillis()-l));

        long l2 = System.currentTimeMillis();
        basLoggerAsync.loggerRecord(  map);
        map.put("oko","这里是循环");
        System.out.println("time=22=="+(System.currentTimeMillis()-l2));

//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        classService.indexService();
        String i =indexService();
        return "pl";
    }
    @RequestMapping("index1")
    public String indexController1(HttpServletRequest request){
        return "pl";
    }
    @PrintLog
    public String indexService(){
        System.out.println( "indexService is getName=="+Thread.currentThread().getName());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //classService.indexService();
        return "is ok1111";
    }
}
