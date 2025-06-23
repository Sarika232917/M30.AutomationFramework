package Practise_advanceselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToProductToCart {

	public static void main(String[] args) {
		//Step1 :Launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step2 :Load the URL
		driver.get("https://www.saucedemo.com/");

		
		//Step3 :Login to application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//Step4 :Add product to cart
         driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).click();
 		 driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
         
         //Step5 :Navigate to cart
         driver.findElement(By.id("shopping_cart_container")).click();
         
         //Step6 :Validate for the product in cart
         String productIncart=driver.findElement(By.className("inventory_item_name")).getText();
         if(productIncart.equals("Sauce Labs Backpack"))
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
