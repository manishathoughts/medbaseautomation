package com.medbase.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TableContent {
	
	public static Properties prop;
	public static WebDriver driver;

	

	@Test
	public void TableInPage() throws IOException, InterruptedException
	{
		DriverUtils.initialize();
		
		WebDriver driver=DriverUtils.getDriver();
		
		Actions a= new Actions(driver);
		
		driver.findElement(By.id("inputEmail")).sendKeys("njF83mf@jN7p.z7B");
		driver.findElement(By.id("inputPassword")).sendKeys("3K4Mq*S%1ejqV0iu^glcK&o$m4q^D157");
		driver.findElement(By.xpath("//div[text()='Sign in']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@data-original-title='My Account']")).click();
		Thread.sleep(5000);
		
		List<WebElement> table=driver.findElements(By.xpath("//tr[@ng-repeat='option in account.ContactOptions']"));
		
		for(int i=0;i<table.size();i++)
		{
			System.out.println(table.get(i).getText());
			
			String tableText=table.get(i).getText();
		
			
			Properties prop= DriverUtils.getprop();
			
			if(tableText.equalsIgnoreCase(prop.getProperty("option2")))
			{
				if(prop.getProperty("Contact-option3").equalsIgnoreCase("Both"))
				{
					
					
					WebElement Email=driver.findElements(By.xpath("//input[@ng-model='option.Email']")).get(1);
					
					a.moveToElement(Email).click().build().perform();
					
    WebElement SMS=driver.findElements(By.xpath("//input[@ng-model='option.SMS']")).get(1);
					
					a.moveToElement(SMS).click().build().perform();
			}
			
		
			
			}
	}
	
}
}