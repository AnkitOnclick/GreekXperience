package com.greekxp;

/*import java.io.IOException;*/
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
/*import org.openqa.selenium.firefox.FirefoxDriver;*/
/*import org.testng.annotations.AfterMethod;*/
/*import org.testng.annotations.AfterTest;*/
import org.testng.annotations.Test;

public class UniversityLogin {
	/*public static WebDriver driver;*/
	
	@Test(invocationCount = 2, threadPoolSize = 1)
	/*public UniversityLogin(ChromeDriver chromeDriver) throws InterruptedException {*/
		public UniversityLogin() throws InterruptedException {
		// TODO Auto-generated constructor stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.browser", "/usr/bin/chrome");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		/*WebDriver driver = new FirefoxDriver();*/
		driver.manage().window().maximize();
		System.out.printf("%n[START] Thread Id : %s is started! ",Thread.currentThread().getId());
		driver.get("https://qa1.greekxperience.com/");
		Thread.sleep(5000);
		String expectedTitle = "GreekXperience | Homepage";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println(" Title matched: " +expectedTitle);
		}else
		{
			System.out.println("Title not matched");
			
		}
		/*Thread.sleep(4000);*/
				  
		// Execute the Java Script for the element which we find out
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//*[@id='header-btn-login']")));
		
		Thread.sleep(2000);
		driver.findElement(By.id("main-username")).clear();
		driver.findElement(By.id("main-username")).sendKeys("admin@fiu.edu");
		driver.findElement(By.id("main-password")).clear();
		driver.findElement(By.id("main-password")).sendKeys("a");
		driver.findElement(By.id("main-login-btn")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[@id='navbar-mobile']/ul/li/a/span")).click();
		Thread.sleep(4000);
	    driver.findElement(By.linkText("Logout")).click();
	    Thread.sleep(2000);
	    System.out.printf("%n[END] Thread Id : %s ",Thread.currentThread().getId());
	    driver.quit();
				
	}
	/*@AfterTest
	private void aftertest() {
	driver.quit();
	}*/
}