package com.fahsep.aopPrac.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class TracingAspect {

    public boolean isEnteringCalled() {
        return enteringCalled;
    }

    boolean enteringCalled = false;

    @Before("execution(* *(..))")
    public void entering(JoinPoint joinPoint) {
        enteringCalled = true;
        System.out.println("Entering " + joinPoint.getStaticPart().getSignature().toString());
    }
}
