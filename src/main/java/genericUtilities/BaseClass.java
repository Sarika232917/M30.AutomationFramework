package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Object_Repository.Inventory_Page;
import Object_Repository.Login_page;

public class BaseClass {
	
	public FileUtility fUtil=new FileUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	public JavaUtility jUtil=new JavaUtility();
	
	public WebDriver driver;
	
	//for Listeners
	public static  WebDriver sdriver;
	/**
	 * This class consists of basic configuration annotations of testing
	 * @author sarik
	 */
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("-------Database connection successful-------");	
	}
	//@Parameters("browser")
	@BeforeTest
	//@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String  pvalue*/) throws IOException
	{
		String URL =fUtil.readDataFromPropertyFile("url");
		driver=new ChromeDriver();
		//driver=new ChromeDriver();
		//for cross browser execution
		//if(pvalue.equals("firefox"))
		//{
			driver=new FirefoxDriver();
		//}
		//else
			//if(pvalue.equals("edge"))
			//{
				//driver=new EdgeDriver();
			//}
			//else
			//{
		//		driver=new EdgeDriver();
			//}
		sUtil.maximizeWindow(driver);
		sUtil.addimplicitilyWait(driver);
		driver.get(URL);
		
		//for Listeners
		sdriver=driver;
		System.out.println("------------Browser  launch successfully-----------");
	}
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String USERNAME=fUtil.readDataFromPropertyFile("username");
		String PASSWORD=fUtil.readDataFromPropertyFile("password");
		
		Login_page lp=new Login_page(driver);
		lp.logininToApp(USERNAME, PASSWORD);
		System.out.println("------------Login  to Application successfully-----------");
		
	}
	@AfterMethod(alwaysRun=true)
	public void amConfig()
	{
		Inventory_Page ip=new Inventory_Page(driver);
		ip.logoutOfApp();
		System.out.println("------------Logout  of  Application successfully-----------");

	}
	@AfterTest
	//@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("------------Browser  closure successfully-----------");	
	}
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		
		System.out.println("------------Database   closure successfully-----------");	
	}
	
	//@Test
	public void sample()
	{
		System.out.println("demo");	}
	
	
	
	
}
