package LearnTestNG;



import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class BValidateCategory {
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException {
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
	public void categoryPhones() throws InterruptedException {
		
		
		String categoryName = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/a[2]")).getText();
		System.out.println("The Category name is = "+categoryName);
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/a[2]")).click();
		Thread.sleep(2000);
		String actualPhoneCategory = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h4[1]/a[1]")).getText();
		System.out.println("The device Name is = "+actualPhoneCategory);
		String expectedPhoneCategory="Samsung galaxy s6";
		Assert.assertEquals(actualPhoneCategory, expectedPhoneCategory);
		
	}
	@Test(priority = 3)
	public void categoryLaptops() throws InterruptedException {
		
		driver.navigate().to("https://www.demoblaze.com/");
		Thread.sleep(2000);
		String categoryName = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/a[3]")).getText();
		System.out.println("The Category name is = "+categoryName);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/a[3]")).click();
		//WebElement element = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a"));
		//String textString= element.getText();
		Thread.sleep(2000);
		String actualLaptop = driver.findElement(By.linkText("Sony vaio i7")).getText();
		System.out.println("The Device name is = "+actualLaptop);
		String expectedLaptop = "Sony vaio i7";
		Assert.assertEquals(actualLaptop, expectedLaptop);
		
	}
	@Test(priority = 4)
	public void categoryMonitor() throws InterruptedException {
		
		driver.navigate().to("https://www.demoblaze.com/");
		Thread.sleep(2000);
		String categoryName = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/a[4]")).getText();
		System.out.println("The Category name is = "+categoryName);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/a[4]")).click();
		//WebElement element = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a"));
		//String textString= element.getText();
		Thread.sleep(2000);
		String actualMonitor = driver.findElement(By.linkText("Apple monitor 24")).getText();
		Thread.sleep(2000);
		System.out.println("The Device name is = "+actualMonitor);
		String expectedMonitor = "Apple monitor 24";
		Assert.assertEquals(actualMonitor, expectedMonitor);
		
	}
	
}
