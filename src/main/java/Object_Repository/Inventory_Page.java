package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;


public class Inventory_Page extends SeleniumUtility{
	
	//Rule 1: Create a seperate pom class for every web page
	
		//Rule 2:Identify the Web element using @FindBy,@FindBys,@FindAll

		
		//Declaration
	@FindBy(className="product_sort_container")
	private WebElement sortDropDown;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	
	@FindBy(id="shopping_cart_container")
	private WebElement cartContainerBtn;
	
	//Rule 3:Create a constructor for element initialization 
	
		//Initialization 
		public Inventory_Page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//how get this getter method automatically
		//step right click on class name select source  click generate getter method 
		public WebElement getSortDropDown() {
			return sortDropDown;
		}

		public WebElement getMenuBtn() {
			return menuBtn;
		}

		public WebElement getLogoutLink() {
			return logoutLink;
		}

		public WebElement getCartContainerBtn() {
			return cartContainerBtn;
		}
		
		//Business library
		/**
		 * 
		 * this method will perform logout operation
		 */
		
		public void logoutOfApp()
		{
			menuBtn.click();
			logoutLink.click();
		}
		
		/**
		 * this method will click on cart container button
		 */
		public void clickOnCartContainerBtn()
		{
			cartContainerBtn.click();
		}

		/**
		 * this method will check on product name stored in excel file
		 * @param driver
		 * @param Productname
		 */
		public void clickOnProduct(WebDriver driver,String Productname)
		{
			driver.findElement(By.xpath("//div[.='"+Productname+"']")).click();
		}
		
		/**
		 * this method will sort the product for lowest and click on product
		 * @param driver
		 * @param sortOption
		 * @param Productname
		 */
		
		public void clickOnLowestPriceProduct(WebDriver driver,String sortOption,String Productname)
		{
			handleDropDown(sortDropDown,sortOption);
			driver.findElement(By.xpath("//div[.='"+Productname+"']")).click();
		}
}
