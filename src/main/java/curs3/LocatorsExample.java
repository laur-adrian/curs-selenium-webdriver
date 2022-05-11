package curs3;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.*;

public class LocatorsExample extends BaseTest {
	
	

	@Test
	public void tagNameLocator() {

		WebElement emText = driver.findElement(By.tagName("em"));
		System.out.println("Text" + emText.getText());
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border:4px solid red;')", emText);
		assertEquals(emText.getText(), "Discover");
	}
	
	@Test(priority = 1)
	public void linkTextLocator() {
		
		WebElement booksLink = driver.findElement(By.linkText("BOOKS"));
		jseExecutor.executeScript("arguments[0].setAttribute('style','background:yellow;border:4px solid red;')", booksLink);
		booksLink.click();
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/");
		
	}
	
}
