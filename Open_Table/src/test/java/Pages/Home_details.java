package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_details {
	
	WebDriver driver;
	public By  dropdown1 = By.xpath("//button[@aria-label='Toggle location picker']");
	public By country = By.xpath("//a[@href='https://www.opentable.com/sydney-restaurants'][text()='Sydney / New South Wales']");
	public By area = By.xpath("//div[@class='_1PJhO46xNvXjCqsm_OWY8u'][text()='Hunter Valley']");
	public By restaurant = By.xpath("//img[@alt='A photo of Bimbadgen Pizza Cafe restaurant']");
	public By menu = By.id("menu-link");
	public By menufull =By.linkText("Menu");
	public By photos1 = By.linkText("Photos");
	public By review = By.linkText("Reviews");
	public By rattings = By.xpath("//span[text()='4.4']");
	public By frequentque = By.xpath("//span[text()='FAQs']");
	public By que1 = By.xpath("//span[text()='Does Bimbadgen Pizza Cafe offer delivery through OpenTable or takeout?']");
	public By detailparking = By.xpath("//div[text()='None']");
	public By viewmore = By.xpath("//span[text()='View more']");
	public By contactelement = By.xpath("//div[text()='(02) 4998 4650']");
	
	
	public Home_details(WebDriver driver) {
		this.driver = driver;
	}
	
	public String  titlehome() {
		String title1 = driver.getTitle();
		return title1;
	}
	
	public void dropdown() {
		//button[@aria-label='Toggle location picker']
	    driver.findElement(dropdown1).click();

	}
	
	public void chooseLocation() {
		//a[@href='https://www.opentable.com/start/?m=3367'][text()='India']
		driver.findElement(country).click();
		//div[@class='_1PJhO46xNvXjCqsm_OWY8u'][text()='Hunter Valley']
		driver.findElement(area).click();
	}
	
	public void chooseRestaurant() {
		driver.findElement(restaurant).click();
	}
	
	
	public void clickMenu() {
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			//System.out.println("Parent Handle: "+winHandle);	
		}
        driver.findElement(menu).click();
	}
	
	public void fullMenu() {
		driver.findElement(menufull).click();
	}
	
	public void photos() {
		driver.findElement(photos1).click();
	}
	
	public void reviews() {
		driver.findElement(review).click();
	}
	
	public String ratting() {
		String ratting = driver.findElement(rattings).getText();
		return ratting;
	}
	
	public String faqs() {
		driver.findElement(frequentque);
		//span[text()='Bimbadgen Pizza Cafe offers takeout which you can order by calling the restaurant at (02) 4998 4650.']
        String faq = driver.findElement(que1).getText();
        return faq;
        
	}
	
	public void parking() {
		String parking = driver.findElement(detailparking).getText();
        System.out.println("Parking Details: "+parking);
	}
	
	public void clicviewMore() {
		
		WebElement scanEle =new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(viewmore));
		Actions action =new Actions(driver);
		action.moveToElement(scanEle).click().build().perform();
	}
	
	public String contact() {
		//div[text()='(02) 4998 4650']
        String contact = driver.findElement(contactelement).getText();
        System.out.println("Phone number: "+ contact);
        return contact;
	}
	
	
	public String titlerestaurant() {
		
		String title2 = driver.getTitle();
		return title2;
		
	}
	
	
	public void restro() {
		driver.findElement(By.xpath("//input[@placeholder=\"Location, Restaurant, or Cuisine\"]")).sendKeys("Bimbadgen Pizza Cafe");
		driver.findElement(By.xpath("//button[text()='Let’s go']")).click();
		driver.findElement(By.xpath("//img[@srcset=\"https://resizer.otstatic.com/v2/photos/legacy/3/30792923.jpg 208w, https://resizer.otstatic.com/v2/photos/xsmall/3/30792923.jpg 105w, https://images.otstatic.com/prod1/30792923/3/small.jpg 160w, https://images.otstatic.com/prod1/30792923/3/medium.jpg 320w\"]")).click();
	}
}
