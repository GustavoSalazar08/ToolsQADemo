package com.project.pom;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BookStoreTest extends Base{
	
	private String username = "gusSal09";
	private String password = "GusSal-09@";
	private String firstName = "Gustavo";
	private String lastName = "Salazar";
	private String usernameXPath = "//input[@type='text' and @id='userName']";
	private String passwordXPath = "//input[@type='password' and @id='password']";
	private String loginButtonXPath = "//button[@id='login' and @type='button']";
	private String popupXPath = "//a[@id='close-fixedban']";
	private String bookStoreMenuXPath = "//h5[text()='Book Store Application']/parent::div[@class='card-body']/parent::div";
	private String newUserXPath = "//button[@id='newUser']";
	private String firstNameXPath = "//input[@type='text' and @id='firstname']";
	private String lastNameXPath = "//input[@type='text' and @id='lastname']";
	private String captchaXPath = "//div[@id='g-recaptcha']";
	private String registerButtonXPath ="//button[@id='register']";
	private String loginListXPath = "//span[@class='text' and text()='Login']/parent::li";
	private String bookStoreListXPath = "//span[@class='text' and text()='Book Store']/parent::li";
	private String book1XPath = "//span[@id='see-book-Git Pocket Guide']/descendant::a";
	private String book2XPath = "//span[@id='see-book-Learning JavaScript Design Patterns']/descendant::a";
	private String book3XPath = "//span[@id='see-book-Designing Evolvable Web APIs with ASP.NET']/descendant::a";
	private String addXPath = "//button[@id='addNewRecordButton' and @type='button' and text()='Add To Your Collection']";
	private String backStoreXPath = "//button[@id='addNewRecordButton' and @type='button' and text()='Back To Book Store']";
	private String profileListXPath = "//span[@class='text' and text()='Profile']/parent::li";
	private String tableBooksXPath = "//div[@class='rt-tbody']";
	private String booksDeleteXpaths = "//span[@id='delete-record-undefined']";
	private String confirmDeleteXPath = "//div[@class='modal-body' and text()='Do you want to delete this book?']/parent::div";
	private String confirmDeleteButtonXPath = "//button[@id='closeSmallModal-ok' and @type='button']";
	private String deleteAllBooksXPath = "//div[@class='text-right button di']/button[@id='submit' and @type='button' and text()='Delete All Books']";
	private String confirmDeleteAllXPath = "//div[@class='modal-title h4' and text()='Delete All Books']/parent::div/parent::div";
	private String confirmDeleteAllButtonXPath = "//button[@id='closeSmallModal-ok' and @type='button']";
	private String logoutButtonXPath = "//button[@id='submit' and @type='button' and text()='Log out']";
	private String loginHeaderXPath = "//div[@class='main-header' and text()='Login']";
	private String deleteAccountButtonXPath = "//button[@id='submit' and @type='button' and text()='Delete Account']";
	private String confirmDeleteAccountXPath = "//div[@class='modal-content']";
	private String confirmDeleteAccountButtonXPath = "//button[@id='closeSmallModal-ok' and @type='button']";
	
	public BookStoreTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private void login() throws Exception {
		WebElement popup = findElement(By.xpath(popupXPath));
		if(popup.isDisplayed()) popup.click();		
		until(By.xpath(usernameXPath));
		WebElement usernameInput = findElement(By.xpath(usernameXPath));
		usernameInput.sendKeys(username);
		WebElement passwordInput = findElement(By.xpath(passwordXPath));
		passwordInput.sendKeys(password);
		takeSnapShot(getdriver(), "Screenshots\\Login_1.png") ;
		until(By.xpath(loginButtonXPath));
		WebElement loginFormButton = findElement(By.xpath(loginButtonXPath));
		executeScript(loginFormButton);
		loginFormButton.click();
		takeSnapShot(getdriver(), "Screenshots\\Login_2.png");		
		until(By.xpath("//label[@id='userName-label' and text()='User Name : ']"));
		if(findElement(By.xpath("//label[@id='userName-label' and text()='User Name : ']")).isDisplayed())
			Assert.assertEquals(username, findElement(By.xpath("//label[@id='userName-value']")).getText());
	}
	
	public void RegisterTest() throws Exception {				
		WebElement popup = findElement(By.xpath(popupXPath));
		if(popup.isDisplayed()) popup.click();		
		WebElement bookStoreMenu = findElement(By.xpath(bookStoreMenuXPath));
		bookStoreMenu.click();		
		until(By.xpath(loginButtonXPath));
		WebElement loginButton = findElement(By.xpath(loginButtonXPath));
		loginButton.click();		
		until(By.xpath(newUserXPath));
		WebElement newUserButton = findElement(By.xpath(newUserXPath));
		newUserButton.click();		
		takeSnapShot(getdriver(), "Screenshots\\Register_1.png") ;
		until(By.xpath(firstNameXPath));
		WebElement firstNameInput = findElement(By.xpath(firstNameXPath));
		firstNameInput.sendKeys(firstName);
		WebElement lastNameInput = findElement(By.xpath(lastNameXPath));
		lastNameInput.sendKeys(lastName);
		WebElement usernameInput = findElement(By.xpath(usernameXPath));
		usernameInput.sendKeys(username);
		WebElement passwordInput = findElement(By.xpath(passwordXPath));
		passwordInput.sendKeys(password);
		WebElement captcha = findElement(By.xpath(captchaXPath));
		captcha.click();
		takeSnapShot(getdriver(), "Screenshots\\Register_2.png") ;
		WebElement registerButton = findElement(By.xpath(registerButtonXPath));
		registerButton.click();
		getwait().until(ExpectedConditions.alertIsPresent());
		getdriver().switchTo().alert().accept();
		takeSnapShot(getdriver(), "Screenshots\\Register_3.png") ;
	}
	
	public void LoginTest() throws Exception {	
		WebElement popup = findElement(By.xpath(popupXPath));
		if(popup.isDisplayed()) popup.click();	
		WebElement loginButton;		
		WebElement bookStoreMenu = findElement(By.xpath(bookStoreMenuXPath));
		executeScript(findElement(By.xpath(bookStoreMenuXPath)));
		bookStoreMenu.click();
		//getwait().until(ExpectedConditions.elementToBeClickable(By.tagName("img")));
		getwait().until(ExpectedConditions.or(
				ExpectedConditions.elementToBeClickable(By.xpath(loginButtonXPath)),
				ExpectedConditions.elementToBeClickable(By.xpath(loginListXPath))));
		if(!findElements(By.xpath(loginButtonXPath)).isEmpty()) {			
			executeScript(findElement(By.xpath("//img")));
			getwait().until(ExpectedConditions.elementToBeClickable(By.xpath(loginButtonXPath)));
			loginButton = findElement(By.xpath(loginButtonXPath));
			loginButton.click();
		}
		else if(!findElements(By.xpath(loginListXPath)).isEmpty()) {
			executeScript(findElement(By.xpath(loginListXPath)));
			getwait().until(ExpectedConditions.elementToBeClickable(By.xpath(loginListXPath)));
			loginButton = findElement(By.xpath(loginListXPath));
			//executeScript(loginButton);
			loginButton.click();
		}
		
		login();
	}
	
	public void AddBooksTest() throws Exception {
		WebElement bookStoreList = findElement(By.xpath(bookStoreListXPath));
		executeScript(bookStoreList);
		bookStoreList.click();		
		String booksXpath[] = {book1XPath,book2XPath,book3XPath};		
		for(int i=0; i<2; i++) {
			until(By.xpath(tableBooksXPath));
			if(findElement(By.xpath(tableBooksXPath)).isDisplayed()){
				until(By.xpath(booksXpath[i]));
				WebElement book = findElement(By.xpath(booksXpath[i]));
				executeScript(book);
				book.click();				
				getwait().until(ExpectedConditions.elementToBeClickable(By.xpath(addXPath)));
				WebElement addButton = findElement(By.xpath(addXPath));
				executeScript(addButton);
				addButton.click();	
//				getwait().until(ExpectedConditions.alertIsPresent());
//				Thread.sleep(3000);
				Alert alert = null;
				try {
					alert = getwait().until(ExpectedConditions.alertIsPresent());
				}catch(Exception e) { }
				if(alert == null) {
				    System.out.println("alert was not present");
				}
				else {
				    String Recipemessage = alert.getText();
				    System.out.println(Recipemessage);
				    if (Recipemessage.equals("Book added to your collection.") || Recipemessage.equals("Book already present in the your collection!")) {
				    	getwait().until(ExpectedConditions.alertIsPresent());
				    	//Thread.sleep(3000);
				        alert.accept();
				    }
				}
				//getdriver().switchTo().alert().accept();
				takeSnapShot(getdriver(), "Screenshots\\Add_"+i+".png") ;
				getwait().until(ExpectedConditions.elementToBeClickable(By.xpath(addXPath)));
				WebElement backStoreButton = findElement(By.xpath(backStoreXPath));
				backStoreButton.click();
			}
		}
	}
	
	public void deleteBooksTest() throws Exception {
		WebElement popup = findElement(By.xpath(popupXPath));
		if(popup.isDisplayed()) popup.click();		
		WebElement profileButton = findElement(By.xpath(profileListXPath));
		executeScript(profileButton);
		profileButton.click();		
		until(By.xpath(booksDeleteXpaths));
		ArrayList<WebElement> deleteBooksElements = (ArrayList<WebElement>) findElements(By.xpath(booksDeleteXpaths));
		if(deleteBooksElements.get(0).isDisplayed()){
			if(popup.isDisplayed()) popup.click();
			WebElement book = deleteBooksElements.get(0);
			executeScript(book);
			book.click();
			until(By.xpath(confirmDeleteXPath));
			if(findElement(By.xpath(confirmDeleteXPath)).isDisplayed()) {
				WebElement confirmDeleteButton = findElement(By.xpath(confirmDeleteButtonXPath));
				confirmDeleteButton.click();
				getwait().until(ExpectedConditions.alertIsPresent());
//				Thread.sleep(3000);
				Alert alert = null;
				alert = getwait().until(ExpectedConditions.alertIsPresent());
				if(alert == null) {
				    System.out.println("alert was not present");
				}
				else {
				    String Recipemessage = alert.getText();
				    System.out.println(Recipemessage);
				    if (Recipemessage.equals("Book deleted.") || Recipemessage.equals("All Books deleted.")) {
				    	getwait().until(ExpectedConditions.alertIsPresent());
//				    	Thread.sleep(3000);
				        alert.accept();
				    }
				}

			}
		}
		
		WebElement deleteAllBooksButton = findElement(By.xpath(deleteAllBooksXPath));
		deleteAllBooksButton.click();
		until(By.xpath(confirmDeleteAllXPath));
		if(findElement(By.xpath(confirmDeleteAllXPath)).isDisplayed()) {
			WebElement confirmDeleteAllButton = findElement(By.xpath(confirmDeleteAllButtonXPath));
			executeScript(confirmDeleteAllButton);
			confirmDeleteAllButton.click();
			getwait().until(ExpectedConditions.alertIsPresent());
			getdriver().switchTo().alert().accept();
			takeSnapShot(getdriver(), "Screenshots\\Delete_2.png") ;
		}
	}
	
	public void LogoutTest() throws Exception {
		WebElement popup = findElement(By.xpath(popupXPath));
		if(popup.isDisplayed()) popup.click();		
		WebElement logoutButton = findElement(By.xpath(logoutButtonXPath));
		executeScript(logoutButton);
		logoutButton.click();
		takeSnapShot(getdriver(), "Screenshots\\Delete_Account_1.png") ;		
		Assert.assertEquals(findElement(By.xpath(loginHeaderXPath)).getText(), "Login");
	}
	
	public void DeleteAccountTest() throws Exception {
		login();		
		WebElement popup = findElement(By.xpath(popupXPath));
		if(popup.isDisplayed()) popup.click();		
		WebElement deleteAccountButton = findElement(By.xpath(deleteAccountButtonXPath));
		executeScript(deleteAccountButton);
		deleteAccountButton.click();
		takeSnapShot(getdriver(), "Screenshots\\Logout.png") ;		
		until(By.xpath(confirmDeleteAccountXPath));
		if(findElement(By.xpath(confirmDeleteAccountXPath)).isDisplayed()) {
			WebElement confirmDeleteAccountButton = findElement(By.xpath(confirmDeleteAccountButtonXPath));
			confirmDeleteAccountButton.click();
			getwait().until(ExpectedConditions.alertIsPresent());
			getdriver().switchTo().alert().accept();
			takeSnapShot(getdriver(), "Screenshots\\Delete_Account_2.png") ;
		}
		
		Assert.assertEquals(findElement(By.xpath(loginHeaderXPath)).getText(), "Login");
	}
}