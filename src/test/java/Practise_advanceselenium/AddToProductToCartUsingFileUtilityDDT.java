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
import org.openqa.selenium.chrome.ChromeDriver;

import Object_Repository.Login_page;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class AddToProductToCartUsingFileUtilityDDT {

	public static void main(String[] args) throws IOException {
		      //Create object of utilities
		
		       FileUtility fUtil=new FileUtility();
		       SeleniumUtility sUtil=new SeleniumUtility();
		       
		       //Read the common data from property file
				String URL=fUtil.readDataFromPropertyFile("url");
				String USERNAME=fUtil.readDataFromPropertyFile("username");
				String PASSWORD=fUtil.readDataFromPropertyFile("password");
				
				//Read the data from excel file
				
				String PRODUCTNAME=fUtil.readDataFromExcelFile("Inventory",1,2);
				
				
				//Step1 :Launch the browser
						ChromeDriver driver=new ChromeDriver();
						sUtil.maximizeWindow(driver);
						sUtil.addimplicitilyWait(driver);
						
						//Step2 :Load the URL
						driver.get(URL);

						
						//Step3 :Login to application
						Login_page lg=new Login_page(driver);
						//lg.getUsernameEdit().sendKeys(UESRNAME);
						//lg.getPasswordEdit().sendKeys(PASSWORD);
						//lg.getLoginBtn().click();
						
						//business library
						lg.logininToApp(USERNAME,PASSWORD);
						
						
						//Step4 :Add product to cart
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
