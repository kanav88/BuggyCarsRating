package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopularMakePage {
	public PopularMakePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//h3[normalize-space()='Lamborghini']")
    public WebElement pageLabel;
	
	@FindBy(xpath = "//a[normalize-space()='»']")
    public WebElement nextPageButton;
	
	@FindBy(xpath = "//a[normalize-space()='Model']")
    public WebElement modelHeader;
	
	@FindBy(xpath = "//a[normalize-space()='Rank']")
    public WebElement rankHeader;
	
	@FindBy(xpath = "//a[normalize-space()='Votes']")
    public WebElement votesHeader;
	
	@FindBy(xpath = "//th[@class='comments']")
    public WebElement commentsHeader;
	
	@FindBy(xpath = "//div[@class='row']//div[@class='pull-xs-right']")
    public WebElement pageNumberText;
	
	@FindBy(xpath = "//a[@title='Facebook']//img")
    public WebElement facebookLogo;
	
	

}
