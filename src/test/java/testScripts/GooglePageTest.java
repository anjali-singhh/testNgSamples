package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GooglePageTest {
	WebDriver driver;
	@BeforeMethod
	//@BeforeTest
	public void setup() {
		    driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			driver.manage().window().maximize();
	}
  @Test(alwaysRun=true,dependsOnMethods = "seleniumSearchTest" )
  public void javaSearchTest() {
	    
		driver.get("https://www.google.com/");
		//Assert.assertEquals(driver.getTitle(),"Google Search");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Java Tutorial");
		searchBox.submit();
		Assert.assertEquals(driver.getTitle(),"Java Tutorial - Google Search");
		
  }
  @Test(priority=2)
  public void seleniumSearchTest() {
	    
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium Tutorial");
		searchBox.submit();
		Assert.assertEquals(driver.getTitle(),"Selenium Tutorial - Google Search");
  }
  
 // @Test
  public void cucumberSearchTest() {
	    
		driver.get("https://www.google.com/");
		//Assert.assertEquals(driver.getTitle(),"Google Search");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Cucumber Tutorial");
		searchBox.submit();
		Assert.assertEquals(driver.getTitle(),"Cucumber Tutorial - Google Search");
		
  }
 // @Test
  public void appiumSearchTest() {
	    
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Appium Tutorial");
		searchBox.submit();
		Assert.assertEquals(driver.getTitle(),"Appium Tutorial - Google Search");
  }
  @AfterMethod
    //@AfterTest
  public void tearDown() {
	 driver.close();
  }
}
