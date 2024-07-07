package com.ntr153.telusko.springbootrest.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    
        private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.ntr153.telusko.springbootrest.service.JobService.getJob(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {

        long start = System.currentTimeMillis();

        Object obj = jp.proceed();      // jp.proceed returns Object. Hence, return type for monitorTime() is Object
            // Note: before this step, everything is processed at the call of method.
                    //  the code after this is called at the end / upon execution

        long end = System.currentTimeMillis();
        
        LOGGER.info("Time taken : " + (end-start) + "ms");

        return obj;         // if an Object is not returned, postman API won't work
    }
}
