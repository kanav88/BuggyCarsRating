package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuggyCarsHomePage {
	

	public BuggyCarsHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "login")
    public WebElement inputLogin;
    
    @FindBy(name = "password")
    public WebElement inputPassword;
    
    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement loginButton;
    
    @FindBy(xpath = "//a[normalize-space()='Register']")
    public WebElement registerButton;
    
    @FindBy(xpath = "//a[normalize-space()='Buggy Rating']")
    public WebElement buggyRatingHomeButton;
    
    @FindBy(xpath = "//img[@title='Lamborghini']")
    public WebElement popularMakeButton;
    
    @FindBy(xpath = "//img[@title='Diablo']")
    public WebElement popularModelButton;
    
    @FindBy(xpath = "//img[@src='/img/overall.jpg']")
    public WebElement overallRatingButton;
    
    @FindBy(xpath = "//h1[normalize-space()='BuggyCarsRating']")
    public WebElement homePageLabel;
    
    @FindBy(xpath = "//a[normalize-space()='Profile']")
    public WebElement profileButton;
    
    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutButton;
    
    @FindBy(xpath = "//span[@class='label label-warning']")
    public WebElement invalidLoginLabel;
    
    
   

}
