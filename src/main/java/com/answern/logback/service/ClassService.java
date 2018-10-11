package com.answern.logback.service;

import com.answern.logback.config.aop.ClassLog;
import org.springframework.stereotype.Service;

import java.beans.Transient;

/**
 * 需求名称:
 * 类描述:[一句话描述该类的功能]<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/10/11 16:46]  <br/>
 * 版本:[v1.0]   <br/>
 */
@Service
@ClassLog(sysName = "thisClassname",logInfo = "ok")
public class ClassService {

    public String indexService(){
        return "is ok";
    }
}
