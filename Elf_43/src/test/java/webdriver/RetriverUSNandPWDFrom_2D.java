package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RetriverUSNandPWDFrom_2D {
	
	@DataProvider
	public String[][] credentials() {
		String[][] sarray= {
				              {"suryaprasadmv135@gmail.com","Newsales@11"},
				              {"suryaprasadmv135@gmail.com","Newsales@11"},
				              {"suryaprasadmv135@gmail.com","Newsales@11"},
				              {"suryaprasadmv135@gmail.com","Newsales@11"}
		                   };   
		return sarray;
			
		
	}
	@Test(dataProvider = "credentials")
	public void getcredentials(String [] credentials) {
		System.setProperty("webdriver.LaunchChromeBrowser.driver","./src/main/resources/drivers/chromedriver.exe");
		WebDriver sp=new ChromeDriver();
		sp.get("https://demowebshop.tricentis.com/");
		System.out.println("launch was successful");
		sp.findElement(By.partialLinkText("Log in")).click();
		sp.findElement(By.id("Email")).sendKeys(credentials[0]);
		sp.findElement(By.id("Password")).sendKeys(credentials[1]);
		sp.findElement(By.xpath("//input[@value='Log in']")).click();
		sp.findElement(By.partialLinkText("Log out")).click();
		sp.quit();
		
		
	}

}
