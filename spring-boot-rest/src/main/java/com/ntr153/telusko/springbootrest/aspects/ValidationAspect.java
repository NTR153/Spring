package com.ntr153.telusko.springbootrest.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.ntr153.telusko.springbootrest.service.JobService.getJob(..)) && args(postId)")
        // gets arguments as postId
    public Object validateAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {

        if (postId<0) {
            LOGGER.info("PostId is negative, updating it");
            postId = -postId;
            LOGGER.info("new value " + postId);
        }

        Object obj = jp.proceed(new Object[]{postId});
            // Note: new Object[]{postId} is required to be passed to jp.proceed. 
                    // Else, the original postId will be used.

        return obj;
    }
}