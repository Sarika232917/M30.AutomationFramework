package InventoryTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Object_Repository.CartPage;
import Object_Repository.InventoryItem_Page;
import Object_Repository.Inventory_Page;
import Object_Repository.Login_page;

import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class AddProductToCartTest {

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
					lg.logininToApp(USERNAME, PASSWORD);
					
					// Step 4: Click on product
					Inventory_Page ip = new Inventory_Page(driver);
					ip.clickOnProduct(driver, PRODUCTNAME);
			         
					//Step 5: add product to Cart
					InventoryItem_Page iip = new InventoryItem_Page(driver);
					iip.clickOnAddToCartBtn();
					
					// Step 5: Navigate to cart
					ip.clickOnCartContainerBtn();
					
					// Step 6: Validate for the product in Cart
					CartPage cp = new CartPage(driver);
					String productInCart = cp.captureItemName();
			         
			         //Step6 :Validate for the product in cart
			         if(productInCart.equals(PRODUCTNAME))
			         {
			        	 System.out.println(productInCart);
			        	 System.out.println("Pass");
			         }
			         else
			         {
			        	 System.out.println("Fail");
			         }
			         
			      // Step 7: Logout of Application
			 		ip.logoutOfApp();

	}

}
