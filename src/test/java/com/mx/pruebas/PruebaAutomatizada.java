package com.mx.pruebas;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PruebaAutomatizada {
	
	private static WebDriver driver = null; 
	
	//3 anotaciones. Las anotaciones sirven para establecer lo que se realizara
	//@BeforeClass: se ejecuta antes de iniciar la prueba
	//@AfterClass: Cuando acaba la prueba
	//@Test: es la prueba en si
	
	@BeforeClass
	public static void iniciarPrueba(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Day-c\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public static void matarDriver() {
		driver.quit();
	}
	
	@Test
	public void prueba() throws InterruptedException {
		driver.get("http://localhost:8080/home");
		Thread.sleep(3000);
		//xpath
		//findElement busca un elemento en el html
		this.click("/html/body/a");
		//Thread.sleep(3000);
		
		//Sirve para que la pagina espere a que el elemento al que haremos click se cargue
		WebElement esperaCargueBoton = driver.findElement(By.xpath("/html/body/a"));
		WebDriverWait wdw = new WebDriverWait(driver, 10);
		wdw.until(ExpectedConditions.visibilityOf(esperaCargueBoton));
		
		this.click("/html/body/a");
		
		//Llena los campos del formulario
		this.rellenarCajaTexto("/html/body/form/input[1]", "2");
		this.rellenarCajaTexto("/html/body/form/input[2]", "Juan");
		this.rellenarCajaTexto("/html/body/form/input[3]", "30");
		
		//Obtener lo que se encuentra dentro del elemento
		WebElement textoEnPantalla = driver.findElement(By.xpath("/html/body/h1"));
		String texto = textoEnPantalla.getText();
		System.out.println(texto);
		Thread.sleep(10000);
		
		
	}
	
	private void click(String xpath) {
		WebElement clickBoton = driver.findElement(By.xpath(xpath));
		clickBoton.click();
	}
	
	private void rellenarCajaTexto(String xpathConsulta, String texto) {
		WebElement cajaTexto = driver.findElement(By.xpath(xpathConsulta));
		cajaTexto.sendKeys(texto);
	}
	
	

}
