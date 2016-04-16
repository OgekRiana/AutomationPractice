package BasePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;

public class BaseClass {
	public String baseUrl = "http://automationpractice.com";
	public WebDriver driver = new FirefoxDriver();
	public String expected = null;
	public String actual = null;
	
	@BeforeTest
	public void launchBrowser() {
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		expected = "My Store";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	//@AfterTest
	public void terminateBrowser() {
		driver.close();
		System.exit(0);
	}
}
