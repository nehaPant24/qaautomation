package Testpackage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase1 {

	WebDriver driver;
	
	
	//@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite");
	}
	
	//@Parameters({"Browser"})
	@BeforeMethod
	public void setUp(String Browser)
	{
		//System.setProperty("webdriver.chrome.driver","D:\\Selenium_Jar_Files\\Driver\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		System.out.println("Inside before method");
	}
	@Test
	public void test1() throws InterruptedException
	{
		/*System.setProperty("webdriver.chrome.driver","D:\\Selenium_Jar_Files\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");*/
		
		WebElement select= driver.findElement(By.id("continents"));
		//select.click();
		Select select1= new Select(select);
		select1.selectByVisibleText("Africa");
		Thread.sleep(10000);
		
		System.out.println("First test");
		
	}
	
	//@Test
	public void test2()
	{
		System.out.println("Second test");
	}
	
	//@Test
	public void test3()
	{
		System.out.println("Third test");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		System.out.println("AFter method");
	}
	
	//@AfterSuite
	public void afterSuite()
	{
		System.out.println("AFTER suite");
	}
}