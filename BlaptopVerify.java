package LearnTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BlaptopVerify {
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
	 @Test(priority = 3,description ="it shows all the lptop in category")
	 public void totalLaptop() throws InterruptedException {
		 Thread.sleep(4000);
		//String phoneCategory = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]")).getText();
		//System.out.println("In Phone Category : "+phoneCategory);
		 driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/a[3]")).click();
		 Thread.sleep(2000);
		 String links2=driver.findElement(By.xpath("//div[@id='tbodyid']")).getText();
			
		 System.out.println("The Laptops are = ");
			System.out.println(links2);
	 }
}
