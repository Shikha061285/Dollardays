package com.dollardays.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyWallet 
{
	WebDriver driver;

	public MyWallet(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	    // locating Signin user dropdown after logging in
        @FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/a/span")
		private WebElement Userdrpdown;
        public WebElement getUserdrpdown() 
		{
			return Userdrpdown;
		}
        
        //locating Wallet option from the dropdown
        @FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/ul/li[8]/a")
        private WebElement walletoption;
        public WebElement getwallet()
        {
        	return walletoption;
        }
        
        //locating ADD NEW CARD option
        @FindBy(xpath = "//div[@class = 'address-box rbtnAddNewCard']")
        private WebElement addnewcard;
        public WebElement getnewcard()
        {
        	return addnewcard;
        }
        
        //locating name on card 
        @FindBy(xpath = "//input[@id='ctl00_cphContent_txtCCHolder']")
        private WebElement nameoncard;
        public WebElement getname()
        {
        	return nameoncard;
        }
        
        //locating card number
        @FindBy(xpath = "//input[@id='ctl00_cphContent_txtCCNumber']")
        private WebElement cardnum;
        public  WebElement getcardno()
        {
        	return cardnum;
        }
        
        //locating expiration month
        
        @FindBy(xpath = "//select[@id='ctl00_cphContent_ddlCCExpireMnth' and @class='form-control wallet-CCExpireMnth validatecheckouterror']")
        private WebElement expmonth;
		public WebElement getexpmonth() 
		{ 
			return expmonth; 
		}
		 
		 //locating expiration year
        @FindBy(xpath = "//select[@id='ctl00_cphContent_ddlCCExpireYear' and @class='form-control wallet-CCExpireYear validatecheckouterror']")
        private WebElement expyear;
        public WebElement getexpyear()
        {
        	return expyear;
        }
        
        //locating security code
        @FindBy(xpath = "//input[@id='ctl00_cphContent_txtCCCVV2ID']")
        private WebElement securitycode;
        public WebElement getsec_code()
        {
        	return securitycode;
        }
        
        //locating street address
        @FindBy(xpath = "//input[@id='ctl00_cphContent_txtAddrBillingaddr1']")
        private WebElement streetadd;
        public WebElement getstreetadd()
        {
        	return streetadd;
        }
        
        //locating city
        @FindBy(xpath = "//input[@id='ctl00_cphContent_txtAddrBillingcity']")
        private WebElement city;
        public WebElement getcity()
        {
        	return city;
        }
        
        //locating state
        @FindBy(xpath = "//select[@id='ctl00_cphContent_ddlBillingstate']")
        private WebElement state;
        public WebElement getstate()
        {
        	return state;
        }
        
        //locating zip code
        @FindBy(xpath = "//input[@id='txtAddrBillingzip']")
        private WebElement zipcode;
        public WebElement getzipcode()
        {
        	return zipcode;
        }
        
        //locating ADD NEW CARD Button
        @FindBy(xpath = "//input[@id='ctl00_cphContent_btnUpdateCard']")
        private WebElement addcardbutton;
        public WebElement getaddcardbtn()
        {
        	return addcardbutton;
        }
        
        //locating SignOut Button
        @FindBy(xpath = "//a[@href='/logout.aspx'][@class='dropdown-item padditem margn-top']")
        private WebElement signoutbtn;
        public WebElement clicksignout()
        {
        	return signoutbtn;
        }
        
        //locating small pop up
        @FindBy(xpath = "//input[@class = 'iagree btn']")
        private WebElement popup;
        public WebElement popupclose()
        {
        	return popup;
        }
        
        //locating Cancel button on add new card page
        @FindBy(xpath = "//input[@class = 'btn btnCancel']")
        private WebElement cancel;
        public WebElement cancelbtn()
        {
        	return cancel;
        }
        
        
       public String geterrormsg()
        {
        	String error = ""; 
        	String allErrMsgs = ""; 
        	List<WebElement> errormsg =driver.findElements(By.xpath("//span[@class = 'checkouterror']"));
   		   // System.out.println("***** "+errormsg.size()); 
   		    int i =0; 
   		    for (WebElement webElement : errormsg) 
   		    { 
   		    	error = webElement.getText(); 
   		    	allErrMsgs+=error; 
   		    	allErrMsgs +="\n";
   		    	if(webElement.getText().equals("")) 
   		    	{ 
   		    		continue;
   		    	}
   		        else 
   		        { 
   		    	i++; 
   		        } 
   		    }
   		 
   		 return allErrMsgs;
   		    }
        
       
        public WebElement SucessMsg()
    	{
    		WebElement SucessMsg = driver.findElement(By.xpath("//div[contains(text(), 'Card is added to wallet.')]"));
    		return SucessMsg;
    	}
        
    
        @FindBy(xpath = "//a[@class='defaultcode']")
        private WebElement setasdefault;
        public WebElement SetAsDefault()
        {
        	return setasdefault;
        }
        
        @FindBy(xpath ="//*[contains(@class,'address-box default_address')]")
		private WebElement DefaultCard;
        public boolean DefaultCard()
		   {
			   DefaultCard.isDisplayed();
			   return DefaultCard != null;
		   }
        
        @FindBy(xpath = "//*[text()=' Delete']")	
		private WebElement DeleteExistingCard;
        public WebElement DeleteExistingcard()
		   {
			   return DeleteExistingCard;
		   }
        
        
        @FindBy(xpath = "//button[@class='btn btn-primary confirmDeleteAddr']")
		private WebElement YesConfirmationOnDelete;
        public WebElement YesConfirmationOnDelete()
		   {
			   return YesConfirmationOnDelete;
		   }
        
        @FindBy(xpath = "//button[@class='btn btn-secondary closeolap']")
		private WebElement NoConfirmationOnDelete;
        public WebElement NoConfirmationOnDelete()
		   {
			   return NoConfirmationOnDelete;
		   }
     
        @FindBy(xpath = "//button[@class= 'close closeolap']")
		private WebElement CloseConfirmation;
        public WebElement CloseConfirmation()
		   {
			   return CloseConfirmation;
		   }
        
        @FindBy(xpath ="//*[contains(@class,'address-box fixed_address')]")
        private WebElement FixedDefaultCard;
        public void FixedDefaultCard()
		   {
			   FixedDefaultCard.isDisplayed();
		   }
        
        @FindBy(xpath = "//*[text()=' Edit']")
		private WebElement EditExistingcard;
        public void EditExistingCard()
		   {
			   EditExistingcard.click();
		   }
        
        
}
