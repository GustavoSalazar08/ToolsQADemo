package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsTest extends Base{

	public FormsTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void practice_form_page() throws Exception {
		
		//Esconde los adds, va a la pagina Forms y pasa a la pagina Practice Form
		takeSnapShot(getdriver(), "Screenshots\\home.png");
		until(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]"));	
		WebElement ADDS = findElement(By.xpath("//*[@id=\"close-fixedban\"]/img"));
		ADDS.click();		
		takeSnapShot(getdriver(), "Screenshots\\hidden_adds.png");
		WebElement FORMS = findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]"));
		FORMS.click();		
		takeSnapShot(getdriver(), "Screenshots\\form_page.png");
		until(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/div"));	
		WebElement PFORMS = findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/div"));
		PFORMS.click();		
	}
	
	// LLena los campos requeridos en la pagina para la creación de usuario
	public void required_fields() throws Exception {				
		takeSnapShot(getdriver(), "Screenshots\\new_form.png");
	    until(By.xpath("//*[@id=\"firstName\"]"));	
		WebElement NAME = findElement(By.xpath("//*[@id=\"firstName\"]"));
		NAME.sendKeys("JOSE");		
		WebElement PASS = findElement(By.xpath("//*[@id=\"lastName\"]"));
		PASS.sendKeys("ZAMA");		
		WebElement GNDR = findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
		GNDR.click();		
		WebElement MNUMBER = findElement(By.xpath("//*[@id=\"userNumber\"]"));
		MNUMBER.sendKeys("8112345678");
		takeSnapShot(getdriver(), "Screenshots\\filled_form.png");
	}

	// Crea el usuario y regresa a la pagina principal
	public void submit_form() throws Exception {
		//Se inicializa un ejecutor de JS para el scroll down		
		WebElement SUBMIT = findElement(By.xpath("//*[@id=\"submit\"]"));
		executeScript(SUBMIT);
		SUBMIT.click();		
		takeSnapShot(getdriver(), "Screenshots\\user_info.png");
		until(By.xpath("//*[@id=\"closeLargeModal\"]"));	
		WebElement CLOSE = findElement(By.xpath("//*[@id=\"closeLargeModal\"]"));
		executeScript(CLOSE);
		CLOSE.click();		
		until(By.xpath("//*[@id=\"app\"]/header/a/img"));	
		WebElement HOME = findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));
		executeScript(HOME);
		HOME.click();		
		takeSnapShot(getdriver(), "Screenshots\\back_home.png");		
	}
}