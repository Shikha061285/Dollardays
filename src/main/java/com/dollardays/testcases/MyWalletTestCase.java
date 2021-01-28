package com.dollardays.testcases;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;

import com.dollardays.pages.LoginPage;
import com.dollardays.pages.MyWallet;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class MyWalletTestCase extends BaseTest
{
	//private static int OUTPUT_ROW_START = 0;
	private JavascriptExecutor je = null;
	// Verify if "My wallet" option is appearing in the user option menu and the information on My Wallet Page displays correctly
	
	@DDDataProvider(datafile = "testdata/wallet.xlsx", sheetName = "TestData1",testcaseID = "TC1", runmode = "Yes")
	  
	  @Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	  public void VerifyWalletDisplay(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException
	  { 
	  System.out.println(datatable.get("Test Case"));
	  ExtentTestManager.getTest().log(Status.PASS, "Test Case: " +(datatable.get("TCID")) + "------" +(datatable.get("Test Case"))); 
	  LoginPage loginPage = new LoginPage(driver); 
	  loginPage.login(datatable.get("UserName"),Base64.decrypt(datatable.get("Password")));
	  ExtentTestManager.getTest().log(Status.PASS,"Step 1: Successfully Logged in with valid Credentials"); 
	  Thread.sleep(1000);
	  MyWallet wallet = new MyWallet(driver); 
	  Thread.sleep(3000);
	  wallet.getUserdrpdown().click(); 
	  ExtentTestManager.getTest().log(Status.PASS,"Step 2: User clicked Sigin Toggle after signing in to verify Wallet option"); 
	  Thread.sleep(3000); 
	  wallet.getwallet().click();
	  ExtentTestManager.getTest().log(Status.PASS,"Step 3: User clicked on My Wallet link"); 
	  Thread.sleep(3000);
	  wallet.getnewcard().click(); 
	  ExtentTestManager.getTest().log(Status.PASS,"Step 4: User clicked on ADD NEW CARD link and verifies the title and attributes of the page"); 
	  String expectedTitle = "Wallet - DollarDays"; 
	  String actualTitle = driver.getTitle(); Assert.assertEquals(actualTitle, expectedTitle,"Successfully Navigated to Add New Card Page");
	  wallet.getname().isDisplayed(); wallet.getcardno().isDisplayed();
	  wallet.getexpmonth().isDisplayed(); wallet.getexpyear().isDisplayed();
	  wallet.getsec_code().isDisplayed(); wallet.getstreetadd().isDisplayed();
	  wallet.getcity().isDisplayed(); wallet.getstate().isDisplayed();
	  wallet.getzipcode().isDisplayed(); wallet.getaddcardbtn().isDisplayed();
	  wallet.cancelbtn().isDisplayed(); ExtentTestManager.getTest().log(Status.PASS,"Step 5: User verified all the displayed fields"); 
	  Thread.sleep(3000);
	  je = (JavascriptExecutor) driver;
	  je.executeScript("window.scrollBy(0,1000)"); 
	  wallet.popupclose().click();
	  Thread.sleep(3000); wallet.getUserdrpdown().click();
	  ExtentTestManager.getTest().log(Status.PASS,"Step 6: User again clicked User Sigin Toggle"); 
	  Thread.sleep(3000);
	  wallet.clicksignout().click(); 
	  ExtentTestManager.getTest().log(Status.PASS,"Step 7: User clicked Sigout Toggle after verifying Wallet screen display");
	  }
	 

	// Validating the data entered from excel sheet

	
	 @DDDataProvider(datafile = "testdata/wallet.xlsx", sheetName ="TestData1",testcaseID = "TC5", runmode = "Yes")
	  
	  @Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	  public void ValidateMyWallet(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException
	  { 
		System.out.println(datatable.get("Test Case"));
	    ExtentTestManager.getTest().log(Status.PASS, "Test Case: " +(datatable.get("TCID")) + "------" +(datatable.get("Test Case"))); LoginPage
	    loginPage = new LoginPage(driver);
	    loginPage.login(datatable.get("UserName"),Base64.decrypt(datatable.get("Password"))); ExtentTestManager.getTest().log(Status.PASS,"Step 1: Successfully Logged in with valid Credentials");
        Thread.sleep(1000); 
        MyWallet wallet = new MyWallet(driver);
	    Thread.sleep(3000); 
	    wallet.getUserdrpdown().click();
	    ExtentTestManager.getTest().log(Status.PASS,"Step 2: User clicked Sigin Toggle after signing in");
	    Thread.sleep(3000); 
	    wallet.getwallet().click();
	    ExtentTestManager.getTest().log(Status.PASS,"Step 3: User clicked on My Wallet link"); 
	    Thread.sleep(3000);
	    wallet.getnewcard().click(); ExtentTestManager.getTest().log(Status.PASS,"Step 4: User clicked on ADD NEW CARD link"); 
	    Thread.sleep(3000); 
	    //get Name on Card from excel sheet 
	    if ((datatable.get("Name on card") != null && !(datatable.get("Name on card").equals("")))) 
	    {
	     wallet.getname().sendKeys((datatable.get("Name on card")));
	     ExtentTestManager.getTest().log(Status.INFO,"Step 5: User entered Name on card: " + "Name on card"+datatable.get("Name on card")); 
	    }
	    Thread.sleep(1000); 
	    //get card no form excel sheet 
	    if((datatable.get("Card Number") != null && !(datatable.get("Card Number").equals("")))) 
	    {
	    wallet.getcardno().sendKeys((datatable.get("Card Number")));
	    ExtentTestManager.getTest().log(Status.INFO,"Step 6:User entered Card Number: " + "Card Number" +datatable.get("Card Number")); 
	    } 
	    Thread.sleep(1000); 
	    //get expiration month from excel sheet 
	    if ((datatable.get("Expiration Month") != null && !(datatable.get("Expiration Month").equals("")))) 
	    {
	    wallet.getexpmonth().sendKeys((datatable.get("Expiration Month")));
	    ExtentTestManager.getTest().log(Status.INFO,"Step 7: User entered Expiration Month: " + "Expiration Month" +datatable.get("Expiration Month")); 
	     } 
	    Thread.sleep(1000); 
	    //get expiration year from excel sheet 
	    if ((datatable.get("Expiration Year") != null && !(datatable.get("Expiration Year").equals("")))) 
	    {
	    wallet.getexpyear().sendKeys((datatable.get("Expiration Year")));
	    ExtentTestManager.getTest().log(Status.INFO,"Step 8: User entered Expiration Year: " + "Expiration Year" +datatable.get("Expiration Year")); 
	    } 
	    Thread.sleep(1000); 
	    //get security code form excel sheet 
	    if ((datatable.get("Security Code") != null && !(datatable.get("Security Code").equals("")))) 
	    {
	    wallet.getsec_code().sendKeys((datatable.get("Security Code")));
	    ExtentTestManager.getTest().log(Status.INFO,"Step 9: User entered Security Code: " + "Security Code"+datatable.get("Security Code"));
	    } 
	    Thread.sleep(1000); 
	    //get street address from excel sheet 
	    if ((datatable.get("Street Address") != null && !(datatable.get("Street Address").equals("")))) 
	    {
	    wallet.getstreetadd().sendKeys((datatable.get("Street Address")));
	    ExtentTestManager.getTest().log(Status.INFO,"Step 10: User entered Street Address: " + "Street Address"+datatable.get("Street Address"));
	    } 
	    Thread.sleep(1000); 
	    //get city from  excel sheet 
	    if ((datatable.get("City") != null && !(datatable.get("City").equals("")))) 
	    {
	    wallet.getcity().sendKeys((datatable.get("City")));
	    ExtentTestManager.getTest().log(Status.INFO, "Step 11: User entered City: "+"City" + datatable.get("City")); 
	    } 
	    Thread.sleep(1000); 
	    //get State from excel sheet 
	    if ((datatable.get("Billing State") != null && !(datatable.get("Billing State").equals("")))) 
	    {
	    wallet.getstate().sendKeys((datatable.get("Billing State")));
	    ExtentTestManager.getTest().log(Status.INFO,"Step 12: User entered Billing State: " + "Billing State" +datatable.get("Billing State")); 
	    } 
	    Thread.sleep(1000); 
	    //get Zip code from excel sheet 
	    if ((datatable.get("Zip Code") != null && !(datatable.get("Zip Code").equals("")))) 
	    {
	    wallet.getzipcode().sendKeys((datatable.get("Zip Code")));
	    ExtentTestManager.getTest().log(Status.INFO,"Step 13: User entered Zip Code: " + "Zip Code" +datatable.get("Zip Code")); 
	    } 
	    Thread.sleep(1000); 
	    //clicks on ADD NEW CARD Button 
	    wallet.getaddcardbtn().click();
	    ExtentTestManager.getTest().log(Status.PASS,"Step 14: User clicked Add New Card button after entering values.");
	  
	   String actualTxt = "";
	  
	  if ((datatable.get("TestScenario").equals("Negative"))) 
	  {
	   actualTxt = wallet.geterrormsg();
       //wallet.cancelbtn().click();
	   ExtentTestManager.getTest().log(Status.PASS, "User gets error message."); 
	  }
	  else 
	  { 
		  Thread.sleep(5000); 
		  actualTxt = wallet.SucessMsg().getText();
		  ExtentTestManager.getTest().log(Status.PASS, "User gets success message."); 
	  }
	  //wallet.getaddcardbtn().click();
	  //ExtentTestManager.getTest().log(Status.PASS, "User gets success message."); 
	  
	  
	  
	  String expectedText = ""; 
	  // appending expected text based on input. 
	  if("".equals((datatable.get("Name on card")))) 
	  {
	  
	  if (!"".equals(expectedText)) 
	  { 
		  expectedText += "\n"; 
	  }
	  
	  expectedText += "Name on Card (Required)"; 
	  } 
	  if("".equals((datatable.get("Card Number")))) 
	  {
	  
	  if (!"".equals(expectedText)) 
	  { expectedText += "\n"; 
	  }
	  
	  expectedText += "Card Number (Required)"; 
	  }
	  
	  if ("".equals((datatable.get("Expiration Month")))) 
	  {
	  
	  if (!"".equals(expectedText)) { expectedText += "\n"; }
	  
	  expectedText += "Expiration Month (Required)"; 
	  }
	  
	  if ("".equals((datatable.get("Expiration Year")))) 
	  {
	  
	  if (!"".equals(expectedText)) 
	  { expectedText += "\n"; }
	  
	  expectedText += "Expiration Year (Required)"; 
	  }
	  
	  if ("".equals(datatable.get("Security Code"))) 
	  {
	  
	  if (!"".equals(expectedText)) 
	  { expectedText += "\n"; }
	  
	  expectedText += "Security Code (Required)";
	  
	  }
	  
	  if ("".equals((datatable.get("Street Address")))) 
	  {
	  
	  if (!"".equals(expectedText)) 
	  { expectedText += "\n"; }
	  
	  expectedText += "Billing Address (Required)"; 
	  }
	  
	  if ("".equals((datatable.get("City")))) 
	  {
	  
	  if (!"".equals(expectedText)) 
	  { expectedText += "\n"; }
	  
	  expectedText += "Billing City (Required)"; 
	  }
	  
	  if ("".equals((datatable.get("Billing State")))) 
	  {
	  
	  if (!"".equals(expectedText)) 
	  { expectedText += "\n"; }
	  
	  expectedText += "Billing State (Required)"; 
	  }
	  
	  if ("".equals((datatable.get("Zip Code")))) 
	  {
	  
	  if (!"".equals(expectedText)) 
	  { expectedText += "\n"; }
	  
	  expectedText += "Billing Zip (Required)"; 
	  }
	  
	  
	  if ((datatable.get("TestScenario").equals("Positive"))) 
	  {
		  expectedText ="Card is added to wallet.";
	  
	  }
	  
	  
	  try {
	  
	  
	  Assert.assertEquals(actualTxt.trim(), expectedText.trim());
	  ExtentTestManager.getTest().log(Status.PASS, " Actual and expected messages match");
	  } catch (AssertionError e) 
	  {
	  ExtentTestManager.getTest().log(Status.FAIL," Actual and expected messages mismatch");
	  ExtentTestManager.getTest().log(Status.INFO, "Actual text:" + actualTxt);
	  ExtentTestManager.getTest().log(Status.INFO, "Expected text:" +expectedText); ExtentTestManager.getTest().log(Status.FAIL, "Error message: "+ e.getMessage()); Assert.assertEquals("Test Failed", e.getMessage());
	  }
	  
	  
	 // OUTPUT_ROW_START++; 
	  loginPage.getUserDrodown().click(); Thread.sleep(1000);
	  loginPage.getLogoutBtn().click();
	  ExtentTestManager.getTest().log(Status.PASS, "Clicked on LogOut"); 
	  }

   @DDDataProvider(datafile = "testdata/wallet.xlsx", sheetName = "TestData2", testcaseID = "TC9", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void VerifySetDefaultCard(Hashtable<String, String> datatable) throws IOException, InterruptedException, GeneralSecurityException 
	{
		System.out.println(datatable.get("Test Case"));
		ExtentTestManager.getTest().log(Status.INFO, "Test Case: " + (datatable.get("TCID"))+ "-----"+(datatable.get("Test Case")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);
		MyWallet wallet = new MyWallet(driver);
		wallet.getUserdrpdown().click();
		Thread.sleep(2000);
		wallet.getwallet().click();
		Thread.sleep(2000);	
		            String NotSetDefault = "//*[contains(@class,'address-box default_address')]";
		            boolean iselementpresent =driver.findElements(By.xpath(NotSetDefault)).size()!= 0;
				
				
				   if (iselementpresent == true)
				   {
					   
					   List<WebElement> cards = driver.findElements(By.xpath("//*[@class='address-box default_address']"));
					   WebElement cardTextHolder = null;
					   WebElement setAsDefaultLink = null;
					   WebElement defaultCard = null;
					   String currentCardNo = null;
					   String cardNo = datatable.get("Name on card");
					   ExtentTestManager.getTest().log(Status.INFO, "Step 2: Reading Name On card from excel");
					   Boolean cardFound = false;
					   if(cards.size() != 0)
					   {
					   for(WebElement card : cards)
					   {
					   cardTextHolder = card.findElement(By.tagName("p"));
					   currentCardNo = cardTextHolder.getText();
					   System.out.println(cardTextHolder.getSize());
					   System.out.println(currentCardNo);
					   if(currentCardNo.trim().equalsIgnoreCase(cardNo))
					   {
					   System.out.println("Card No Found" + currentCardNo);
					   setAsDefaultLink = card.findElement(By.xpath(".//a[text()=' Set as default']"));
					   Thread.sleep(1000);
					   setAsDefaultLink.click();
					   Thread.sleep(1000);
					   defaultCard = driver.findElement(By.xpath("//*[@class='address-box fixed_address']"));
					   if(defaultCard.findElement(By.tagName("p")).getText().trim().equalsIgnoreCase(cardNo))
					   ExtentTestManager.getTest().log(Status.PASS, "Step 3: Selected Card has been Set as default");
					   cardFound = true;
					   break;
					   }

					   }
					   if(!cardFound)
					   ExtentTestManager.getTest().log(Status.PASS, "Step 3: Selected Card is not found.It is already Set As Default or has not been added");
                       }
				   }
					   Thread.sleep(2000);
						wallet.getUserdrpdown().click();
						Thread.sleep(1000);
						loginPage.getLogoutBtn().click();
						ExtentTestManager.getTest().log(Status.PASS, "Step 4: Clicked on LogOut");
					}

	 @DDDataProvider(datafile = "testdata/wallet.xlsx", sheetName = "Testdata2", testcaseID = "TC11", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void VerifyDeleteCard(Hashtable<String, String> datatable) throws InterruptedException, IOException, GeneralSecurityException 
	{
		System.out.println(datatable.get("Test Case"));
		ExtentTestManager.getTest().log(Status.PASS, "Test Case: " + (datatable.get("TCID"))+ "-----"+(datatable.get("Test Case")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);
		
		MyWallet wallet = new MyWallet(driver);
		
		wallet.getUserdrpdown().click();
		Thread.sleep(2000);
		wallet.getwallet().click();
		Thread.sleep(2000);	
		
		String NotSetDefault = "//*[contains(@class,'address-box default_address')]";
		String SetDefault = "//div[contains(@class,'address-box fixed_address')]";
		
        boolean iselementpresent1 =driver.findElements(By.xpath(NotSetDefault)).size()!= 0;
        boolean iselementpresent2 =driver.findElements(By.xpath(SetDefault)).size()!= 0;
        
		if (iselementpresent1 == true)
		   {
			   
			   List<WebElement> cards = driver.findElements(By.xpath("//*[@class='address-box default_address']"));
			   WebElement cardTextHolder = null;
			   WebElement setAsDelete = null;
			   WebElement DelYes  = null;
			   WebElement DelNo = null;
			   WebElement defaultCard = null;
			   String currentCardNo = null;
			   String cardNo = datatable.get("Name on card");
			  // ExtentTestManager.getTest().log(Status.INFO, "Step 2: Reading Name On card from excel");
			   Boolean cardFound = false;
			   if(cards.size() != 0)
			   {
			   for(WebElement card : cards)
			   {
			   cardTextHolder = card.findElement(By.tagName("p"));
			   currentCardNo = cardTextHolder.getText();
			   System.out.println(cardTextHolder.getSize());
			   System.out.println(currentCardNo);
			   if(currentCardNo.trim().equalsIgnoreCase(cardNo))
			   {
			   System.out.println("Card No Found" + currentCardNo);
			   ExtentTestManager.getTest().log(Status.INFO, "Step 2: Record to be deleted has been found in Default Address Section");
			   setAsDelete = card.findElement(By.xpath(".//a[text()=' Delete']"));
			   Thread.sleep(1000);
			   setAsDelete.click();
			   Thread.sleep(1000);
			   //if user opts for not deleting the record
			   DelNo = card.findElement(By.xpath("//button[@class='btn btn-secondary closeolap']"));
			   Thread.sleep(1000);
			   DelNo.click();
			   ExtentTestManager.getTest().log(Status.PASS, "Step 3: User entered No as Delete option");
			   //if user opts for deleting the record
			  // DelYes = card.findElement(By.xpath("//button[@class='btn btn-primary confirmDeleteAddr']"));
			   //Thread.sleep(1000);
			  // DelYes.click();
			  // Thread.sleep(1000);
			  // ExtentTestManager.getTest().log(Status.PASS, "Step 3: User entered Yes as Delete option and the card has been deleted");
			  // defaultCard = driver.findElement(By.xpath("//*[@class='address-box fixed_address']"));
			 //  if(defaultCard.findElement(By.tagName("p")).getText().trim().equalsIgnoreCase(cardNo))
			 //  ExtentTestManager.getTest().log(Status.PASS, "Step 3: Record to be deleted has been found in Fixed Address Section");
			   cardFound = true;
			   break;
			   }

			   }
			   if(!cardFound)
			   ExtentTestManager.getTest().log(Status.INFO, "Step 2: Record to be deleted is not found in Default Address section");
            
		   
		if(iselementpresent2 == true)
	    {
	    
	    	List<WebElement> ucards = driver.findElements(By.xpath("//*[@class='address-box fixed_address']"));
			WebElement cardTextHolder2 = null;
			WebElement setAsDelete2 = null;
			WebElement uDelYes  = null;
			WebElement uDelNo = null;
			WebElement defaultCard2 = null;
			WebElement updatecard2 = null;
			String ucurrentCardNo = null;
			String ucardNo = datatable.get("Name on card");
			//ExtentTestManager.getTest().log(Status.INFO, "Step 2: Reading Name On card from excel");
			Boolean cardFound1 = false;
			if(ucards.size() != 0)
			{
			  for(WebElement card : ucards)
			  {
			   cardTextHolder2 = card.findElement(By.tagName("p"));
			   ucurrentCardNo = cardTextHolder2.getText();
			   System.out.println(ucurrentCardNo);
			   if(ucurrentCardNo.trim().equalsIgnoreCase(ucardNo))
			   {
			   System.out.println("Card No Found" + ucurrentCardNo);
			   ExtentTestManager.getTest().log(Status.INFO, "Step 2: Record to be deleted has been found in Fixed Address Section");
			   setAsDelete2 = card.findElement(By.xpath(".//a[text()=' Delete']"));
			   Thread.sleep(1000);                        
			   setAsDelete2.click();
			   //if user opts for not deleting the record
			   uDelNo = card.findElement(By.xpath("//button[@class='btn btn-secondary closeolap']"));
			   Thread.sleep(1000);
			   uDelNo.click();
			   ExtentTestManager.getTest().log(Status.PASS, "Step 3: User entered No as Delete option");
			   //if user opts for deleting the record
			  // uDelYes = card.findElement(By.xpath("//button[@class='btn btn-primary confirmDeleteAddr']"));
			   //Thread.sleep(1000);
			  // uDelYes.click();
			  // Thread.sleep(1000);
			  // ExtentTestManager.getTest().log(Status.PASS, "Step 3: User entered Yes as Delete option and the card has been deleted");
			  cardFound = true;
			   break;
			   }

			   }
			  if(!cardFound)
			  ExtentTestManager.getTest().log(Status.PASS, "Step 3: Record to be deleted is not found in fixed address section.");
			}
		
			
	    }
			   }
		   }
		        Thread.sleep(2000);
				wallet.getUserdrpdown().click();
				Thread.sleep(1000);
				loginPage.getLogoutBtn().click();
				ExtentTestManager.getTest().log(Status.PASS, "Step 4: Clicked on LogOut");
			}


		
		
	@DDDataProvider(datafile = "testdata/wallet.xlsx", sheetName = "TestData2", testcaseID = "TC10", runmode = "Yes")
	@Test(priority =2,dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void VerifyEditOnCard(Hashtable<String, String> datatable) throws InterruptedException, IOException, GeneralSecurityException
		{
			System.out.println(datatable.get("Test Case"));
			ExtentTestManager.getTest().log(Status.PASS, "Test Case: " + (datatable.get("TCID"))+ "-----"+(datatable.get("Test Case")));
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
			Thread.sleep(1000);
			
			MyWallet wallet = new MyWallet(driver);
			wallet.getUserdrpdown().click();
			Thread.sleep(2000);
			wallet.getwallet().click();
			Thread.sleep(2000);
			
			String NotSetDefault = "//*[contains(@class,'address-box default_address')]";
			String SetDefault = "//div[contains(@class,'address-box fixed_address')]";
			
			boolean iselementpresent1 =driver.findElements(By.xpath(NotSetDefault)).size()!= 0;
		    boolean iselementpresent2 =driver.findElements(By.xpath(SetDefault)).size()!= 0;
		
		
             if (iselementpresent1 == true)
		     {
			   
			   List<WebElement> cards = driver.findElements(By.xpath("//*[@class='address-box default_address']"));
			   WebElement cardTextHolder = null;
			   WebElement editLink = null;
			   WebElement defaultCard = null;
			   WebElement updatecard = null;
			   String currentCardNo = null;
			   String cardNo = datatable.get("Name on card");
			   Boolean cardFound = false;
			   if(cards.size() != 0)
			   {
			   for(WebElement card : cards)
			   {
			   cardTextHolder = card.findElement(By.tagName("p"));
			   currentCardNo = cardTextHolder.getText();
			   System.out.println(currentCardNo);
			   if(currentCardNo.trim().equalsIgnoreCase(cardNo))
			   {
			   System.out.println("Card No Found" + currentCardNo);
			   editLink = card.findElement(By.xpath(".//a[text()=' Edit']"));
			   Thread.sleep(1000);                        
			   editLink.click();
			   Thread.sleep(2000);  
			   wallet.getsec_code().clear();
			   wallet.getsec_code().sendKeys(datatable.get("Security Code"));
			   wallet.getzipcode().clear();
			   wallet.getzipcode().sendKeys(datatable.get("Zip Code"));
			   Thread.sleep(2000);  
			   updatecard = driver.findElement(By.xpath(".//input[@id='ctl00_cphContent_btnUpdateCard']"));
			   updatecard.click();
			   Thread.sleep(2000);  
			   ExtentTestManager.getTest().log(Status.PASS, "Step 2: Selected Card is updated in default address section.");
			   Thread.sleep(1000);
			   cardFound = true;
			   break;
			   }

			   }
			   if(!cardFound)
			   ExtentTestManager.getTest().log(Status.INFO, "Step 2: Card to be updated is not found in default address section.");
               
			    if(iselementpresent2 == true)
			    {
			    
			    	List<WebElement> ucards = driver.findElements(By.xpath("//*[@class='address-box fixed_address']"));
					WebElement cardTextHolder2 = null;
					WebElement editLink2 = null;
					WebElement defaultCard2 = null;
					WebElement updatecard2 = null;
					String ucurrentCardNo = null;
					String ucardNo = datatable.get("Name on card");
					//ExtentTestManager.getTest().log(Status.INFO, "Step 2: Reading Name On card from excel");
					Boolean cardFound1 = false;
					if(ucards.size() != 0)
					{
					  for(WebElement card : ucards)
					  {
					   cardTextHolder2 = card.findElement(By.tagName("p"));
					   ucurrentCardNo = cardTextHolder2.getText();
					   System.out.println(ucurrentCardNo);
					   if(ucurrentCardNo.trim().equalsIgnoreCase(ucardNo))
					   {
					   System.out.println("Card No Found" + ucurrentCardNo);
					   Thread.sleep(1000);   
					   editLink2 = card.findElement(By.xpath(".//a[text()=' Edit']"));
					   Thread.sleep(1000);                        
					   editLink2.click();
					   Thread.sleep(2000);   
					   wallet.getsec_code().clear();
					   wallet.getsec_code().sendKeys(datatable.get("Security Code"));
					   Thread.sleep(2000);   
					   wallet.getzipcode().clear();
					   wallet.getzipcode().sendKeys(datatable.get("Zip Code"));
					   Thread.sleep(1000);
					   updatecard2 = driver.findElement(By.xpath(".//input[@id='ctl00_cphContent_btnUpdateCard']"));
					   updatecard2.click();
					   Thread.sleep(1000);   
					   ExtentTestManager.getTest().log(Status.PASS, "Step 2: Selected Card is updated in fixed address section.");
					   Thread.sleep(1000);
					  cardFound = true;
					   break;
					   }

					   }
					  if(!cardFound)
					  ExtentTestManager.getTest().log(Status.INFO, "Step 2: Card to be updated is not found in fixed address section.");
					}
					
			    }
			   
	        }
		     }
                Thread.sleep(2000);
				wallet.getUserdrpdown().click();
				Thread.sleep(1000);
				loginPage.getLogoutBtn().click();
				ExtentTestManager.getTest().log(Status.PASS, "Step 3: Clicked on LogOut");
			}
}
			

