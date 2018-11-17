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
@ContextConfiguration( classes = ConfigurationComScan.class)
public class BeforeAdviceTest {
    @Autowired
    BeforeAdvice beforeAdvice;

    @Autowired
    SimpleService simpleService;

    @Before
    public void reset() {
        beforeAdvice.reset();
    }

    
}