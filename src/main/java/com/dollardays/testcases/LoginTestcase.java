package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.JsonReader;
import com.dollardays.utilities.TestUtil;
import com.dollardays.utilities.VideoRecorder_utlity;

public class LoginTestcase extends BaseTest
{

	//Login with valid credentials
	@DDDataProvider(datafile = "testdata/wallet.xlsx", sheetName = "TestData2",  testcaseID = "TC12", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void ValidLogin(Hashtable<String, String> datatable) throws Exception
	{
		
		VideoRecorder_utlity.startRecord("GoogleTestRecording");
		System.out.println(datatable.get("Test Case"));
	    ExtentTestManager.getTest().log(Status.INFO, "Test Case: " +(datatable.get("TCID")) + "------" +(datatable.get("Test Case"))); 
	    LoginPage loginPage = new LoginPage(driver); 
	    loginPage.login(datatable.get("UserName"),Base64.decrypt(datatable.get("Password")));
	    ExtentTestManager.getTest().log(Status.PASS,"Step 1: Successfully Logged in with valid Credentials"); 
	    Thread.sleep(1000);
	    loginPage.getUserDrodown().click();
	    ExtentTestManager.getTest().log(Status.PASS,"Step 2: User clicked Sigin Toggle after signing in");
	    Thread.sleep(1000);
	    loginPage.getLogoutBtn().click();
	    ExtentTestManager.getTest().log(Status.PASS, "Step 3: User clicked on LogOut");
	    VideoRecorder_utlity.stopRecord();
	}   
	
	 //login with Invalid password  
	@DDDataProvider(datafile = "testdata/wallet.xlsx", sheetName = "TestData2",  testcaseID = "TC13", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void InvalidPassword(Hashtable<String, String> datatable) throws Exception
	{
		System.out.println(datatable.get("Test Case"));
	    ExtentTestManager.getTest().log(Status.INFO, "Test Case: " +(datatable.get("TCID")) + "------" +(datatable.get("Test Case"))); 
	    LoginPage loginPage=new LoginPage(driver);
	    ExtentTestManager.getTest().log(Status.INFO, "Step 1: User entered valid username with wrong password.");
	    loginPage.login(datatable.get("UserName"),Base64.decrypt(datatable.get("Password")));
	      try
	       {
	        
	 		Assert.assertEquals(loginPage.returnerrormsg().getText().trim(),"Some corrections are necessary…\n" + 
		        		" Incorrect login and password combination.".trim());
	 		ExtentTestManager.getTest().log(Status.PASS, " Step 2: User is not able to log in with incorrect password.");
	        }
	      catch (AssertionError e)
	        {
	 		 ExtentTestManager.getTest().log(Status.FAIL, " Actual and expected messages mismatch");
	 		 ExtentTestManager.getTest().log(Status.FAIL, "Error message: " + e.getMessage());
	         ExtentTestManager.getTest().log(Status.FAIL, "Step 3: User is not able to login with wrong password but there is a mismatch between actual and  expected error message.");
	         Assert.assertEquals("Test Failed", e.getMessage()); 
	        }	
	}
		
	
	//login with invalid username
	@DDDataProvider(datafile = "testdata/wallet.xlsx", sheetName = "TestData2",  testcaseID = "TC14", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void InvalidUsername(Hashtable<String, String> datatable) throws Exception
    {
	    System.out.println(datatable.get("Test Case"));
        ExtentTestManager.getTest().log(Status.INFO, "Test Case: " +(datatable.get("TCID")) + "------" +(datatable.get("Test Case"))); 
        LoginPage loginPage=new LoginPage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Step 1: User entered wrong User Name.");
        loginPage.login(datatable.get("UserName"),Base64.decrypt(datatable.get("Password")));
        try 
 		{
 			Assert.assertEquals(loginPage.returnerrormsg().getText().trim(),"Some corrections are necessary…\n" + 
	        		" Incorrect login and password combination.".trim());
 			ExtentTestManager.getTest().log(Status.PASS, " Step 2: Actual and expected error messages match on click of SignIn Button.");
 		} 
 		catch (AssertionError e) 
 		{
 			ExtentTestManager.getTest().log(Status.FAIL, " Actual and expected messages mismatch");
 			ExtentTestManager.getTest().log(Status.FAIL, "Error message: " + e.getMessage());
            ExtentTestManager.getTest().log(Status.FAIL, "Step 3: User is not able to login with wrong username but there is a mismatch between actual and  expected error message.");
            Assert.assertEquals("Test Failed", e.getMessage());
 		}

	}
}
   


 

  
  



