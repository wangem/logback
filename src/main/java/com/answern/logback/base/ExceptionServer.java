package com.answern.logback.base;

import com.alibaba.fastjson.JSON;
import com.sun.java.browser.plugin2.liveconnect.v1.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
public class ExceptionServer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     *  @需求名称：[需求/BUG名称]
     *  @功能:[捕获系统所有异常,以免暴露错误给外部]
     *  @创建人:[@wem]
     *  @创建日期:2018年10月25日 下午2:23:20
     *  @功能说明：
     *	   1.说明1；<br/>
     *	   2.说明2。<br/>
     *     ······
     *  @param ex
     *  @return
     */
    @ExceptionHandler(value = Exception.class)
    public String processorException(Exception ex) {
        this.logger.warn("非车理赔渠道平台出现异常-系统日期 {} , 错误信息: {} ",
                BaseUtil.getFormatTime() , ex.getMessage());
        this.logger.error(ex.getMessage());
        String formatDate = BaseUtil.getFormatTime();
        Result result = new Result("000000" ,true);
        return JSON.toJSONString(result);
    }

}
