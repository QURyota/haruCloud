package com.ryota.common.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @Author Ryota
 * @create 2022/8/5 23:55
 */
@Component
@Aspect
public class ExpiredAopAdviseDefine {

    private static final Logger logger = LoggerFactory.getLogger(ExpiredAopAdviseDefine.class);

    @Pointcut("within(com.ryota.*.controller.*)")
    public void pointCut(){
    }

    @Around("pointCut()")
    public Object methodInvokeExpiredTime(ProceedingJoinPoint pjp) throws Throwable{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 开始
        Object retVal = pjp.proceed();
        stopWatch.stop();
        // 结束

        // 上报到监控平台
        reportToMonitorSystem(pjp.getSignature().toShortString(), stopWatch.getTotalTimeMillis());

        return retVal;
    }

    public void reportToMonitorSystem(String methodName, long expiredTime) {
        logger.info("---方法 {} 被调用, 花费时间为 : {} ms---", methodName, expiredTime);
    }

}
