package com.bdd.step;

import com.bdd.DesktopPage.Page_Calculadora;

import io.appium.java_client.windows.WindowsDriver;

public class Step_Calculadora {

	WindowsDriver driver=null;
	
	Page_Calculadora pgcalculadora=new Page_Calculadora(driver);
	
	public void abrirCalculadora() {
		pgcalculadora.abrirCalculadora();
	}
	
	public void RealizarOperacion(String parmuno, String parmdos,String TipoOperacion) {
		pgcalculadora.RealizarOperacion(parmuno, parmdos, TipoOperacion);
	}
	
	public void presionarIgual() {
		pgcalculadora.presionarIgual();
	}
	
	public void validarOperacion(int parmuno,int parmdos,String tipoOperacion) {
		pgcalculadora.validarOperacion(parmuno, parmdos, tipoOperacion);
	}
}
