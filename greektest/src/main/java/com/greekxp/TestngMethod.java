package com.greekxp;
import org.openqa.selenium.chrome.ChromeDriver;
/*import org.openqa.selenium.firefox.FirefoxDriver;*/
import org.testng.annotations.Factory;

public class TestngMethod {

	 @Factory
	    public Object[] createInstances() throws InterruptedException {

	        Object[] obj = new Object[5];

	        for (int iter = 0; iter < 5; iter++) {
	            obj[iter] = new UniversityLogin(new ChromeDriver());
	        }

	        return obj;
	    }
}
