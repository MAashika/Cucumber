package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFile/login.feature" ,
                 glue="stepdefinition",
                 dryRun=false,
                 monochrome=true,
                 plugin = {"html:cucumber-reports/report.html"}
              
                 
                 )
                 

public class RunnerClass {
    
	public RunnerClass() {
		// It should combine the Feature file and step definition
		
	}

}
