package InventoryTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Object_Repository.CartPage;
import Object_Repository.InventoryItem_Page;
import Object_Repository.Inventory_Page;
import Object_Repository.Login_page;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class AddLowestPriceProductCartTest {

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
				Login_page lp=new Login_page(driver);
				lp.logininToApp(SORTOPTION, PRODUCTNAME);
				
				//Step 4:Click on product
				Inventory_Page ip=new Inventory_Page(driver);
				ip.clickOnLowestPriceProduct(driver, SORTOPTION, PRODUCTNAME);
		         
		        //Step 5: Add to product in cart
				InventoryItem_Page iip=new InventoryItem_Page(driver);
				iip.clickOnAddToCartBtn();
				
				//Step 5:Navigate the cart
				ip.clickOnCartContainerBtn();
				
		         //Step6 :Validate for the product in cart
				CartPage cp=new CartPage(driver);
				String productInCart=cp.captureItemName();
				
		         if(productInCart.equals(PRODUCTNAME))
		         {
		        	 System.out.println(productInCart);
		        	 System.out.println("Pass");
		         }
		         else
		         {
		        	 System.out.println("Fail");
		         }
		         
		         
		         
		       //Step6 :Logout the Application
		        ip.logoutOfApp();


	}

}
