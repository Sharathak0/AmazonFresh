
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addToCart {

public static WebDriver driver;

@BeforeClass
public static void BrowserLauch() {
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	driver.manage().window().maximize();

	driver.get("https://www.amazon.in/alm/storefront?almBrandId=ctnow");
 }

@Test
public void Execute() throws InterruptedException {
	Searchprod();
}
 public void Searchprod() throws InterruptedException {
	WebElement ser2 = driver.findElement(By.id("GLUXZipUpdateInput"));
	ser2.sendKeys("600087");
	driver.findElement(By.xpath("//input[@aria-labelledby='GLUXZipUpdate-announce']")).click();
	Thread.sleep(3000);
	WebElement ser1 = driver.findElement(By.id("twotabsearchtextbox"));
	ser1.sendKeys("Jam");
	Thread.sleep(3000);
	driver.findElement(By.id("nav-search-submit-button")).click();
	
	WebElement select = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/span/div/div/div[3]/div[1]/h2/a/span"));
	select.click();
	
	Set<String> windowhand = driver.getWindowHandles();
	
	Iterator<String> it = windowhand.iterator();
	String parentwindow = it.next();
	String childwindow = it.next();
	
	System.out.println(parentwindow);
	System.out.println(childwindow);
	
	
	 driver.switchTo().window(childwindow);
	 	
	Thread.sleep(3000);

	 driver.findElement(By.xpath("//input[@aria-labelledby='freshAddToCartButton-announce']")).click();
	
	
 }
}
