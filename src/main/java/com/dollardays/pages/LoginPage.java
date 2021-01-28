package com.dollardays.pages;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dollardays.commons.Base64;

public class LoginPage 
{

	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Sign in user dropdown before logging in
	@FindBy(xpath = "//a[normalize-space(.)='Sign in']")
	private WebElement signIn;

	public WebElement getSignIn() 
	{
		return signIn;
	}
	
	//Sign In link from dropdown before logging in
	@FindBy(xpath = "//a[normalize-space(.)='Sign In']")
	private WebElement dropdownsignIn;

	public WebElement getDropdownsignIn() {
		return dropdownsignIn;
	}

	@FindBy(xpath = "//*[@id='inputLoginUsername']")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

	@FindBy(xpath = "//*[@id='inputLoginPassword']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	//@FindBy(xpath = "//button[normalize-space(.)='Sign in']")
	@FindBy(xpath = "//button[@type = 'submit' and @class = 'btn']")     //xpath created by Shikha
	private WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//After user logs into the account
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/a/span")
	
	private WebElement userDrodown;

	public WebElement getUserDrodown() 
	{
		return userDrodown;
	}	
	
	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")  //xpath created by Shikha 
	private WebElement logoutBtn;

	public WebElement getLogoutBtn() 
	{
		return logoutBtn;
	}	
	  
	
	//added by Shikha
	public WebElement returnerrormsg()
	{
		WebElement errmsg = driver.findElement(By.xpath("//div[@class = 'well well-dd well-dd-tertiary well-dd-shadow']"));
	    return errmsg;
	}
	
	//added by Shikha
	
	public WebElement toastpopup()
	
	{
		WebElement toastpopup = driver.findElement(By.id("toast_id"));
		return toastpopup;
	}
	
	

	public void login(String username, String password) throws InterruptedException {
		Thread.sleep(1000);
		getSignIn().click();
		getDropdownsignIn().click();
		Thread.sleep(1000);
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		Thread.sleep(500);
	//	getPassword().submit();
		getLoginBtn().click();
		
	}
	
	

}
