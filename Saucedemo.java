package TestngPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Saucedemo {
	@Test(groups = "test1")
	@Parameters({"username","password"})
	public void demo(String username,String password) {
		
	WebDriverManager.chromedriver().setup();
	RemoteWebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement user= driver.findElement(By.id("user-name"));
	user.sendKeys(username);
	WebElement pass= driver.findElement(By.id("password"));
	pass.sendKeys(password);
	WebElement loginButton =driver.findElement(By.id("login-button"));
	loginButton.click();
	int previousCardCount=0;
	int currentCardCount=0;
	try {
		WebElement cartCountElement= wait.until(ExpectedConditions.presenceOfElementLocated(By.className("shopping_cart_badge")));
		previousCardCount= Integer.valueOf(cartCountElement.getText());
		System.out.println(previousCardCount);
	}
	catch(Exception e) {
		System.out.println("element is not found");
	}
	
	WebElement addProductElement= driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]"));
	addProductElement.click();

	WebElement cartCountElement= wait.until(ExpectedConditions.presenceOfElementLocated(By.className("shopping_cart_badge")));
	currentCardCount = Integer.valueOf(cartCountElement.getText());
	if(currentCardCount>previousCardCount) {
		System.out.println("card added"+(currentCardCount-previousCardCount));
	}
	else {
		System.out.println("not added");
	}
	
}
}