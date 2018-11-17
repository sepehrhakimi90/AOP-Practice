package com.fahsep.aopPrac.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAdvice {

    private boolean beforecalled = false;

    Logger logger = LoggerFactory.getLogger(BeforeAdvice.class);

    public void reset() {
        beforecalled = false;
    }

    public boolean isBeforecalled() {
        return beforecalled;
    }

    @Before("execution(void doSomething())")
    public void entering(JoinPoint joinPoint) {
        beforecalled = true;
        logger.trace("entering " + joinPoint.getStaticPart().getSignature().toLongString());
    }
}
