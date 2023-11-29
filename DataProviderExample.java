package TestngPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExample {
	RemoteWebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@DataProvider
	public Object[][] sampleData(){
		Object array[][]={{"standard_user","secret_sauce"},
				{"locked_out_user","secret_sauce"},
				{"problem_user","secret_sauce"},
				{"performance_glitch_user","secret_sauce"},
				{"error_user","secret_sauce"},
				{"visual_user","secret_sauce"}};
		return array;
	}
	
	
	@Test(dataProvider = "sampleData")
	public void myTest(String username,String password)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement user= driver.findElement(By.id("user-name"));
		user.sendKeys(username);
		WebElement pass= driver.findElement(By.id("password"));
		pass.sendKeys(password);
		WebElement loginButton =driver.findElement(By.id("login-button"));
		loginButton.click();
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	

	
}
