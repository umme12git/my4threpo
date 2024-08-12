	package variousConcepts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	static WebDriver  driver;
		@BeforeClass
	    public static void beforeClass() {
	    	System.out.println("Before tests *******"); 
	    }
	    
	    @Before
		public void init() {
	    	System.out.println("in Before");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\unnip\\selenium-feb24\\session1\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.get("https://codefios.com/ebilling/login");
			driver.manage().window().maximize();
			
		}
		@After
		public void teardown() throws InterruptedException {
			System.out.println("in After end of test");
			Thread.sleep(2000);
			driver.close();
		}
		@Test
		public void loginTest() {
			System.out.println("running positive test");
			driver.findElement(By.id("user_name")).sendKeys("demo@codefios.com");
			driver.findElement(By.id("password")).sendKeys("abc123");
			driver.findElement(By.id("login_submit")).click();
			
		}
		@Test
		public void negativeTest() {
			System.out.println("running negative test");
			driver.findElement(By.id("user_name")).sendKeys("demo100@codefios.com");
			driver.findElement(By.id("password")).sendKeys("abc123456");
			driver.findElement(By.id("login_submit")).click();
			
		}
		@AfterClass
		public static void afterClass( ) {
			System.out.println("After tests **********");
		}
}
