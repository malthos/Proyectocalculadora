package com.bdd.stepdefinition;

import com.bdd.step.Step_Calculadora;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition_Calculadora {

	Step_Calculadora stpcalculadora=new Step_Calculadora();
	
	@Given("que abro la apicacion de la calculadora")
	public void que_abro_la_apicacion_de_la_calculadora() {
		
		stpcalculadora.abrirCalculadora();
	}
	@When("Cuando ingreso los parametros de la operacion (.*),(.*),(.*)$")
	public void cuando_ingreso_los_parametros_de_la_operacion(String parm1,String parm2,String tipope) {
		stpcalculadora.RealizarOperacion(parm1, parm2, tipope);
	}
	@And("hago clic en la tecla igual")
	public void hago_clic_en_la_tecla_igual() {
		stpcalculadora.presionarIgual();
	}
	@Then("valido el resultado de la operacion (.*),(.*),(.*)$")
	public void valido_el_resultado_de_la_operacion(int parm1,int parm2,String tipope) {
		stpcalculadora.validarOperacion(parm1, parm2, tipope);
	}



	
}
