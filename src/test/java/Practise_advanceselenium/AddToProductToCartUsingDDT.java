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

public class AddToProductToCartUsingDDT {

	public static void main(String[] args) throws IOException {
		  
		//Read the common data from property file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String UESRNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		//Read the data from excel file
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book=WorkbookFactory.create(fise);
		Sheet sheet=book.getSheet("Inventory");
		Row rw=sheet.getRow(1);
		Cell c1=rw.getCell(2);
		String PRODUCTNAME=c1.getStringCellValue();
		
		
		//Step1 :Launch the browser
				ChromeDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//Step2 :Load the URL
				driver.get(URL);

				
				//Step3 :Login to application
				driver.findElement(By.id("user-name")).sendKeys(UESRNAME);
				driver.findElement(By.id("password")).sendKeys(PASSWORD);
				driver.findElement(By.id("login-button")).click();
				
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
