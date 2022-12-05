package mallkde.common;


import mallkde.AdressCheckApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { AdressCheckApplication.class })
public class CucumberSpingConfiguration {
    
}
