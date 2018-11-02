//package com.answern.logback.service;
//
//import com.answern.logback.config.aop.MethodLog;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.AsyncResult;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.Future;
//
///**
// * 需求名称:
// * 类描述:[一句话描述该类的功能]<br/>
// *
// * @author [wem] <br/>
// * 创建时间:[2018/9/4 15:19]  <br/>
// * 版本:[v1.0]   <br/>
// */
//@Service
//public class AsyncTaskService {
//
//    private Logger logger = LoggerFactory.getLogger(AsyncTaskService.class);
//
//    @Async("asyncServiceExecutors")
//    @MethodLog(logInfo = "is test")
//    public  void executeAsyncTask(Integer n){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("异步任务执行："+n);
//    }
//
//    @Async("asyncServiceExecutors")
//    public Future<String> executeAsyncTaskReturn(Integer n){
//        try {
//            System.out.println("this is main thread");
//            Thread.sleep(n);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("异步任务执行返回："+n);
//        return new AsyncResult<>("任务完成");
//    }
//
//    @MethodLog(logInfo = "is test index return")
//    public String index(int i) throws Exception  {
//
//        logger.info("this is main thread");
//        try {
//
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if (1==1){
//            //throw new Exception("is error");
//        }
//
//
//        return "ok";
//    }
//}
