package genericUtilities;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

  /**
   * This class consists of generic method related to selenium tool
   */

public class SeleniumUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add implicitily wait for 10 sec
	 * @param driver
	 */
	
	public void addimplicitilyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for 10 second for the WebElement to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//Clickable action
	/**
	 * This method will wait for 10 second for the WebElement to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//Handle Action
	/**
	 * This method will handle drop downby index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
		
	}
	/**
	 * This method will handle drop down by value
	 * @param element
	 * @param text
	 */
	public void handleDropDown(String value,WebElement element)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method will handle dropdown by visbile text
	 * @param element
	 * @param text
	 */
	public void handleDropDown(WebElement element,String VisibleText)
	{
		Select s=new Select(element);
		s.selectByVisibleText(VisibleText);
	}
	//Action method
	
	/**
	 * This method will perform mouse hovering action on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform drag and drop  action 
	 * @param driver
	 * @param element
	 * @param drop
	 */
	public void drapDropAction(WebDriver driver,WebElement srcele,WebElement tarele)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcele, tarele).perform();
				
	}
	/**
	 * This method will perform double click  action on a webElement
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
				
	}
	
	/**
	 * This method will perform click and hold  action on a web element
	 * @param driver
	 * @param element
	 */
	public void ClickandHoldAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
				
	}
	/**
	 * This method will perform release action on a web element
	 * @param driver
	 * @param element
	 */
	public void releaseAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.release(element).perform();
				
	}
	
	/**
	 * This method will perform scroll action on a web element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
				
	}
	/**
	 * This method will perform right click action web element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	//Frames method 
	
	/**
	 * This method will be handle frame by frame index
	 * @param driver
	 * @param frameindex
	 */
	public void handleFrame(WebDriver driver,int frameindex)
	{
		driver.switchTo().frame(frameindex);
			
	}
	
	/**
	 * This method will be handle frame by frame name or id
	 * @param driver
	 * @param frameNameOrId
	 */
	public void handleFrame(WebDriver driver,String frameNameOrId)
	{
		driver.switchTo().frame(frameNameOrId);
			
	}
	
	/**
	 * This method will be handle frame by frame webElement
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
			
	}
	
	/**
	 * This method will switch to immediate parent frame
	 * @param driver
	 */
	public void swtichToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
			
	}
	
	
	/**
	 * This method will switch to default frame
	 * @param driver
	 */
	public void swtichToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
			
	}
	
	//Pop up method
	
	
	/**
	 * This method will enter data into alert pop up
	 * @param driver
	 * @param data
	 */
	public void enterAlertData(WebDriver driver,String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
	/**
	 * This method will capture the text from alert pop up and return to caller
	 * @param driver
	 * @return
	 */
	public String  getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	
	/**
	 * This method will accept alert popup 
	 * @param driver
	 */
	public void  acceptAlert(WebDriver driver)
	{
		 driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel alert pop up
	 * @param driver
	 */
	public void  dismissAlert(WebDriver driver)
	{
		 driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will switch to required window
	 * @param driver
	 * @param WindowId
	 */
	public void  StwichToWindow(WebDriver driver,String WindowId )
	{
		 driver.switchTo().window(WindowId);
	}
	
	/**
	 * This method will scroll down the page by 500 units
	 * @param driver
	 */
	public void  scrollDown(WebDriver driver)
	{
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500);", "");
	}
	/**
	 * 
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	
	public String captureScreenshot(WebDriver driver,String screenshotname) throws IOException
	{
		
		TakesScreenshot tc=(TakesScreenshot) driver;
		File src=tc.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshot\\"+screenshotname+".png");
		FileHandler.copy(src, dest);
		
		return dest.getAbsolutePath();//for external report
	}
}
