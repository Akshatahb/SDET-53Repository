package gener;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	//create object for utility classes
	public  WebDriver driver; 
	public static WebDriver sdriver;
	
	public databaseUtils dbLib  = new databaseUtils();
	public ExcelUtils eLib      = new ExcelUtils();
	public FileUtils fLib       = new FileUtils(); 
	public JavaUtils jLib       = new JavaUtils();
	public WebDriverUtils wLib  = new WebDriverUtils();
	
	  
	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws SQLException
	{
		dbLib.registerConnection();
		Reporter.log("----------connect to database-------------",true);
	}
	
	//@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws IOException
	{   
		//String Browser="edge";
		String Browser =fLib.readData("browser");
		if(Browser.equalsIgnoreCase("chrome"))
	     {  
		driver =new ChromeDriver(); 
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
	}else if(Browser.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();
}
		else
		{
			System.out.println("======invalid browser name=====");
		}
		
		sdriver=driver;
		
		
		String Url = fLib.readData("url");
		wLib.maximizeWindow(driver);			
		wLib.implicitWait(driver, 20);
		driver.get(Url);
		Reporter.log("----------launch browser-------------",true);
		
	}
	
	@AfterClass
	public void config_AM()
	{
		driver.quit();
		Reporter.log("------------close the browser----------",true);	
	}
	
	@AfterSuite(alwaysRun=true)
	public void config_AS() throws SQLException
	{
		dbLib.closeConnection();
		Reporter.log("------------close the connection to database----------------",true);
	}
}
