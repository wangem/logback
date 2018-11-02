//package com.answern.logback.controller;
//
//import com.answern.logback.config.aop.ControllerLog;
//import com.answern.logback.service.ClassService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 需求名称:
// * 类描述:[一句话描述该类的功能]<br/>
// *
// * @author [wem] <br/>
// * 创建时间:[2018/10/11 16:44]  <br/>
// * 版本:[v1.0]   <br/>
// */
//@RestController
//@RequestMapping("/classcontroller")
//public class ClassController {
//
//
//    @Autowired
//    ClassService classService;
//
//    @RequestMapping("index")
//    @ControllerLog
//    public String indexController(HttpServletRequest request){
//
//        System.out.println( "this is url=="+request.getRequestURI());
//        System.out.println( "this is uLL=="+request.getRequestURL());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        classService.indexService();
//        return "ok";
//    }
//}
