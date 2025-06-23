package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItem_Page {
	
	@FindBy(id="add-to-cart")
	private WebElement addtocartBtn;
	
	public InventoryItem_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//how get this getter method automatically
		//step right click on class name select source  click generate getter method 
	public WebElement getAddToCartBtn()
	{
		return addtocartBtn;
	}
	//business library
	
	public void clickOnAddToCartBtn()
	{
		addtocartBtn.click();
	}

}
