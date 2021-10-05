package com.project.pom;

import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AlertsFramesWindowsTest extends Base{

	public AlertsFramesWindowsTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void sectionModalItemList() {
		
//		  Click on alert card
		  WebElement AlertCard = getWebElement("//*[@class=\"category-cards\"]/div/div/div/h5[contains(text(),'Alerts')]");
		  getwait().until(ExpectedConditions.elementToBeClickable(AlertCard));
		  executeScript(AlertCard);
		  AlertCard.click();
//		click on the List item of alerts 	  
		  getwait().until(ExpectedConditions.elementToBeClickable(By.tagName("img")));
		  getWebElement("//*[@class='header-text']/text()[contains(.,'Alerts')]/..").click();
		  getWebElement("//*[@class='header-text']/text()[contains(.,'Alerts')]/..").click();
//		  verify that after the click the list element will be visible
		  getwait().until(ExpectedConditions.attributeContains(getWebElement("//*[@class='header-text']/text()[contains(.,'Alerts')]/ancestor::div[@class='element-group']/div"),"class", "show"));
		  String classes = getWebElement("//*[@class='header-text']/text()[contains(.,'Alerts')]/ancestor::div[@class='element-group']/div").getAttribute("class");
		  assertTrue(classes.contains("show"));
	  }
	  
	  public void modalViewDisplay() {
//		  Click de modal option inside the alert, modal, frames section
		  executeScript(getWebElement("//*[@class=\"menu-list\"]/li/span[contains(text(),'Modal')]"));
		  getWebElement("//*[@class=\"menu-list\"]/li/span[contains(text(),'Modal')]").click();
		  getwait().until(ExpectedConditions.attributeContains(findElement(By.id("modalWrapper")), "id", "modalWrapper"));
		  getwait().until(ExpectedConditions.elementToBeClickable(By.id("showSmallModal")));
//		  seek for a text in  the modal of the modal view and search for more than one button inside the view too
		  String modalText = findElement(By.xpath("//*[@id='modalWrapper']/div/div")).getText();
		  List<WebElement> buttons = findElements(By.xpath("//*[@id='modalWrapper']/div/button"));
		  assertTrue(!modalText.isEmpty() && buttons.size()>1);
	  }
	  	
	  public void modalClassType()  {	
		  WebElement popup = findElement(By.xpath("//a[@id='close-fixedban']"));
		  if(popup.isDisplayed()) popup.click();
		  List<WebElement> buttons = findElements(By.xpath("//*[@id='modalWrapper']/div/button"));
		  
		  getwait().until(ExpectedConditions.elementToBeClickable(buttons.get(0)));
		  buttons.get(0).click();
		  getwait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,'modal-sm')]")));
		  findElement(By.id("closeSmallModal")).click();
		  
		  getwait().until(ExpectedConditions.elementToBeClickable(buttons.get(1)));
		  buttons.get(1).click();
		  getwait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,'modal-lg')]")));
		  findElement(By.id("closeLargeModal")).click();
		  
	  }
	  
	  public void framesSection()  {
		  getdriver().get("https://demoqa.com/");
		  until(By.xpath("//*[@class=\"category-cards\"]/div/div/div/h5[contains(text(),'Alerts')]"));
		  WebElement AlertCard = getWebElement("//*[@class=\"category-cards\"]/div/div/div/h5[contains(text(),'Alerts')]");
		  executeScript(AlertCard);
		  getwait().until(ExpectedConditions.elementToBeClickable(AlertCard));
		  AlertCard.click();
		  //getwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\\\"menu-list\\\"]/li/span[contains(text(),'Frames')]")));
		  getWebElement("//*[@class=\"menu-list\"]/li/span[contains(text(),'Frames')]").click();
		  getwait().until(ExpectedConditions.presenceOfElementLocated(By.id("framesWrapper")));
		  WebElement frameViewElement = findElement(By.id("framesWrapper"));
		  assertTrue(getdriver().getCurrentUrl().equals("https://demoqa.com/frames") && frameViewElement.isDisplayed());
	  }
	  	
	  public void frameSectionIframe()  {
		  getdriver().switchTo().frame("frame1");
		 assertTrue(!findElement(By.id("sampleHeading")).getText().isEmpty());
	  }
	  
	  public WebElement getWebElement(String xpath) {
		  return findElement(By.xpath(xpath));
	  }
}