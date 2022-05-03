package curs1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {
	
	@Test
	public void testSelenium() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.keybooks.ro/");
		
		WebElement loginButton = driver.findElement(By.cssSelector("#menu_user > li > a"));
		WebElement userName = driver.findElement(By.cssSelector("#log"));
		WebElement pwd = driver.findElement(By.cssSelector("#password"));
		
		if(loginButton.isDisplayed()) {
			if(!(userName.isDisplayed() && pwd.isDisplayed())) {
				loginButton.click();
				Thread.sleep(1000);
				if(userName.isDisplayed() && pwd.isDisplayed()) {
					userName.sendKeys("user");
					Thread.sleep(1000);
					pwd.sendKeys("123456");
				}
			}
		}
		Thread.sleep(5000);
		driver.quit();
	}
}
