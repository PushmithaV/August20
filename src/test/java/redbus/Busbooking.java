package redbus;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Busbooking {
@Test
public void book() throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.redbus.in/");
	
	driver.findElement(By.id("src")).sendKeys("Ban");
	driver.findElement(By.xpath("//ul[@class='autoFill']/li[1]")).click();
	driver.findElement(By.id("dest")).sendKeys("Mumbai");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//ul[@class='autoFill']/li[1]")).click();
	Actions action = new Actions(driver);
	WebElement date = driver.findElement(By.xpath("//label[.='Onward Date']"));
	action.moveToElement(date).click().perform();
	driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//td[.='30']")).click();
	driver.findElement(By.xpath("//button[@id='search_btn']")).click();
	
	driver.findElement(By.xpath("(//div[@class='clearfix m-top-16']//div[@class='button view-seats fr'])[4]")).click();
	WebElement element = driver.findElement(By.xpath("//div/canvas"));
	//Actions action = new Actions(driver);
	System.out.println(element.getLocation());
	action.moveByOffset(360, 1140).click().perform();
	
//	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//	wait.pollingEvery(Duration.ofMillis(600)).withTimeout(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);
	
}
}