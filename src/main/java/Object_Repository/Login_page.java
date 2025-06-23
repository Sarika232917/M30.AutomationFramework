package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	//Rule 1: Create a seperate pom class for every web page
	
	//Rule 2:Identify the Web element using @FindBy,@FindBys,@FindAll

	
	//Declaration
	@FindBy(id="user-name")
	private WebElement usernameEdit;
	
	@FindBy(id="password")
	private WebElement passwordEdit;
	
	@FindBy(name="login-button")
	private WebElement loginBtn;
	
	//Rule 3:Create a constructor for element initialization 
		
	//Initialization 
	public Login_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide getter to access the web element 
	
	//how get this getter method automatically
	//step right click on class name select source  click generate getter method 
    //Utilization
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Library-resusable method-specific to project
	/**
	 * This method will perform login application
	 * @param un
	 * @param pwd
	 */
	public void logininToApp(String un,String pwd)
	{
		usernameEdit.sendKeys(un);
		passwordEdit.sendKeys(pwd);
		loginBtn.click();
	}

}
