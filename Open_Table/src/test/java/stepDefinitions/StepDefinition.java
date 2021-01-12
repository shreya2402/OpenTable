package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	
	WebDriver driver;
	Pages.Home_details hd;
	
	@Before
	public void setopen() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//System.out.println("Done with Chrome Diver.....");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.get("https://www.opentable.com/");
	
	}
	@Given("^Launch the application browser$")
    public void launch_the_application_browser() throws Throwable {
        System.out.println("Launch the application browser");
    }

	 @When("^clicks on dropdown for location$")
	    public void clicks_on_dropdown_for_location() throws Throwable {
	        System.out.println("clicks on dropdown for location");
	        
	        hd.dropdown();
	 }

    @Then("^click on Menu$")
    public void click_on_menu() throws Throwable {
        System.out.println("click on Menu");
        hd.clickMenu();
    }

    @And("^Open the webpage of Open Table$")
    public void open_the_webpage_of_open_table() throws Throwable {
        System.out.println("Open the webpage of Open Table");
    }

    @And("^verify title of homepage$")
    public void verify_title_of_homepage() throws Throwable {
    	hd = new Pages.Home_details(driver);
        System.out.println("verify title of homepage");
        String original2 = hd.titlehome();
        System.out.println(original2);
        
        String expected2 = "Restaurants and Restaurant Reservations | OpenTable";
        Assert.assertEquals(original2, expected2);
    }

    @And("^choose location$")
    public void choose_location() throws Throwable {
        System.out.println("choose location");
        hd.chooseLocation();     
    }

    @And("^choose restaurant$")
    public void choose_restaurant() throws Throwable {
        System.out.println("choose restaurant");
        hd.chooseRestaurant();
        
    }

    @And("^click on view full menu$")
    public void click_on_view_full_menu() throws Throwable {
        System.out.println("click on view full menu");
        hd.fullMenu();
        
        String original1 = hd.titlerestaurant();
        System.out.println(original1);
        
        String expected1 = "Bimbadgen Pizza Cafe Restaurant - Pokolbin, AU-NSW | OpenTable";
        Assert.assertEquals(original1, expected1);
        
    }

    @And("^click on Photos$")
    public void click_on_photos() throws Throwable {
        System.out.println("click on Photos");
        hd.photos();
    }

   
    @And("^click on Reviews$")
    public void click_on_reviews() throws Throwable {
        System.out.println("click on Reviews");
        hd.reviews();
    }

    @And("^print the current ratting$")
    public void print_the_current_ratting() throws Throwable {
        System.out.println("print the current ratting");
        String ratings = hd.ratting();
        System.out.println("Ratings: "+ratings);
    }

    @And("^go to FAQ$")
    public void go_to_faq() throws Throwable {
        System.out.println("go to FAQ");
        String faq = hd.faqs();
        System.out.println("First Faq question: "+faq);      
    }

    @And("^check parking details$")
    public void check_parking_details() throws Throwable {
        System.out.println("check parking details");
        hd.parking(); 
    }

    @And("^check contact number$")
    public void check_contact_number() throws Throwable {
        System.out.println("check contact number");
        hd.clicviewMore();
        hd.contact();
    }

    @And("^check website of restaurant$")
    public void check_website_of_restaurant() throws Throwable {
        System.out.println("check website of restaurant");
      //a[@href='https://www.bimbadgen.com.au/']
        //String website = driver.findElement(By.xpath("//a[@href='https://www.bimbadgen.com.au/']")).getText();
        //System.out.println("Website: "+website);
    }
    
    
    
    
    
    //Register Functionality
   public By signupframe = By.xpath("//iframe[@title='Sign up']");
    
    @Given("^the application browser is launched$")
    public void the_application_browser_is_launched() throws Throwable {
        System.out.println("the application browser is launched");
    }

    @When("^user clicks Sign up button$")
    public void user_clicks_sign_up_button() throws Throwable {
    	System.out.println("user clicks Sign up button");
    	//button[@class='_1ne6cGD8CL2x_1xIImjIFp _1FpqChvjnfdczUl5bA5xyI'][text()='Sign up']
    	driver.findElement(By.xpath("//button[@class='_1ne6cGD8CL2x_1xIImjIFp _1FpqChvjnfdczUl5bA5xyI'][text()='Sign up']")).click();
    }

    @Then("^the homepage is reloaded$")
    public void the_homepage_is_reloaded() throws Throwable {
    	System.out.println("the homepage is reloaded");
    }

    @And("^the Open Table homepage is opened$")
    public void the_open_table_homepage_is_opened() throws Throwable {
    	System.out.println("the Open Table homepage is opened");
    }

    @And("^user enters the first name$")
    public void user_enters_the_first_name() throws Throwable {
    	System.out.println("user enters the first name");
    	WebElement framesignup = driver.findElement(signupframe);
    	driver.switchTo().frame(framesignup);
    	
    	driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Mohan");
    }

    @And("^user enters the last name$")
    public void user_enters_the_last_name() throws Throwable {
    	System.out.println("user enters the last name");
    	driver.findElement(By.id("LastName")).sendKeys("Mishra");
    }

    @And("^user enters the email$")
    public void user_enters_the_email() throws Throwable {
    	System.out.println("user enters the email");
    	driver.findElement(By.id("Email")).sendKeys("mohan12@gmail.com");
    	
    }

    @And("^user enters valid password$")
    public void user_enters_valid_password() throws Throwable {
    	System.out.println("user enters valid password");
    	driver.findElement(By.id("Password")).sendKeys("mohan12345");
    }

    @And("^user Reenters the password$")
    public void user_reenters_the_password() throws Throwable {
    	System.out.println("user Reenters the password");
    	driver.findElement(By.id("Password2")).sendKeys("mohan12345");
    	
    }

    @And("^user selects the primary dining location$")
    public void user_selects_the_primary_dining_location() throws Throwable {
    	System.out.println("user selects the primary dining location");
    	driver.findElement(By.id("PrimaryDiningCityId")).click();
    	driver.findElement(By.xpath("//option[@value='255']")).click();
    	
    	
    }

    @And("^user clicks on create account button$")
    public void user_clicks_on_create_account_button() throws Throwable {
    	System.out.println("user clicks on create account button");
    	//driver.findElement(By.xpath("//button[@type='submit'][text()='Create Account']")).click();
    }

    @And("^user clicks on the profile icon$")
    public void user_clicks_on_the_profile_icon() throws Throwable {
    	System.out.println("user clicks on the profile icon");
    }

    @And("^user clicks on sign out option$")
    public void user_clicks_on_sign_out_option() throws Throwable {
    	System.out.println("user clicks on sign out option");
    }



}
