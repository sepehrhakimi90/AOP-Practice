package com.fahsep.aopPrac.aspects;

import com.fahsep.aopPrac.service.SimpleService;
import configuration.ConfigurationComScan;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigurationComScan.class)
public class AroundAdviceTest {
    @Autowired
    AroundAdvice aroundAdvice;

    @Autowired
    SimpleService simpleService;

    @Before
    public void reset() {
        aroundAdvice.reset();
    }

    @Test
    public void aroundAdviceIsCalledForSimpleMethod() {
        assertFalse(aroundAdvice.isCalled());
        simpleService.doSomthing();
        assertTrue(aroundAdvice.isCalled());
    }

    @Test(expected = RuntimeException.class)
    public void aroundAdviceIsCalledIfExceptionIsThrown() {
        assertFalse(aroundAdvice.isCalled());
        try{
            simpleService.throwsRuntimeException();
        }finally {
            assertTrue(aroundAdvice.isCalled());
        }
    }
}