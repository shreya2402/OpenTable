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
	Pages.Home_Page hp;
	
	@Before
	public void setopen() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();    
		//System.out.println("Done with Chrome Diver.....");
		driver.manage().window().maximize();    //maximize browser window
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
        hp = new Pages.Home_Page(driver);
        hp.clickSignIn();
        //hp.clickEmail();
        hp.getDataFromXLSX();
        hp.clickpass();
        hp.clicksignin1();
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
        hd.restro();
        
        
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
        
        //verify the contact number

        String original3 = hd.contact();
        System.out.println(original3);
        
        String expected3 = "(02) 4998 4650";
        Assert.assertEquals(original3, expected3);
    }


}
