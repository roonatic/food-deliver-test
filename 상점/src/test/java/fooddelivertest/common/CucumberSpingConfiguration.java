package fooddelivertest.common;


import fooddelivertest.상점Application;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { 상점Application.class })
public class CucumberSpingConfiguration {
    
}
