package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class checkEnvironment {

    WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		
		
		//Chrome
		//System.setProperty("webdriver.chrome.driver", ".\\Lib\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", ".\\Lib\\geckodriver.exe");
		//driver = new ChromeDriver();
		
//		Firefox141;
		driver = new FirefoxDriver();
		driver.get("https://test-bookuk.etihadholidays.com/agent-portal/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
 
	//@Test
	public void f() throws InterruptedException {
		
		String LoginPageTitle = driver.getTitle();
		AssertJUnit.assertEquals(LoginPageTitle, "Login - Agent Portal");
		driver.findElement(By.className("form-control")).sendKeys("hangtest1");
		driver.findElement(By.id("Password")).sendKeys("Admin@123");
		driver.findElement(By.name("Save")).click();
		Thread.sleep(3000);
		String CCHomepageTitle = driver.getTitle();
		AssertJUnit.assertEquals(CCHomepageTitle, "CC Etihad Holidays");
		
	}
	@Test
	public void login() throws InterruptedException {
		
		String LoginPageTitle = driver.getTitle();
		AssertJUnit.assertEquals(LoginPageTitle, "Login - Agent Portal");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("hangtest1");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin@1234");
		driver.findElement(By.xpath("//button[@name='Save']")).click();
		Thread.sleep(3500);
		String CCHomepageTitle = driver.getTitle();
		AssertJUnit.assertEquals(CCHomepageTitle, "CC Etihad Holidays");
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}