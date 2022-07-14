package com.bdd.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/calculadora.feature"},
		stepNotifications = true,
		glue = {"com.bdd.stepdefinition"},
		tags = "@Operaciones"
		)
public class RunnerTest {

}
