package com.medbase.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickNextTest {
	
	public WebElement clickNext() throws IOException {

		WebDriver driver = DriverUtils.getDriver();

		Actions a = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("//span[@aria-label='Next']"));
		a.moveToElement(target).click().build().perform();
		return target;
	}

}
