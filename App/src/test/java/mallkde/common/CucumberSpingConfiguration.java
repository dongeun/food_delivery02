package mallkde.common;


import mallkde.AppApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { AppApplication.class })
public class CucumberSpingConfiguration {
    
}
