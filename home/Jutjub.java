package home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jutjub {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\poi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(Adrese.URL);
		WebElement search = driver.findElement(By.xpath(Adrese.SEARCH_XPATH));
		search.click();
		search.sendKeys("Rick Astley Never gonna give you up");
		search.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.partialLinkText(Adrese.VIDEO1_XPATH)).click();
		
		/*reklame sa skip opcijom se ne pojavljuju. da postoje, inspektovao bih skip dugme. stavio cekanje 5.5 ili 6 sekundi da se omoguci opcija skip,
		 * i namestio klik na skip dugme
		 */
		try {
			Thread.sleep(7500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(Adrese.VIDEO2_XPATH)).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.close();
		
	}

}
