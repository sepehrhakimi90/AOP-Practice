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
public class AfterReturningAdviceTest {

    @Autowired
    AfterReturningAdvice afterReturningAdvice;

    @Autowired
    SimpleService simpleService;

    @Before
    public void reset() {
        afterReturningAdvice.reset();
    }

    @Test
    public void afterReturningIsNotCalledIfRetunTypeDoesntMatch() {
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
        simpleService.returnsInt();
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
    }

    @Test(expected = RuntimeException.class)
    public void afterReturningIsNotCalledIfExceptionIsThrow() {
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
        try {
            simpleService.throwsRuntimeException();
        }finally {
            assertFalse(afterReturningAdvice.isAfterReturningCalled());
        }
    }

    @Test
    public void afterReturningIsCalledIfReturnTypeMatched() {
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
        simpleService.returnsString();
        assertTrue(afterReturningAdvice.isAfterReturningCalled());
    }
}