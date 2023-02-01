package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LOginDemoWebshop {
	@Test
	public void lanchApplication() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait kadiruveninagagi = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");

		driver.findElement(By.id("username")).sendKeys("suryaprasadmv135@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("Newsales@11");

		// Thread.sleep(5000);
		driver.findElement(By.id("loginButton")).click();
		WebElement logoutlink = driver.findElement(By.id("logoutLink"));
		kadiruveninagagi.until(ExpectedConditions.visibilityOf(logoutlink));
		driver.findElement(By.id("logoutLink")).click();

		System.out.println("amma naaanu bekku");

	}
}
