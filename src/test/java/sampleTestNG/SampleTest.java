package sampleTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SampleTest {
	
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	WebDriver driver=null;
    
	@Test
	public void verifyHomepageTitle() {

		System.out.println("launching chrome browser..........");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		//driver.close();
	}
	@Test
	public void verifylink() {
		System.out.println("Check link on page");
		WebElement link=driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]"));
		Assert.assertTrue(link.isDisplayed(), "Image is displaying");
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown() {
		System.out.println("Closing Browser...!!!");
		//driver.quit();
	}
	
}
