package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class ElementsTest extends Base {

	
	public ElementsTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void TextBox() throws InterruptedException {
		until(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
		WebElement ADDS = findElement(By.xpath("//*[@id=\"close-fixedban\"]/img"));
		ADDS.click();
		findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
		until(By.id("item-0"));
		findElement(By.id("item-0")).click();
		findElement(By.id("userName")).click();
		findElement(By.id("userName")).sendKeys("Alan Raymundo Alcala Mendoza");
		findElement(By.id("userEmail")).click();
		findElement(By.id("userEmail")).sendKeys("alanm9801@gmail.com");
		findElement(By.id("currentAddress")).click();
		findElement(By.id("currentAddress")).sendKeys("Cumbres del Himalaya");
		findElement(By.id("permanentAddress")).click();
		findElement(By.id("permanentAddress")).sendKeys("Cumbres del Himalaya #314");
		JavascriptExecutor js = (JavascriptExecutor) getdriver();
		WebElement SUBMIT = findElement(By.xpath("//*[@id=\"submit\"]"));
		js.executeScript("arguments[0].scrollIntoView();", SUBMIT);
		SUBMIT.click();		
	}
	
	public void RadioButton() throws InterruptedException {
		findElement(By.xpath("//*[@id=\"item-2\"]")).click();
		getwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='app']/div/div/div[2]/div[2]/div/div[2]/label")));
		findElement(By.xpath("//div[@id='app']/div/div/div[2]/div[2]/div/div[2]/label")).click();
		getwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='app']/div/div/div[2]/div[2]/div/div[3]/label")));
		findElement(By.xpath("//div[@id='app']/div/div/div[2]/div[2]/div/div[3]/label")).click();		
	}
	
	public void Buttons() throws InterruptedException {
		executeScript(findElement(By.xpath("//*[@id=\"item-4\"]")));
		findElement(By.xpath("//*[@id=\"item-4\"]")).click();
		getwait().until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));
		getaction().doubleClick(findElement(By.id("doubleClickBtn"))).perform();
		getaction().contextClick(findElement(By.id("rightClickBtn"))).perform();
		findElement(By.xpath("//*[@type='button' and text()='Click Me']")).click();				
	}
}