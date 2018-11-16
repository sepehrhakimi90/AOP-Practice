package configuration;

import com.fahsep.aopPrac.service.SimpleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigurationComScan.class)
public class configurationComScanTest {

    @Autowired
    SimpleService service;

    @Test
    public void testDependencyInject() {
        assertNotNull(service);
    }
}