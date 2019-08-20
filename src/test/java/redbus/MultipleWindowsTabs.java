package redbus;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowsTabs {

	@Test
	public void multiple()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.irctc.com");
		driver.findElement(By.xpath("(//a[@href='https://www.irctctourism.com/'])[3]")).click();
		Set<String> wind = driver.getWindowHandles();
		Iterator<String> winditerator = wind.iterator();
		String parent = winditerator.next();
		String child = winditerator.next();
		
		driver.switchTo().window(child);
		driver.findElement(By.linkText("Flights")).click();
		
		Set<String> wind2 = driver.getWindowHandles();
		Iterator<String> winditerator2 = wind2.iterator();
		winditerator2.next();
		winditerator2.next();
		
		String child2 = winditerator2.next();
		driver.switchTo().window(child2);
		driver.close();
		driver.switchTo().window(child);
		driver.close();
		driver.switchTo().window(parent);
		driver.close();
		
		
	}

}
