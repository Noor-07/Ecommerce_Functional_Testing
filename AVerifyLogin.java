package LearnTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AVerifyLogin {

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
	public void loginApp() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/ul[1]/li[5]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")).sendKeys("demo1234");
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]")).sendKeys("demo1234");
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[3]/button[2]")).click();
		}

@Test(priority = 3)
	public void homePage() throws InterruptedException {
		Thread.sleep(3000);
		//String actualUser = driver.findElement(By.linkText("Welcome demo123")).getText();
		String actualUser = driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/ul[1]/li[7]/a[1]")).getText();
		//System.out.println("The Username is = "+actualUser);
		//Assert.assertTrue(actualUser.contains("Welcome demo123"));
		String expectedUser= "Welcome demo123";
		Assert.assertEquals(actualUser, expectedUser);
		
		}
//validate log
@Test(priority = 4)
public void logo() {
	Boolean display=driver.findElement(By.xpath("//a[@id='nava']")).isDisplayed();
	System.out.println("Logo is presented and it is "+display);
	
} 

}
	

