package tema_curs3;

import static org.testng.Assert.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tema3 {

	WebDriver driver;
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://keybooks.ro/");
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	@Test
	public void testSelenium() throws InterruptedException {
		
	   List<WebElement> categories = driver.findElements(By.xpath("/html/body/div[1]/div/div[3]/div/div/article/section/div[1]/div/div/div/div/ul/li"));
	   WebElement bookName;
	   String expectedUrl = "https://keybooks.ro/shop/the-forest/";
	   
	   for(WebElement iElement :categories) {
		   
		   Thread.sleep(500);
		   iElement.click();
		   Thread.sleep(500);
		   bookName = driver.findElement(By.linkText("The forest"));
		   assertTrue(bookName.isDisplayed(), "Is displayed");
		   Thread.sleep(500);
		   if(iElement.equals(categories.get(categories.size()-1))) {
			   bookName.click();
			   assertEquals(driver.getCurrentUrl(), expectedUrl, "Is the expexted url");
		   }
	   }
	}

}
