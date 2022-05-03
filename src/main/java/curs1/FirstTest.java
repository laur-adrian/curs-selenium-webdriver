package curs1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
				Thread.sleep(5000);
				if(userName.isDisplayed() && pwd.isDisplayed()) {
					System.out.println("Login Form is displayed");
				}
			}
		}
		Thread.sleep(10000);
		driver.quit();
	}
}
