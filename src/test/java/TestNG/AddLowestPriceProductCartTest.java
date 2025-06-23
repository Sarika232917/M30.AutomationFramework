package TestNG;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Object_Repository.CartPage;
import Object_Repository.InventoryItem_Page;
import Object_Repository.Inventory_Page;
import Object_Repository.Login_page;
import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class AddLowestPriceProductCartTest extends BaseClass {

	@Test(groups="RegreesionSuite")
	public  void Tc_002_AddLowestPriceProductCartTest() throws IOException {

				//Read the data from excel file
				
				String SORTOPTION=fUtil.readDataFromExcelFile("Inventory", 4, 2);
				String PRODUCTNAME=fUtil.readDataFromExcelFile("Inventory", 4, 3);
				
		
				
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
				Assert.assertEquals(productInCart, PRODUCTNAME);
		        System.out.println(productInCart);
		        Assert.assertTrue(productInCart.equals(PRODUCTNAME));
		         
		       
	}

}
