package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.LaunchChromeBrowser.driver","./src/test/java/drivers/chromedriver.exe");
		WebDriver sp=new ChromeDriver();
		sp.get("https://demowebshop.tricentis.com/");
		System.out.println("launch was successful");
		sp.quit();
	}

}
