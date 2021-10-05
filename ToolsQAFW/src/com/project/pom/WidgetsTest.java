package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WidgetsTest extends Base{
	
	private String bodyXpath = "//body";
	private String linkWidgetsXpath = "//div[@class='category-cards']/div[4]";
	private String linkDatePickerXPath = "//span[contains(text(), 'Date Picker')]";
	private String inputDateXpath = "//*[@id=\"datePickerMonthYearInput\"]";
	private String linkAccordianXPath = "//span[contains(text(), 'Accordian')]";
	private String sectionComeFromXPath = "//*[@id=\"section2Heading\"]";
	private String sectionUseItFromXPath = "//*[@id=\"section3Heading\"]";
	private String searchRedXPath = "//div[contains(text(), 'Red')]";
	private String searchGreenXPath = "//div[contains(text(), 'Green')]";
	private String linkAutocompleteXpath = "//span[contains(text(), 'Auto Complete')]";
	private String inputAutoCompleteXpath = "//*[@id=\"autoCompleteMultipleInput\"]";
	private String inputColorListXpath = "//div[@class='auto-complete__menu css-26l3qy-menu']";

	public WidgetsTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void testAccordian() {		

		WebElement widgetsElement = findElement(By.xpath(linkWidgetsXpath));
		executeScript(widgetsElement);		
		getwait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(linkWidgetsXpath)));
		widgetsElement.click();				

		WebElement accordianElement = findElement(By.xpath(linkAccordianXPath));
		executeScript(accordianElement);		
		getwait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(linkAccordianXPath)));
		accordianElement.click();		
		
		WebElement sectionComeFromElement = findElement(By.xpath(sectionComeFromXPath));
		executeScript(sectionComeFromElement);
		sectionComeFromElement.click();		
		
		WebElement sectionUseItElement = findElement(By.xpath(sectionUseItFromXPath));
		executeScript(sectionUseItElement);
		sectionUseItElement.click();		
	}

	public void testAutoComplete() {		

		WebElement sliderElement = findElement(By.xpath(linkAutocompleteXpath));
		executeScript(sliderElement);
		sliderElement.click();
		
		WebElement autoCompleteElement = findElement(By.xpath(inputAutoCompleteXpath));
		autoCompleteElement.sendKeys("re");
		
		WebElement listElement = findElement(By.xpath(inputColorListXpath));
		getwait().until(ExpectedConditions.visibilityOf(listElement));
		findElement(By.xpath(searchRedXPath)).click();
		
		autoCompleteElement.sendKeys("gr");
		
		WebElement secondListElement = findElement(By.xpath(inputColorListXpath));
		getwait().until(ExpectedConditions.visibilityOf(secondListElement));
		findElement(By.xpath(searchGreenXPath)).click();
	}
	
	public void testDatePicker() {		

		WebElement datePickerElement = findElement(By.xpath(linkDatePickerXPath));
		executeScript(datePickerElement);
		getwait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(linkDatePickerXPath)));
		datePickerElement.click();

		getwait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputDateXpath)));
		WebElement inputDateElement = findElement(By.xpath(inputDateXpath));
		inputDateElement.click();

		findElement(By.xpath(bodyXpath)).sendKeys(Keys.TAB, Keys.ARROW_RIGHT, Keys.ENTER);
	}
}