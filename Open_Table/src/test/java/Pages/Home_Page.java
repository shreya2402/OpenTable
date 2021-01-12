package Pages;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class Home_Page {
	//this file is for login
	
	WebDriver driver;
    public By button1=By.xpath("//button[text()='Sign in']"); 
    public By email=By.xpath("//input[@name='Email']");
    public By pass=By.xpath("//input[@id='Password']");
    public By signin1=By.xpath("//button[@id='signInButton']");
    public By frame=By.xpath("//iframe[@title='Sign in']");

	
	public Home_Page(WebDriver drv) {
		this.driver=drv;
	}
	public void clickSignIn() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(button1).click();
		Thread.sleep(3000);
	}
	
	
	public void clickEmail(String email1, String pass1) throws InterruptedException {
		WebElement iframeElement = driver.findElement(frame);
   	    driver.switchTo().frame(iframeElement);
		driver.findElement(email).sendKeys(email1);
		driver.findElement(pass).sendKeys(pass1);
		Thread.sleep(3000);
	}
	public void clickpass() throws InterruptedException {
		
    	Thread.sleep(1000);
	}
	public void clicksignin1() throws InterruptedException {
		driver.findElement(signin1).click();
    	Thread.sleep(3000);
	}
	
	
	 
	 
	 
	 public void getDataFromXLSX() throws Exception
	    {
	        String[][] array=null;
	       //Get the file
	        FileInputStream fs=new FileInputStream("testData.xlsx");
	        //go to workbook
	        XSSFWorkbook wb=new XSSFWorkbook(fs);
	        //go to the sheet
	        XSSFSheet sh=wb.getSheetAt(0);
	        XSSFRow rows;
	        XSSFCell cell;
	       
	        int rowCount=sh.getLastRowNum();
	        int columnCount=sh.getRow(0).getLastCellNum();
	        
	        //System.out.println(rowCount);
	        //System.out.println(columnCount);
	       
	        array=new String[rowCount][columnCount];
	       
	        for(int i=1;i<rowCount+1;i++) //for rows
	        {
	            for(int j=0;j<columnCount;j++) //for columns
	            {
	            rows=sh.getRow(i);  //1
	            cell=rows.getCell(j); // 1,0
	            array[i-1][j]=cell.getStringCellValue();
	            
	            }
	            
	        }
	        clickEmail(array[0][0], array[0][1]); //sending email and password which is read from the file
	        
	               
	    }

	
}
