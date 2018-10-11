package com.answern.logback.controller;


import com.answern.logback.config.aop.ControllerLog;
import com.answern.logback.service.ExecuteAsyncTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 需求名称:
 * 类描述:[调用异步方法测试]<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/9/3 16:04]  <br/>
 * 版本:[v1.0]   <br/>
 */
@RestController
@RequestMapping("/executeAsyncTask")
public class ExecuteAsyncTaskController {

    private final static Logger logger = LoggerFactory.getLogger(ExecuteAsyncTaskController.class);

    @Autowired
    ExecuteAsyncTaskService executeAsyncTaskService;
    /**
     * 调用异步方法
     * @return
     */
    @RequestMapping(value = "executeAsyncTask" ,method = RequestMethod.GET)
    public String executeAsyncTask(){
        executeAsyncTaskService.executeAsyncTask(70);

        return "调用异步方法ok";
    }
    /**
     * test
     * @return
     */
    @ControllerLog(sysName = "test",logInfo = "ok")
    @RequestMapping(value = "index" ,method = RequestMethod.GET)
    public String index()  {
        String isok = null;
        try {
            isok = executeAsyncTaskService.index(70);
        } catch (Exception e) {
           // e.printStackTrace();
        }

        return isok;
    }
    @RequestMapping(value = "executeAsyncTaskReturn" ,method = RequestMethod.GET)
    public String executeAsyncTaskReturn(){
        Future<String> stringFuture = executeAsyncTaskService.executeAsyncTaskReturn(7000);
        System.out.println("方法跳过了");
        String s="";
        try {
            String s1 ="";
            try {
                 s1 = stringFuture.get(5000, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                System.out.println("is error");
            }

            boolean done = stringFuture.isDone();
            System.out.println("s1 =="+s1);
            System.out.println("done =="+done);
            //在这里等待线程执行完成
            s = stringFuture.get();
            System.out.println(s);
            System.out.println("stringFuture.isDone() =="+stringFuture.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "调用异步方法ok"+s;
    }

  

}
