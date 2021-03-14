package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverallRatingPage {
	public OverallRatingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
	}
	
		@FindBy(xpath = "//a[normalize-space()='Make']")
	    public WebElement makeHeader;
        
        @FindBy(xpath = "//a[normalize-space()='Model']")
        public WebElement modelHeader;
    	
    	@FindBy(xpath = "//a[normalize-space()='Rank']")
        public WebElement rankHeader;
    	
    	@FindBy(xpath = "//a[normalize-space()='Votes']")
        public WebElement votesHeader;
    	
    	@FindBy(xpath = "//input[@type='text']")
        public WebElement inputPageNo;
    	
    	@FindBy(xpath = "//a[normalize-space()='»']")
        public WebElement nextPageButton;


}
