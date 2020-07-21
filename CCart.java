package LearnTestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CCart {
	WebDriver driver;
@BeforeClass
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium-java\\Browser\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
@Test
public void startApp() throws InterruptedException {
 	driver.get("https://www.demoblaze.com/");
	Thread.sleep(5000);
	String currentURL=driver.getCurrentUrl();
	Assert.assertTrue(currentURL.contains("https://www.demoblaze.com/"));
}
@Test(priority = 1)
	public void URLValidation() throws InterruptedException {
	
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h4[1]/a[1]")).click();
		String actualURL = driver.getCurrentUrl();
		Thread.sleep(2000);
		System.out.println("The URL is = "+actualURL);
	}
@Test(priority = 2,dependsOnMethods = "URLValidation")
	public void VerifyProduct() throws InterruptedException {
			Thread.sleep(3000);
			String actualProduct = driver.findElement(By.className("name")).getText();
			System.out.println("The Actual Product is = "+actualProduct);
		}
@Test(priority = 3,dependsOnMethods = "URLValidation")
	public void AddToCart() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
@Test(priority = 4,dependsOnMethods = "AddToCart")
public void VerifyCart() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[1]/li[4]/a[1]")).click();
	Thread.sleep(2000);
	String Actualprice=driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")).getText();
	System.out.println("The price is = "+Actualprice);
	String Expectedprice = "360";
	Assert.assertEquals(Actualprice, Expectedprice);
}


}
