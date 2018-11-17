package com.fahsep.aopPrac.aspects;

import com.fahsep.aopPrac.service.SimpleService;
import configuration.ConfigurationComScan;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigurationComScan.class)
public class AfterAdviceTest {

    @Autowired
    AfterAdvice afterAdvice;

    @Autowired
    SimpleService simpleService;

    @Before
    public void reset() {
        afterAdvice.reset();
    }

    @Test
    public void afterAspectIsCalledIfMethodReturnSuccessfully() {
        assertFalse(afterAdvice.isAfterCalled());
        simpleService.doSomthing();
        assertTrue(afterAdvice.isAfterCalled());
    }

    @Test(expected = RuntimeException.class)
    public void afterAspectIsCalledIfMethodThrowsException() {
        assertFalse(afterAdvice.isAfterCalled());
        try {
            simpleService.throwsRuntimeException();
        } finally {
            assertTrue(afterAdvice.isAfterCalled());
        }
    }
}