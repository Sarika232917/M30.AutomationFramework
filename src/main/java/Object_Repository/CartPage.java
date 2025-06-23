package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(className="inventory_item_name")
	private WebElement itemInfo;
	
	@FindBy(xpath="//button[.='Remove']")
	private WebElement removeBtn;
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	//how get this getter method automatically
	//step right click on class name select source  click generate getter method 
	public WebElement getItemInfo() {
		return itemInfo;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}
	
	public void clickOnRemoveBtn()
	{
		removeBtn.click();
	}
	
	public String captureItemName()
	{
		return itemInfo.getText();
	}
}
