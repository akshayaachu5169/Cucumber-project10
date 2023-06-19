package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags= "@login" , glue= {"stepDefinitions"},features = {"src\\test\\resources\\features"} )
public class RunnerClass {

	}
