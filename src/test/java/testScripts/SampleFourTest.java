package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleFourTest {
	WebDriver driver;
	@BeforeMethod
	//@BeforeTest
	public void setup() {
		    driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().window().maximize(); 
			
	}
  @Test
  public void registerPage() throws InterruptedException {
	    
		driver.get("https://demo.opencart.com/");
		Assert.assertEquals(driver.getTitle(),"Your Store");
	    driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
	    driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right.show li a.dropdown-item")).click();
	    driver.findElement(By.id("input-firstname")).sendKeys("Hritesh");
	    driver.findElement(By.id("input-lastname")).sendKeys("Mishra");
	    driver.findElement(By.id("input-email")).sendKeys("hm");
	    driver.findElement(By.id("input-password")).sendKeys("abc123");

	    Thread.sleep(5000);
	    
//	    String str = driver.findElement(By.linkText("Coding Ground")).getText();
//		System.out.println("The Tooltip text is : " +str);
	    
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(10,300)");
	    Thread.sleep(5000);
	    WebElement opt=driver.findElement(By.xpath("//input[@id='input-newsletter-yes']"));
		if(!opt.isSelected()) {
			opt.click();
		}
	    driver.findElement(By.cssSelector("input[type='checkbox']")).click();
	    driver.findElement(By.cssSelector("button[type='submit']")).click();
	    
		
  }
}
