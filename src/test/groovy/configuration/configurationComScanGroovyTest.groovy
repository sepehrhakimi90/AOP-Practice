package configuration

import com.fahsep.aopPrac.service.SimpleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = ConfigurationComScan.class)
class configurationComScanGroovyTest extends Specification {

    @Autowired
    SimpleService service

    def "Check dependency Incetion"() {
        expect:
        service != null
    }
}
