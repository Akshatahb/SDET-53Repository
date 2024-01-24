package POM;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gener.WebDriverUtils;

public class apprPendAccountPage
{
    @FindBy(name="application_no")
    private WebElement applNo;
    
    @FindBy(name="search_application")
    private WebElement searchApp;
    
	@FindBy(name="approve_cust")
    private WebElement appCustBtn;
	
	
    public WebElement getApplNo() {
		return applNo;
	}

	public WebElement getSearchApp() {
		return searchApp;
	}

		public WebElement getAppCustBtn() {
		return appCustBtn;
	}

	public apprPendAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Approve 
	public void approvePendAppl(String name)
	{
		applNo.sendKeys(name);
		searchApp.click();
		appCustBtn.click();
	}
	
	
	public String approvePendApplication(WebDriver driver,String name) throws InterruptedException
	{
		applNo.sendKeys(name);
		searchApp.click();
		appCustBtn.click();
		Thread.sleep(3000);
		String Account_Num="";
		
		WebDriverUtils wLib=new WebDriverUtils();
		Alert a=wLib.alert(driver);
		String text=a.getText();
		System.out.println(text);
		
		
		StringBuilder num1=new StringBuilder();
		
		for(char character : text.toCharArray())
		{
			if(Character.isDigit(character))
			{
				num1.append(character);
			}
		}
		 Account_Num = num1.toString();

		 a.accept();
		
		
		return Account_Num;
	}	
	
}