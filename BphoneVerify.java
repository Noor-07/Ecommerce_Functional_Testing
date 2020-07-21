package LearnTestNG;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BphoneVerify {
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium-java\\Browser\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	 

	 @Test(priority = 1)
		public void startApp() throws InterruptedException {
		 	driver.get("https://www.demoblaze.com/");
			Thread.sleep(5000);
			String currentURL=driver.getCurrentUrl();
			Assert.assertTrue(currentURL.contains("https://www.demoblaze.com/"));
	 }
	 @Test(priority = 2,description ="it shows all the Mobile in category")
	 public void totalPhone() throws InterruptedException {
		 Thread.sleep(4000);
		//String phoneCategory = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]")).getText();
		//System.out.println("In Phone Category : "+phoneCategory);
		 driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/a[2]")).click();
		 String links1=driver.findElement(By.xpath("//div[@id='tbodyid']")).getText();
			
			System.out.println("The phones are = ");
			System.out.println(links1);
		 
	 }
	 
	 
	}
