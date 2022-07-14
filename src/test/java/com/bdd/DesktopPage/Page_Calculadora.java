package com.bdd.DesktopPage;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import junit.framework.Assert;
import net.thucydides.core.requirements.reports.FileSystemRequirmentsOutcomeFactory;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Page_Calculadora {

	WindowsDriver driver;
	
	By valor0=By.name("Cero");
	By valor1=By.name("Uno");
	By valor2=By.name("Dos");
	By valor3=By.name("Tres");
	By valor4=By.name("Cuatro");
	By valor5=By.name("Cinco");
	By valor6=By.name("Seis");
	By valor7=By.name("Siete");
	By valor8=By.name("Ocho");
	By valor9=By.name("Nueve");
	By valorSuma=By.name("Más");
	By valorResta=By.name("Menos");
	By valorMulti=By.name("Multiplicar por");
	By valorDivision=By.name("Dividido por");
	By BtnIgual=By.xpath("//*[@AutomationId='equalButton']");
	
	EnvironmentVariables variables=SystemEnvironmentVariables.createEnvironmentVariables();
	
	
	public Page_Calculadora (WindowsDriver driver) {
		this.driver=driver;
	}
	
	public void abrirCalculadora() {
		try {
			DesiredCapabilities capacidades= new DesiredCapabilities();
			capacidades.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
			capacidades.setCapability("devicename", "WindowsPC");
			capacidades.setCapability("PlatformName", "Windows");
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723/wd/hub"),capacidades);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void RealizarOperacion(String parmuno, String parmdos,String TipoOperacion) {
		try {
			driver.findElement(parametros(parmuno)).click();
			driver.findElement(parametros(TipoOperacion)).click();
			driver.findElement(parametros(parmdos)).click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public By parametros(String parm) {
		By resultado =null;
		try {
			if(parm.equalsIgnoreCase("0")) {resultado=valor0;}
			else if (parm.equalsIgnoreCase("1")) {resultado=valor1;}
			else if (parm.equalsIgnoreCase("2")) {resultado=valor2;}
			else if (parm.equalsIgnoreCase("3")) {resultado=valor3;}
			else if (parm.equalsIgnoreCase("4")) {resultado=valor4;}
			else if (parm.equalsIgnoreCase("5")) {resultado=valor5;}
			else if (parm.equalsIgnoreCase("6")) {resultado=valor6;}
			else if (parm.equalsIgnoreCase("7")) {resultado=valor7;}
			else if (parm.equalsIgnoreCase("8")) {resultado=valor8;}
			else if (parm.equalsIgnoreCase("9")) {resultado=valor9;}
			else if (parm.equalsIgnoreCase("+")) {resultado=valorSuma;}
			else if (parm.equalsIgnoreCase("-")) {resultado=valorResta;}
			else if (parm.equalsIgnoreCase("*")) {resultado=valorMulti;}
			else if (parm.equalsIgnoreCase("/")) {resultado=valorDivision;}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
		
	}
	public void presionarIgual() {
		try {
			
			driver.findElement(BtnIgual).click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void validarOperacion(int parmuno,int parmdos,String tipoOperacion) {
		String resultado="";
				
		try {
			if (tipoOperacion.equalsIgnoreCase("+")) {
				resultado=""+(parmuno+parmdos);
			}else if (tipoOperacion.equalsIgnoreCase("-")) {
				resultado=""+(parmuno-parmdos);
			}else if (tipoOperacion.equalsIgnoreCase("*")) {
				resultado=""+(parmuno*parmdos);
			}else if (tipoOperacion.equalsIgnoreCase("/")) {
				resultado=""+(parmuno/parmdos);
			}
			
			String resulCal=driver.findElement(By.xpath("//*[@AutomationId='CalculatorResults']")).getText();
			
			System.out.println("resultado: "+resultado);
			System.out.println("resulCal : "+resulCal);
					
			Assert.assertEquals("Validacion del resultado fallo: ", resultado, resulCal.replace("Se muestra", "").trim());
			
			System.out.println(variables.getProperty("integrante")+"     "+variables.getProperty("mensaje"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} catch	(AssertionError e){
			System.out.println(e.getMessage());
		}
	}
	
}
