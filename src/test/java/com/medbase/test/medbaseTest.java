package com.medbase.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class medbaseTest {

	@Test
	public void medbasepage() throws IOException, InterruptedException

	{
		DriverUtils.initialize();

		WebDriver driver = DriverUtils.getDriver();

		Actions a = new Actions(driver);

		driver.findElement(By.id("inputEmail")).sendKeys("njF83mf@jN7p.z7B");
		driver.findElement(By.id("inputPassword")).sendKeys("3K4Mq*S%1ejqV0iu^glcK&o$m4q^D157");
		driver.findElement(By.xpath("//div[text()='Sign in']")).click();
		Thread.sleep(3000);

		a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'MI reports')]"))).click().build()
				.perform();

		driver.findElement(By.xpath("//td[text()='Absence Overview']")).click();

		List<WebElement> date = driver.findElements(By.xpath("//input[@name='date']"));

		for (int i = 0; i < date.size(); i++) {

			date.get(i).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), "30/04/2019");

			if (i == 1) {
				date.get(i).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), "30/10/2019");
			}
		}

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("button.btn.btn-primary.pull-right")).click();

		Thread.sleep(5000);

		ArrayList<String> inclusionlist = new ArrayList<String>();

		inclusionlist.add("Streater");
		inclusionlist.add("Acland");
		inclusionlist.add("De la Yglesia");

		ArrayList<String> exclusionlist = new ArrayList<String>();

		exclusionlist.add("Graddon");
		exclusionlist.add("Shoobridge");

		Map<String, Integer> lastNamesInPage = new HashMap<String, Integer>();
		Map<String, ArrayList> firstNamesInPage = new HashMap<String, ArrayList>();

		for (int pageCount = 1; pageCount <= 5; pageCount++) {

			System.out.println("Page no:----------------------------------> " + pageCount);
			List<WebElement> employeeSurName = driver.findElements(By.xpath("//tbody//tr//td[17]"));
			Thread.sleep(3000);
			

			for (WebElement e : employeeSurName) {

				
				System.out.println(e.getText());
				if(lastNamesInPage.containsKey(e.getText().toUpperCase())) {
					lastNamesInPage.put(e.getText().toUpperCase(), lastNamesInPage.get(e.getText().toUpperCase())+1);
				} else {
					lastNamesInPage.put(e.getText().toUpperCase(), 1);
				}
			}
			

			//lastNamesInPage.clear();
			if (pageCount < 5) {
				clickNext();
				Thread.sleep(3000);
			}
		}
		
		System.out.println("Last names in page:-------------------->"+lastNamesInPage);
		for(String inclusionName: inclusionlist) {
			System.out.println("inclusionName: "+inclusionName+" lastNamesInPage size: "+lastNamesInPage.size());
			assertTrue(lastNamesInPage.containsKey(inclusionName.toUpperCase()));
			System.out.println(inclusionName+": "+lastNamesInPage.get(inclusionName.toUpperCase()));
			
		}
		
		for(String exclusionName: exclusionlist) {
			assertFalse(lastNamesInPage.containsKey(exclusionName.toUpperCase()));
		}

	}

	public WebElement clickNext() throws IOException {

		WebDriver driver = DriverUtils.getDriver();

		Actions a = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("//span[@aria-label='Next']"));
		a.moveToElement(target).click().build().perform();
		return target;
	}
}
