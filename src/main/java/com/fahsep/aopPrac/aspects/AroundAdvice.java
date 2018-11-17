package com.fahsep.aopPrac.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAdvice {

    Logger logger = LoggerFactory.getLogger(AroundAdvice.class);
    private boolean called;

    public void reset() {
        called = false;
    }

    public boolean isCalled() {
        return called;
    }

    @Around("execution(* *(..))")
    public Object trace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String methodInformation =
                proceedingJoinPoint.getStaticPart().getSignature().toString();
        logger.trace("Entering: " + methodInformation);
        called = true;
        try {
            return proceedingJoinPoint.proceed();
        }catch (Throwable ex) {
            logger.error("Exception in " + methodInformation + ex);
            throw ex;
        }finally {
            logger.trace("Exiting " + methodInformation);
        }
    }


}
