package com.ntr153.telusko.springbootrest.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect         // This is an advice
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // * *.*(..) -> all return types, all class names, all methods, all arguments
    // return type, qualified class name, method name, arguments to be included
    @Before("execution(* com.ntr153.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.ntr153.telusko.springbootrest.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method called " + jp.getSignature().getName());
    }
    // call this before execution of a method

    @After("execution(* com.ntr153.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.ntr153.telusko.springbootrest.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method executed " + jp.getSignature().getName());
    }
    // finally, call this after execution of a method

    @AfterReturning("execution(* com.ntr153.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.ntr153.telusko.springbootrest.service.JobService.updateJob(..))")
    public void logMethodExecutionSuccessful(JoinPoint jp) {
        LOGGER.info("Method Executed Successfully " + jp.getSignature().getName());
    }
    // try, only on successful execution

    @AfterThrowing("execution(* com.ntr153.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.ntr153.telusko.springbootrest.service.JobService.updateJob(..))")
    public void logMethodCrash(JoinPoint jp) {
        LOGGER.info("Method has some issues " + jp.getSignature().getName());
    }
    // catch, when an error is thrown
}
