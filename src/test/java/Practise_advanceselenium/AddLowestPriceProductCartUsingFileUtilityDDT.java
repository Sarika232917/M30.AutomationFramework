package Practise_advanceselenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class AddLowestPriceProductCartUsingFileUtilityDDT {

	public static void main(String[] args) throws IOException {

		//create Object of Utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		
		//Read the Common Data from Property file
				String URL=fUtil.readDataFromPropertyFile("url");
				String UESRNAME=fUtil.readDataFromPropertyFile("username");
				String PASSWORD=fUtil.readDataFromPropertyFile("password");
				
				//Read the data from excel file
				
				String SORTOPTION=fUtil.readDataFromExcelFile("Inventory", 4, 2);
				String PRODUCTNAME=fUtil.readDataFromExcelFile("Inventory", 4, 3);
				
		
		
		
				//Step1 :Launch the browser
				ChromeDriver driver=new ChromeDriver();
				sUtil.maximizeWindow(driver);
				sUtil.addimplicitilyWait(driver);
				
				//Step2 :Load the URL
				driver.get(URL);

				
				//Step3 :Login to application
				driver.findElement(By.id("user-name")).sendKeys(UESRNAME);
				driver.findElement(By.id("password")).sendKeys(PASSWORD);
				driver.findElement(By.id("login-button")).click();
				
				//Navigate to dropdown
				 WebElement sortDropdwownElement =driver.findElement(By.className("product_sort_container"));
				 sUtil.handleDropDown(sortDropdwownElement,SORTOPTION);
				 
				 //Click on sorted product
				 driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		 		 driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
		         
		         //Step5 :Navigate to cart 
		         driver.findElement(By.id("shopping_cart_container")).click();
		         
		         //Step6 :Validate for the product in cart
		         String productIncart=driver.findElement(By.className("inventory_item_name")).getText();
		         if(productIncart.equals(PRODUCTNAME))
		         {
		        	 System.out.println(productIncart);
		        	 System.out.println("Pass");
		         }
		         else
		         {
		        	 System.out.println("Fail");
		         }
		         
		         
		         
		       //Step6 :Logout the Application
		         driver.findElement(By.id("react-burger-menu-btn")).click();
		         driver.findElement(By.linkText("Logout")).click();


	}

}
