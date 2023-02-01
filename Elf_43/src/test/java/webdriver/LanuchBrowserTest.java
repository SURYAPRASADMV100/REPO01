package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LanuchBrowserTest {
	@Test
	public void lanch() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}

}
