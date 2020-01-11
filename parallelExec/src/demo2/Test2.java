package demo2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 {
	public WebDriver driver;
	static {
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","./softwares/chromedriver.exe");
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void openApp(String browser ) throws InterruptedException
	{
		if(browser.equals("firefox")) {
		 driver=new FirefoxDriver();
		 Thread.sleep(3000);
		driver.get("http://localhost/login.do");
	}else {
		driver=new ChromeDriver();
		driver.get("http://localhost/login.do");
	}	
	}
	@Test
	public void login()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver,5);
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		//driver.getTitle();
		//wait.until(ExpectedConditions.titleContains("Enter"));		
	}
	@AfterMethod
	public void closeApp()
	{
		driver.close();
	}

}


