package TestNG;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Object_Repository.CartPage;
import Object_Repository.InventoryItem_Page;
import Object_Repository.Inventory_Page;
import Object_Repository.Login_page;
import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

@Listeners(genericUtilities.ListenersImplementationUtility.class)
public class AddProductToCartTest extends BaseClass {
	@Test(groups="SmokeSuite")

	public  void Tc_001_AddProductToCartTest() throws IOException {
		
			//Read the data from excel file
			
		        	String PRODUCTNAME=fUtil.readDataFromExcelFile("Inventory",1,2);
			
			
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
			        Assert.assertEquals(productInCart, PRODUCTNAME);
			        System.out.println(productInCart);
			        Assert.assertTrue(productInCart.equals(PRODUCTNAME));
			        //For Listeners
			        //Assert.fail();
			        
			         
			    

	}

}
