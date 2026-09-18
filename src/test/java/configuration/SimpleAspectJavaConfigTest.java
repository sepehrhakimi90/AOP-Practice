package configuration;

import com.fahsep.aopPrac.aspects.TracingAspect;
import com.fahsep.aopPrac.service.SimpleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigurationComScan.class)
public class SimpleAspectJavaConfigTest {

    @Autowired
    TracingAspect tracingAspect;

    @Autowired
    SimpleService simpleService;

    @Test
    public void aspectIsCalled() {
        assertFalse(tracingAspect.isEnteringCalled());
        simpleService.doSomethingElse(5);
        assertTrue(tracingAspect.isEnteringCalled());
    }

}