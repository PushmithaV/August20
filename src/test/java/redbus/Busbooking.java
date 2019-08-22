package redbus;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Busbooking {
@Test
public void book() throws InterruptedException, AWTException
{
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriver driver = new ChromeDriver(options);
	Dimension d = new Dimension(1100,480);
	driver.manage().window().setSize(d);
	//driver.manage().window().maximize();
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
	//Thread.sleep(5000);

	driver.findElement(By.xpath("//div[@class='button view-seats fr']")).click();
	
	WebElement lower = driver.findElement(By.xpath("//canvas[@data-type='lower']"));
	Point location = lower.getLocation();
	int x1 = location.getX();
	int y1 = location.getY();
	
	System.out.println(x1+ " "+y1);
	
	x1=x1+292;
	y1=y1-85;
//	
	System.out.println(x1+ " "+y1);
//	Thread.sleep(20000);
	//action.moveByOffset(607, 632).click().perform();
	Robot robot= new Robot();
	robot.delay(10000);

	robot.mouseMove(x1,y1);

	robot.mousePress(InputEvent.BUTTON3_DOWN_MASK );

	robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK );
//	
//	
//	driver.findElement(By.xpath("//ul[contains(@class,'select-list ')]/li[2]")).click();
//	driver.findElement(By.xpath("(//ul[contains(@class,'select-list ')])[2]/li/div[3]/span[contains(.,'Chembur')]")).click();
//	driver.findElement(By.xpath("//button[.='Proceed to book']")).click();
	
	/*
	 * document.onmousemove = function(e){
var x = e.pageX;
var y = e.pageY;
e.target.title = "X is "+x+" and Y is "+y;
};*/
	 
	
	
	
}
}