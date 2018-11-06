package com.answern.logback.config.aop;

import com.answern.logback.config.CMQProducerProperties;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * 需求名称:
 * 类描述:[一句话描述该类的功能]<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/9/18 8:13]  <br/>
 * 版本:[v1.0]   <br/>
 */

@Aspect
@Order(0) // 控制多个Aspect的执行顺序，越小越先执行
public class AopAspects {

    private Logger logger = LoggerFactory.getLogger(AopAspects.class);
    private String id = null;
    @Autowired
    AopMethodServer aopMethodServer;

    @Autowired
    private CMQProducerProperties cmqProducerProperties;

    @Around("@annotation(test)")
    public Object aroundMethodLog(ProceedingJoinPoint point,MethodLog test) throws Throwable {

        if (!StringUtils.isNotEmpty(id)){
            id = UUID.randomUUID().toString();
        }
        System.out.print(cmqProducerProperties.getQueue_endpoint());

        String cid =UUID.randomUUID().toString();
        //System.out.println("After MethodLog");
        // 调用前日志处理
        aopMethodServer.aopMethodBefore(id,cid,point, test);
        Object aThis =point.proceed();
//         调用后日志处理
        aopMethodServer.aopMethodAfter(id,cid, point, test);
        return aThis;
    }

    @Around("@annotation(test)")
    public Object aroundControllerLog(ProceedingJoinPoint point, ControllerLog test) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        id = UUID.randomUUID().toString();
        // 调用前日志处理
        aopMethodServer.aopControllerBefore(id, point, test, request);
        Object aThis = point.proceed();
        // 调用后日志处理
        aopMethodServer.aopControllerAfter(id,  test);
        return aThis;
    }

    @AfterThrowing(value = "@annotation(test)", throwing = "e")
    public void afterThrowingMethodLog(JoinPoint joinPoint, MethodLog test, Exception e) {
        aopMethodServer.aopMethodAfterThrowing(id, joinPoint, test, e);
    }

    @AfterThrowing(value = "@annotation(test)", throwing = "e")
    public void afterThrowingControllerLog(JoinPoint joinPoint, ControllerLog test, Exception e) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        aopMethodServer.aopControllerAfterThrowing(id, joinPoint, test, request, e);
    }

//    private String id;
//    @Before("@annotation(test)")
//    public void Before(JoinPoint point, MethodLog test) throws Throwable {
//          id = UUID.randomUUID().toString();
//        aopMethodServer.aopMethodBefore1(id,point,test);
//    }
//    @After("@annotation(test)")
//    public void After(JoinPoint point, MethodLog test) throws Throwable {
//
//        aopMethodServer.aopMethodAfter1(id,point,test);
//    }

    /**
     * 返回parameter中类似  "#user.getUserName()" 的数据
     * <p>
     * 调用方法  Method method = getMethod(joinPoint);　//自定义注解类
     * Cacheable cacheable = method.getAnnotation(Cacheable.class);<br>　　　　　//获取key值　<br>　　　　　String key = cacheable.key();<br>　　　　　String fieldKey=cacheable.fieldKey();<br>
     * 获取方法的返回类型,让缓存可以返回正确的类型
     * Class returnType=((MethodSignature)joinPoint.getSignature()).getReturnType();<br>　　　　<br>　　　　　下面就是根据业务来自行操作
     *
     * @param pjp
     * @return
     */
    private Method getMethod(JoinPoint pjp) {
        //获取parameter的类型
        Object[] args = pjp.getArgs();
        Class[] argTypes = new Class[pjp.getArgs().length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        Method method = null;
        try {
            method = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), argTypes);
        } catch (NoSuchMethodException e) {
            logger.error("annotation no sucheMehtod", e);
        } catch (SecurityException e) {
            logger.error("annotation SecurityException", e);
        }
        return method;

    }


}
