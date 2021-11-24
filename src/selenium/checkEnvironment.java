package selenium;

import java.util.concurrent.TimeUnit;

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
		
//		Firefox;
		driver = new FirefoxDriver();
		driver.get("https://site.qr-row.staging.goquo.io/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
 
	@Test
	public void f() {
		
		String homePageTitle = driver.getTitle();
		AssertJUnit.assertEquals(homePageTitle, "Qatar Airways Holidays | Flight + Hotel + Tour + Transfer");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}