package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(id = "username")
    public WebElement inputLogin;
	
	@FindBy(id = "firstName")
    public WebElement inputFirstname;

	@FindBy(id = "lastName")
    public WebElement inputLastname;
	
	@FindBy(id = "password")
    public WebElement inputPassword;
	
	@FindBy(id = "confirmPassword")
    public WebElement inputConfirmPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Register']")
    public WebElement registerSubmitButton;
	
	@FindBy(xpath = "//div[@class='result alert alert-success']")
    public WebElement registerSuccsessfulMessage;
	
	

}
