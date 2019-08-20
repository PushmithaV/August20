package brokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Qspiders {
	@Test
	public void brokenlinks() throws IOException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://www.qspiders.com/");	
	driver.findElement(By.className("close")).click();
	List<WebElement> links = driver.findElements(By.tagName("a"));
	 String length = String.valueOf(links.size());
	Reporter.log(length,true);
	for(WebElement we:links)
	{
		URL u= new URL(we.getAttribute("href"));
		HttpURLConnection connection=(HttpURLConnection)u.openConnection();
		int i=connection.getResponseCode();
		
		if(i==200)
		{
			System.out.println("Link is not broken and the code is "+i);
			System.out.println(connection.getResponseMessage());
		}
		else		{
			
				System.out.println("Link is broken and the code is "+i);
				System.out.println(connection.getResponseMessage());			
		}	
		
	}
	driver.close();
	}
}
