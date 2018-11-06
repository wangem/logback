package com.answern.logback.config.aop;

import com.answern.logback.base.BaseLogger;
import com.answern.logback.base.BaseUtil;
import com.answern.logback.config.CMQProducerProperties;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;


/**
 * 需求名称:
 * 类描述:[一句话描述该类的功能]<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/9/18 8:13]  <br/>
 * 版本:[v1.0]   <br/>
 */

public class AopMethodServer {

    //private  Logger logger = LoggerFactory.getLogger(AopMethodServer.class);

    @Autowired
    private CMQProducerProperties cmqProducerProperties;

    /**
     * Method执行方法之前调用
     *
     * @param id
     * @param point
     * @param test
     * @throws InterruptedException
     */
    @Async("asyncServiceExecutors")
    void aopMethodBefore(String id,String cid, ProceedingJoinPoint point, MethodLog test) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("Process Id",id);
        map.put("cid",cid);
        map.put("systemName",BaseUtil.getSystemName());
        map.put("ip",BaseUtil.getLocalIp());
        map.put("time Date",BaseUtil.getFormatTime());
        map.put("time",System.currentTimeMillis());
        map.put("ClassName",point.getTarget().getClass().getName());
        map.put("MethodName",point.getSignature().getName());
        map.put("Message",test.logInfo());
        map.put("start","ok");
        boolean isPrint = test.isTrue();
        BaseLogger.printLogger(cmqProducerProperties,map,isPrint);
//        logger.info("id:{},systemName:{},ip:{},time Date:{} , time:{},ClassName:{},MethodName:{},Message:{}，start",
//                id, test.sysName(), BaseUtil.getLocalIp(), BaseUtil.getFormatTime(), System.currentTimeMillis(),
//                point.getTarget().getClass().getName(), point.getSignature().getName(), test.logInfo());

    }

    /**
     * Method执行方法之后调用的方法
     *
     * @param id
     * @param point
     * @param test
     */
    @Async("asyncServiceExecutors")
    void aopMethodAfter(String id,String cid, ProceedingJoinPoint point, MethodLog test) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("Process Id",id);
        map.put("cid",cid);
        map.put("systemName",BaseUtil.getSystemName());
        map.put("ip",BaseUtil.getLocalIp());
        map.put("time Date",BaseUtil.getFormatTime());
        map.put("time",System.currentTimeMillis());
        map.put("end","ok");
        boolean isPrint = test.isTrue();
        BaseLogger.printLogger(cmqProducerProperties,map,isPrint);
    }

    /**
     * Controller执行方法之前调用
     *
     * @param id
     * @param point
     * @param test
     * @throws InterruptedException
     */
    @Async("asyncServiceExecutors")
    void aopControllerBefore(String id, ProceedingJoinPoint point, ControllerLog test, HttpServletRequest request) {

        LinkedHashMap map = new LinkedHashMap();
        map.put("Process Id",id);
        map.put("systemName",BaseUtil.getSystemName());
        map.put("ip",BaseUtil.getLocalIp());
        map.put("time Date",BaseUtil.getFormatTime());
        map.put("time",System.currentTimeMillis());

        try {
            if(StringUtils.isNotEmpty(request.getRequestURL())){
                map.put("RequestURL",request.getRequestURL());
            } else {
                map.put("RequestURL","get URL is null");
            }
            map.put("RequestType",request.getMethod());
            map.put("parameter",request.getQueryString());
        }catch (Exception e){
            map.put("Request","Request Return too fast so request is null");
        }
        map.put("ClassName",point.getTarget().getClass().getName());
        map.put("MethodName",point.getSignature().getName());
        map.put("Message",test.logInfo());
        map.put("start","ok");
        boolean isPrint = test.isTrue();
        BaseLogger.printLogger(cmqProducerProperties,map,isPrint);
    }

    /**
     * Controller执行方法之后调用的方法
     *
     * @param id
     * @param test
     */
    @Async("asyncServiceExecutors")
    void aopControllerAfter(String id,   ControllerLog test) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("Process Id",id);
        map.put("systemName",BaseUtil.getSystemName());
        map.put("ip",BaseUtil.getLocalIp());
        map.put("time Date",BaseUtil.getFormatTime());
        map.put("time",System.currentTimeMillis());
        map.put("end","ok");
        boolean isPrint = test.isTrue();
        BaseLogger.printLogger(cmqProducerProperties,map,isPrint);
    }

    /**
     * Controller抛出异常后调用方法
     *
     * @param id
     * @param point
     * @param test
     */
    @Async("asyncServiceExecutors")
    void aopControllerAfterThrowing(String id, JoinPoint point, ControllerLog test, HttpServletRequest request, Exception e) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("Process Id",id);
        map.put("systemName",BaseUtil.getSystemName());
        map.put("ip",BaseUtil.getLocalIp());
        map.put("time Date",BaseUtil.getFormatTime());
        map.put("time",System.currentTimeMillis());
        map.put("RequestURL",request.getRequestURL().toString());
        map.put("RequestType",request.getMethod());
        map.put("parameter",request.getQueryString());
        map.put("ClassName",point.getTarget().getClass().getName());
        map.put("MethodName",point.getSignature().getName());
        map.put("Message",test.logInfo());
        map.put("ErrorInfo",e);
        boolean isPrint = test.isTrue();
        BaseLogger.printLogger(cmqProducerProperties,map,isPrint);
    }

    /**
     * MethodLog抛出异常后调用方法
     *
     * @param id
     * @param point
     * @param test
     */
    @Async("asyncServiceExecutors")
    void aopMethodAfterThrowing(String id, JoinPoint point, MethodLog test, Exception e) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("Process Id",id);
        map.put("systemName",BaseUtil.getSystemName());
        map.put("ip",BaseUtil.getLocalIp());
        map.put("time Date",BaseUtil.getFormatTime());
        map.put("time",System.currentTimeMillis());
        map.put("ClassName",point.getTarget().getClass().getName());
        map.put("MethodName",point.getSignature().getName());
        map.put("Message",test.logInfo());
        map.put("ErrorInfo",e);
        boolean isPrint = test.isTrue();
        BaseLogger.printLogger(cmqProducerProperties,map,isPrint);
    }

    /**
     * 获取方法的中文备注____用于记录用户的操作日志描述
     */
    private MethodLog getMethodRemark(ProceedingJoinPoint joinPoint) {
        try {
            //返回目标对象
            Object target = joinPoint.getTarget();
            String targetName = target.getClass().getName();
            //返回当前连接点签名
            String methodName = joinPoint.getSignature().getName();
            //获得parameter列表
            Object[] arguments = joinPoint.getArgs();

            Class targetClass = Class.forName(targetName);
            Method[] method = targetClass.getMethods();
            //这个怎么这么low呢。
            for (Method m : method) {
                if (m.getName().equals(methodName)) {
                    Class[] tmpCs = m.getParameterTypes();
                    if (tmpCs.length == arguments.length) {
                        MethodLog methodCache = m.getAnnotation(MethodLog.class);
                        if (methodCache != null) {
                            return methodCache;
                        }
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
