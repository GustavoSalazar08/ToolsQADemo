package com.project.pom;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class Tools_QATest{
  
	private WebDriver driver;
	BookStoreTest bookstore;
	AlertsFramesWindowsTest AlertsFramesWindows;
	FormsTest Forms;
	ElementsTest Elements;
	WidgetsTest Widgets;
	
  @BeforeSuite
  public void beforeSuite() {	  
//	  System.setProperty("webdriver.chrome.driver", "..\\..\\..\\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  driver = new ChromeDriver();
	  bookstore = new BookStoreTest(driver);
	  AlertsFramesWindows = new AlertsFramesWindowsTest(driver);
	  Forms = new FormsTest(driver);
	  Elements = new ElementsTest(driver);
	  Widgets = new WidgetsTest(driver);
	  bookstore.visit("https://demoqa.com/");
	  driver.manage().window().maximize();
  }
	
  @Test (priority = 25)
  public void testBookStore() throws Exception {
	  //bookstore.RegisterTest();
	  bookstore.LoginTest();
	  bookstore.AddBooksTest();
	  bookstore.deleteBooksTest();
	  bookstore.LogoutTest();
	  //bookstore.DeleteAccountTest();
  }
  
  @Test (priority = 20)
  public void testWidgets() throws Exception {
	  Widgets.testAccordian();
	  Widgets.testAutoComplete();
	  Widgets.testDatePicker();	  
  }
  
  @Test (priority = 15)
  public void testAlertsFramesWindows() throws Exception {	  
	  AlertsFramesWindows.sectionModalItemList();
	  AlertsFramesWindows.modalViewDisplay();
	  AlertsFramesWindows.modalClassType();
	  AlertsFramesWindows.framesSection();
	  AlertsFramesWindows.frameSectionIframe();
  }
  
  @Test (priority = 10)
  public void testForms() throws Exception {
	  Forms.practice_form_page();
	  Forms.required_fields();
	  Forms.submit_form();
  }
  
  @Test (priority = 5)
  public void testElements() throws Exception {
	  Elements.TextBox();
	  Elements.RadioButton();
	  Elements.Buttons();
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.get("https://demoqa.com/");  
  }

  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }
}