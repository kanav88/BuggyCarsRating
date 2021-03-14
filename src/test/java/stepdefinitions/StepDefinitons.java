package stepdefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.BuggyCarsHomePage;
import pageobjects.OverallRatingPage;
import pageobjects.PopularMakePage;
import pageobjects.PopularModelPage;
import pageobjects.ProfilePage;
import pageobjects.RegisterPage;
import utils.FileUtils;
import utils.Waits;

public class StepDefinitons {
	public WebDriver driver;
	private static String login = "";

    public void startDriver(String url){

        System.setProperty("webdriver.chrome.driver", new File("chromedriver.exe").getPath());
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        

    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

        if(scenario.isFailed()){
            FileUtils fileUtils = new FileUtils();
            fileUtils.addScreenshot(scenario, driver);
        }

        driver.quit();

    }

	@Given("User is on home page")
	public void user_is_on_home_page() {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		String url = "https://buggy.justtestit.org";
		startDriver(url);
		
	}
	
	@When("User enters credentials {string} {string}")
	public void user_enters_credentials(String username, String password) {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(homepage.homePageLabel);
		homepage.inputLogin.sendKeys(username);
		homepage.inputPassword.sendKeys(password);
		homepage.loginButton.click();
	}
	
	@Then("User should be able to see logout button")
	public void user_should_be_able_to_see_logout_button() {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(homepage.logoutButton);
		
	}
	
	@Then("User should be able to see failure message")
	public void user_should_be_able_to_see_failure_message() {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(homepage.invalidLoginLabel);
		String msg = homepage.invalidLoginLabel.getText();
		assertTrue(msg.contains("Invalid username/password"));
	}
	
	@Then("User should be able to logout successfully")
	public void user_should_be_able_to_logout_successfully() {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		Waits waits = new Waits(driver);
		homepage.logoutButton.click();
		waits.waitForElement(homepage.loginButton);
		homepage.loginButton.isDisplayed();
		
	}
	
	@When("User goto register page")
	public BuggyCarsHomePage user_goto_register_page() {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		Waits waits = new Waits(driver);
		homepage.registerButton.click();
		return homepage;
	}
	
	@Then("User should be able to register successfully")
    public void user_should_be_able_to_register_successfully() throws Throwable  {
    	RegisterPage registerpage = new RegisterPage(driver);
		Waits waits = new Waits(driver);
		String loginName = waits.getSaltString();
		waits.waitForElement(registerpage.inputLogin);
		registerpage.inputLogin.sendKeys(loginName);
		registerpage.inputFirstname.sendKeys("admin");
		registerpage.inputLastname.sendKeys("admin");
		registerpage.inputPassword.sendKeys("Admin@123");
		registerpage.inputConfirmPassword.sendKeys("Admin@123");
		login = registerpage.inputLogin.getText();
		registerpage.registerSubmitButton.click();
		waits.waitForElement(registerpage.registerSuccsessfulMessage);
		registerpage.registerSuccsessfulMessage.isDisplayed();
		login = loginName;
			
    }
	
	@When("User goes to profile page")
	public void user_goes_to_profile_page() {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(homepage.profileButton);
		homepage.profileButton.click();
	}

	@Then("He can change his profile")
	public void he_can_change_his_profile() {
		ProfilePage profilepage = new ProfilePage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(profilepage.inputFirstName);
		profilepage.inputFirstName.clear();
		profilepage.inputFirstName.sendKeys("newAdmin");
		profilepage.inputLastName.clear();
		profilepage.inputLastName.sendKeys("newAdmin");
		profilepage.inputGender.clear();
		profilepage.inputGender.sendKeys("Male");
		profilepage.inputAge.clear();
		profilepage.inputAge.sendKeys("30");
		profilepage.inputAddress.clear();
		profilepage.inputAddress.sendKeys("test");
		profilepage.inputPhone.clear();
		profilepage.inputPhone.sendKeys("123456");
		Select option = new Select(profilepage.inputHobby);
		option.selectByIndex(1);
		profilepage.saveButton.click();
		waits.waitForElement(profilepage.successmessage);
		assertTrue(profilepage.successmessage.getText().contains("The profile has been saved successful"));
					
	}
	
	@When("User goes to popular make page")
	public void user_goes_to_popular_make_page() {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(homepage.popularMakeButton);
		homepage.popularMakeButton.click();
	}

	@When("User selects a {string}")
	public void user_selects_a(String car) {
		PopularMakePage popularmakepage = new PopularMakePage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(popularmakepage.modelHeader);
		driver.findElement(By.xpath("//a[normalize-space()="+ car + "]")).click();
	}


	@Then("User should be able to navigate to {string} page")
	public void user_should_be_able_to_navigate_to_page(String car) throws Throwable {
		PopularMakePage popularmakepage = new PopularMakePage(driver);
		Waits waits = new Waits(driver);
		Thread.sleep(1000);
		waits.waitForElement(popularmakepage.facebookLogo);
		driver.findElement(By.xpath("//strong[text()="+ car + "]"));
	}
	
	@Then("User should be able to navigate to other pages")
	public void user_should_be_able_to_navigate_to_other_pages() {
		PopularMakePage popularmakepage = new PopularMakePage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(popularmakepage.nextPageButton);
		String pageOnetext = popularmakepage.pageNumberText.getText();
		assertTrue(pageOnetext.contains("page 1 of 2"));
		popularmakepage.nextPageButton.click();
		String pageTwotext = popularmakepage.pageNumberText.getText();
		assertTrue(pageTwotext.contains("page 2 of 2"));
		
	}
	
	@When("Login with new User")
	public void login_with_new_User() {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		Waits waits = new Waits(driver);
		homepage.inputLogin.sendKeys(login);
		homepage.inputPassword.sendKeys("Admin@123");
		homepage.loginButton.click();
		waits.waitForElement(homepage.logoutButton);
		homepage.buggyRatingHomeButton.click();
		waits.waitForElement(homepage.popularModelButton);
	}

	@When("goto popular model page")
	public void goto_popular_model_page() {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(homepage.popularModelButton);
		homepage.popularModelButton.click();
	}

	@Then("User is able to vote")
	public void user_is_able_to_vote() {
	   PopularModelPage popularmodelpage = new PopularModelPage(driver);
	   Waits waits = new Waits(driver);
	   waits.waitForElement(popularmodelpage.inputComment);
	   popularmodelpage.inputComment.sendKeys("This is a test comment");
	   popularmodelpage.voteButton.click();
	   waits.waitForElement(popularmodelpage.thankYouMessage);
	   popularmodelpage.thankYouMessage.isDisplayed();
	}

	@Then("comment is updated in the table")
	public void comment_is_updated_in_the_table() {
		PopularModelPage popularmodelpage = new PopularModelPage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(popularmodelpage.firstComment);
		String comment = popularmodelpage.firstComment.getText();
		assertTrue(comment.contains("This is a test comment"));
	    
	}
	
	@When("User goes to overall rating page")
	public void user_goes_to_overall_rating_page() {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(homepage.overallRatingButton);
		homepage.overallRatingButton.click();
	}
	
	@When("User input page {string}")
	public void user_input_page(String pageNo) {
		OverallRatingPage overallratingpage = new OverallRatingPage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(overallratingpage.inputPageNo);
		overallratingpage.inputPageNo.click();
		overallratingpage.inputPageNo.sendKeys(Keys.CLEAR);
		overallratingpage.inputPageNo.sendKeys(pageNo);
		overallratingpage.inputPageNo.sendKeys(Keys.ENTER);
		overallratingpage.nextPageButton.click();
		
	}

	@Then("page forward button should be disabled")
	public void page_forward_button_should_be_disabled() {
		OverallRatingPage overallratingpage = new OverallRatingPage(driver);
		assertFalse(overallratingpage.nextPageButton.isEnabled());
	}
	
	@When("User click home button")
	public void user_click_home_button() {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(homepage.buggyRatingHomeButton);
		homepage.buggyRatingHomeButton.click();
	}
	
	
	@Then("User should be able to navigate back to home page")
	public void user_should_be_able_to_navigate_back_to_home_page() {
		BuggyCarsHomePage homepage = new BuggyCarsHomePage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(homepage.popularModelButton);
		homepage.popularModelButton.isDisplayed();
	}
	
	@Then("Author name should be updated")
	public void author_name_should_be_updated() {
		PopularModelPage popularmodelpage = new PopularModelPage(driver);
		Waits waits = new Waits(driver);
		waits.waitForElement(popularmodelpage.firstComment);
		String author = popularmodelpage.firstAuthor.getText();
		assertFalse(author.isEmpty());
	}



	

    
    

}
