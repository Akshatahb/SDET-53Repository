  package gener;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
 //1
	public Actions actionClassObject(WebDriver driver) {
		Actions a=new Actions(driver);
		return a; 
	}
	
	public void actionMoveToElement(WebDriver driver, WebElement target) {
		actionClassObject(driver).moveToElement(target).perform();
	}
	/**
	 * this method is used to click the target element
	 * @param driver
	 * @param target
	 */
	public void actionClick(WebDriver driver, WebElement target) {
		actionClassObject(driver).click(target).perform();
	}
	
	public void actionDoubleClick(WebDriver driver) {
		actionClassObject(driver).click().perform();
	}

	 public void maximizeWindow(WebDriver driver)
	 {
		 driver.manage().window().maximize();
	 }
//2	
	 public void minimizeWindow(WebDriver driver)
	 {
		 driver.manage().window().minimize();
	 }
//3     
	 public void waitForPageLoad(WebDriver driver,int sec)
	 {
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	 }
//4	 
	  public void implicitWait(WebDriver driver,int sec)
	  {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	  }
//5	 
	 public void waitUntilEleToBeVisible(WebDriver driver,int sec,WebElement ele)
	 {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		 wait.until(ExpectedConditions.visibilityOf(ele));	 
	 }
//6	 
	 public void alertIsPresent(WebDriver driver,int sec)
	 {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		 wait.until(ExpectedConditions.alertIsPresent());		 
	 }
//7	 
	 public void textToBePresentInElement(WebDriver driver,int sec,WebElement ele,String text)
	 {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		 wait.until(ExpectedConditions.textToBePresentInElement(ele,text));
	 }
//8	 
	 public void waitUntilEleToBeVisible(WebDriver driver,int sec, String text)
	 {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		 wait.until(ExpectedConditions.titleContains(text));
	 }
//9	 
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest);
	}
//10
	public void rightClickOnElement(WebDriver driver, WebElement ele)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
//11	
	public void doubleClickOnElement(WebDriver driver, WebElement ele)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
//12	
	 public void ClickOnElement(WebDriver driver, WebElement ele)
	{
		Actions a=new Actions(driver);
		a.clickAndHold(ele).perform();
	}
//13	 
	 public void ClickOnElement(WebDriver driver)
	{
			Actions a=new Actions(driver);
			a.clickAndHold().perform();
	}
//14	 
	public void Click(WebDriver driver, WebElement ele)
	{
			Actions a=new Actions(driver);
			a.click(ele).perform();
	}
//15	
	public void Click(WebDriver driver)
	{
			Actions a=new Actions(driver);
			a.click().perform();
	}
//16
	public void select(WebElement ele, int num)
	{
		Select s=new Select(ele);	
		s.selectByIndex(num);
	}
//17	
	public void select(WebElement ele, String text)
	{
		Select s=new Select(ele);	
		s.selectByVisibleText(text);
	}
//18
	public void select(String text ,WebElement ele )
	{
		Select s=new Select(ele);	
		s.selectByValue(text);
	}
//19
	public void deselect(WebElement ele, int num)
	{
		Select s=new Select(ele);	
		s.deselectByIndex(num);
	}
//20
	public void deselect(WebElement ele, String text)
	{
		Select s=new Select(ele);	
		s.deselectByVisibleText(text);
	}
//21
	public void deselectByValue( String text, WebElement ele)
	{
		Select s=new Select(ele);	
		s.deselectByValue(text);
	}
//22	
	public void getFirstSelectedOption(WebElement ele)
	{
		Select s=new Select(ele);	
		s.getFirstSelectedOption();
	}
//23
	public void getAllSelectedOptions(WebElement ele)
	{
		Select s=new Select(ele);	
		s.getAllSelectedOptions();
	}
//24
	public void deselect(WebElement ele)
	{
		Select s=new Select(ele);	
		s.deselectAll();
	}
//25
	public void getOptions(WebElement ele)
	{
		Select s=new Select(ele);	
		s.getOptions();
	}
//26 
	public void getWrappedElement(WebElement ele)
	{
		Select s=new Select(ele);	
		s.getWrappedElement();
	}
//27  //Robot class
	public void keyEnterPress(int num) throws AWTException
	{
	   Robot r=new Robot();
	   r.keyPress(KeyEvent.VK_ENTER);
	}
//28
	public void keyEnterRelease(int num) throws AWTException
	{
	   Robot r=new Robot();
	   r.keyRelease(KeyEvent.VK_ENTER);
	}
//29  handle frame
	public void handleFrames(WebDriver driver,int num)
	{
	    driver.switchTo().frame(num);
	}
//30
	public void handleFrames(WebDriver driver,String text)
	{
	    driver.switchTo().frame(text);
	}
//31
	public void handleFrames(WebDriver driver,WebElement ele)
	{
	    driver.switchTo().frame(ele);
	}
//32
	public void switchToWindows(WebDriver driver,WebElement ele,String winHandle)
	{
	    driver.switchTo().window(winHandle);
	}
	
//33
	public void activeElement(WebDriver driver)
	{
	   driver.switchTo().activeElement();
	}
//34
	public Alert alert(WebDriver driver)
	{
	   Alert a=driver.switchTo().alert();
	   return a;
	}
//35
	public void deleteAllCookies(WebDriver driver)
	{
		driver.manage().deleteAllCookies();
	}
//36
	public void scrollAction(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=ele.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",ele);
		//js.executeScript("argument[0].scrollIntoView()",ele);
	}
//37
	
	public void executeScript(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	
//38
	public void switchToWinow(WebDriver driver,String partialWinTitle)
	{
		Set<String> windows = driver.getWindowHandles();
	}
	
//39
	
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
//40	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
//41
	public void enterKey(WebDriver driver) throws AWTException
	{
	   Actions act=new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
	   
	}	
//42	
	public void waitUntilEleToBeClickable(WebDriver driver,int sec,WebElement ele)
	 {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		 wait.until(ExpectedConditions.elementToBeClickable(ele));
	 }
//43
	public void alertGetText(WebDriver driver)
	{    
		driver.switchTo().alert().getText();
		
	}
	
	public void moveToElement(WebDriver driver,WebElement ele) throws AWTException
	{
	   Actions act=new Actions(driver);
	   act.moveToElement(ele).perform();
	   
	}
	public void windowMaximize(WebDriver driver) {
		driver.manage().window().maximize();
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 * @param element
	 * @return
	 */
	public Select selectClassObject(WebElement element) {
		 Select s=new Select(element);
		 return s;
	}
	
	
	public void alertSendKeys(WebDriver driver,String data)
	{
		alert(driver).sendKeys(data);
	}
	
	/**
	 * This method is used to get the text from  alert popup
	 * @param driver
	 */
	public String alertGeetText(WebDriver driver)
	{
		return alert(driver).getText();
	}
	
	
	
	public void alertAcept(WebDriver driver)
	{
		alert(driver).accept();
	}
	
	/**
	 * This method is used to click on cancel button on alert popup
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		alert(driver).dismiss();
	}
	
	
	
	
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		//Use getWindowHandles to capture all the windows
		Set<String> windows = driver.getWindowHandles();
		
		//iterate over all the windows
		Iterator<String> it = windows.iterator();
		
		//check whether next window is there or not
		while(it.hasNext())
		{
			//capture current window ID
			String winId = it.next();
			
			//iterate over window based on that ID and capture the title
			String CurrentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//check whether current window is as expected
			if(CurrentWinTitle.contains(partialWinTitle))
			{
				break;
			}	
		}
	}
	
	
	
	public void scroll(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}	
	
	public void waitTillAlertIsPresent(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
  	public static String  getScreenshot(WebDriver driver, String screenShotName) throws IOException
	{
  		JavaUtils jLib=new JavaUtils();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path="./screenshot/"+screenShotName+jLib.getSystemDateFormat()+".png";
		File dest=new File(path);
		
		//File dest=new File(path) + new JavaUtils().getSystemDateFormat();
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}

	public void selectByVisibleText(WebElement countrydd, String string) {
		// TODO Auto-generated method stub
		
	}
}

