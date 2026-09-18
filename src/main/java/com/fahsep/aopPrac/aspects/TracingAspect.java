package com.fahsep.aopPrac.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

    Logger logger = LoggerFactory.getLogger(TracingAspect.class);

    public boolean isEnteringCalled() {
        return enteringCalled;
    }

    boolean enteringCalled = false;

    @Before("execution(* *(..))")
    public void entering(JoinPoint joinPoint) {
        enteringCalled = true;
        logger.debug("Entering " + joinPoint.getStaticPart().getSignature().toString());
    }
}
