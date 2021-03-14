package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopularModelPage {
	public PopularModelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "img[src='/img/cars/Diablo.jpg']")
    public WebElement carImage;
	
	@FindBy(id = "comment")
    public WebElement inputComment;
	
	@FindBy(xpath = "//button[normalize-space()='Vote!']")
    public WebElement voteButton;
	
	@FindBy(xpath = "/html/body/my-app/div/main/my-model/div/div[3]/table/tbody/tr[1]/td[3]")
    public WebElement firstComment;
	
	@FindBy(xpath = "//p[@class='card-text']")
    public WebElement thankYouMessage;
	
	@FindBy(xpath = "/html/body/my-app/div/main/my-model/div/div[3]/table/tbody/tr[1]/td[2]")
    public WebElement firstAuthor;

}
