package com.analysis.ainusers.method;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
/**
 * @author: tianyong
 * @date: 2019/11/12 13:53
 * @desciption:记录方法运行时间 (自定义切点)
 */
@Aspect
@Component
public class RecordMethod {

    // 获取目标Logger
    private static final Logger log = LoggerFactory.getLogger(RecordMethod.class);
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();


    /**
      * @author: tianyong
      * @date: 2019/11/12
      * @description:声明切点
    */
    // 第一种方式
    // @Pointcut("@annotation(com.analysis.ainusers.method.Record)")
    // private void cutpoint() {}
    // 第二种方式 (默认切入点)
    //public static final String POINT_CUT = "execution(public * com.analysis.ainusers..*.*(..))";
    public static final String POINT_CUT = "execution(public * *(..))";



    /**
      * @author: tianyong
      * @date: 2019/11/12
      * @description:环绕通知
    */
    @Around(POINT_CUT)
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取目标：类名、方法名
        String clazzName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();


        // 计算时间逻辑
        startTime.set(System.currentTimeMillis());
        // 调用目标方法
        Object result = joinPoint.proceed();
        log.info("方法路径为:{}/{}()",clazzName,methodName);
        log.info("处理时间为:{}s", (System.currentTimeMillis() - startTime.get()) / (1000 * 1.0));


        //打印请求体
        /*ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("请求地址:{}," +
                 "请求方式:{}," +
                 "请求类方法:{}," +
                 "请求类方法参数:{}," +
                 "RemoteHost:{}," +
                 "Content-type:{}," +
                 "User-Agent:{}",
                 request.getRequestURL(),
                 request.getMethod(),
                 joinPoint.getSignature(),
                 isUpload(request)==true?"上传文件不打印参数": Arrays.toString(joinPoint.getArgs()),
                 request.getRemoteHost(),
                 request.getHeader("Content-type"),
                 request.getHeader("User-Agent"));*/
    }


    /**
     * @author: tianyong
     * @date: 2019/11/12
     * @return:boolean
     * @description:是否是上传文件请求头
     */
    /*private boolean isUpload(HttpServletRequest request) {
        return StringUtils.containsIgnoreCase(request.getHeader("Content-type"),"multipart/form-data")?true:false;
    }*/

}
