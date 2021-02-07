package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import home.Adrese;

public class Testiranje {

	WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\poi\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test (priority = 1)
	public void testJutuba() {
		driver.get(Adrese.URL);
		String actual = driver.getCurrentUrl();
		String expected = "https://www.youtube.com/";
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 2) 
	public void testPrvePesme() {
		SoftAssert sa = new SoftAssert();
		
		WebElement search = driver.findElement(By.xpath(Adrese.SEARCH_XPATH));
		search.click();
		search.sendKeys("Rick Astley Never gonna give you up");
		search.sendKeys(Keys.ENTER);
		String actual1 = driver.getCurrentUrl();
		String expected1 = "https://www.youtube.com/results?search_query=Rick+Astley+Never+gonna+give+you+up";
		sa.assertEquals(actual1, expected1);
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.partialLinkText(Adrese.VIDEO1_XPATH)).click();
		String actual2 = driver.getCurrentUrl();
		String expected2 = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
		sa.assertEquals(actual2, expected2);
		
		try {
			Thread.sleep(7500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath(Adrese.VIDEO2_XPATH)).click();
		String actual3 = driver.getCurrentUrl();
		String expected3 = "https://www.youtube.com/watch?v=dQw4w9WgXcQ&list=RDdQw4w9WgXcQ&start_radio=1&t=4";
		sa.assertEquals(actual3, expected3);
		
		sa.assertAll();
	}
	
	
}
