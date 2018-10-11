package com.answern.logback.controller;

import com.answern.logback.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class ClassController {

    @Autowired
    ClassService classService;
    @RequestMapping("index")
    public String indexController(){
        classService.indexService();
        return "ok";
    }
}
