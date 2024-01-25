package com.myfirstbdd.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"json:target/cucumbertest.json",
				"html:target/htmlreport"
		},
		features = "src/test/resources/features",
		glue ="com.myfirstbdd.step" 
		)
public class CucumberRunnerFile {

}
