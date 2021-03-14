package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	
	public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(id = "firstName")
    public WebElement inputFirstName;
	
	@FindBy(id = "lastName")
    public WebElement inputLastName;
	
	@FindBy(id = "gender")
    public WebElement inputGender;
	
	@FindBy(id = "age")
    public WebElement inputAge;
	
	@FindBy(id = "address")
    public WebElement inputAddress;
	
	@FindBy(id = "phone")
    public WebElement inputPhone;
	
	@FindBy(id = "hobby")
    public WebElement inputHobby;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement saveButton;
	
	@FindBy(xpath = "//div[@class='result alert alert-success hidden-md-down']")
    public WebElement successmessage;

}
