package webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FetchDataFromExeltTest {
	
	
		@DataProvider(parallel = true)
		/*
		 * to run multilpe data retrieved from Excel in parallel
		 */
		public String[][] loginuser() throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream(new File("./target/suryaprasad.xlsx"));
			Workbook workbook = WorkbookFactory.create(fis);
			org.apache.poi.ss.usermodel.Sheet datasheet = workbook.getSheet("prasad");
			int rowCount = datasheet.getPhysicalNumberOfRows() - 1;
			int collCount = datasheet.getRow(0).getPhysicalNumberOfCells();

			String data[][] = new String[rowCount][collCount];
			for (int i = 1, k = 0; i <= rowCount; i++, k++) {
				for (int j = 0; j < collCount; j++) {
					data[k][j] = datasheet.getRow(i).getCell(j).toString();
				}
			}
			return data;
		}

		@Test(dataProvider = "loginuser")
		public void lanchApplication(String[] credentials) {
		    System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			WebDriverWait kadiruveninagagi=new WebDriverWait(driver, 15);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("https://demo.actitime.com/login.do");
			try{
			driver.findElement(By.id("username")).sendKeys(credentials[0]);
			 driver.findElement(By.name("pwd")).sendKeys(credentials[1]);
		//	Thread.sleep(5000);
			driver.findElement(By.id("loginButton")).click();
			WebElement logoutlink = driver.findElement(By.id("logoutLink"));
			kadiruveninagagi.until(ExpectedConditions.visibilityOf(logoutlink));
			driver.findElement(By.id("logoutLink")).click();
			
			System.out.println("amma naaanu bekku");
			}
			
			catch(Exception e) {
				int a=0;
				Reporter.log(++a + " putta benki biddide",true);
				driver.quit();
		}
			
			System.out.println("heng heng henge  naavu");
			driver.quit();
	}
}
