package LearnTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ASignUp {
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
	 @Test(priority = 2)
	 public void signUp() throws InterruptedException {
		 driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/ul[1]/li[8]/a[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")).sendKeys("demo1234");
		 driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]")).sendKeys("demo1234");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/button[2]")).click();
		 driver.switchTo().alert().accept();
	 }
}
