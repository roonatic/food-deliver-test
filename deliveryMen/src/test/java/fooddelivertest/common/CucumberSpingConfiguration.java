package fooddelivertest.common;


import fooddelivertest.DeliveryMenApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { DeliveryMenApplication.class })
public class CucumberSpingConfiguration {
    
}
