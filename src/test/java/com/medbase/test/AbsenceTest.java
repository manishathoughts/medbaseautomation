package com.medbase.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import dto.TableRow;

public class AbsenceTest {

	String downloadPath = "C:\\Users\\Viswa\\Documents\\codebase\\medbaseautomation\\downloadfolder\\";
	String fileName = "absences.csv";

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void absenceManage() throws IOException, InterruptedException

	{
		DriverUtils.initialize();

		WebDriver driver = DriverUtils.getDriver();

		Actions a = new Actions(driver);

		driver.findElement(By.id("inputEmail")).sendKeys("njF83mf@jN7p.z7B");
		driver.findElement(By.id("inputPassword")).sendKeys("3K4Mq*S%1ejqV0iu^glcK&o$m4q^D157");
		driver.findElement(By.xpath("//div[text()='Sign in']")).click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement absence = driver.findElement(By.xpath("//span[contains(text(),'Absence management')]"));

		a.moveToElement(absence).click().build().perform();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Search by name or email']")).sendKeys("y");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		Thread.sleep(3000);

		driver.manage();

		driver.findElement(By.cssSelector("button.btn.btn-sm.btn-primary.float-right")).click();
		Thread.sleep(7000);

		isFileDownloaded(downloadPath);
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[@ng-show='generated']")).click();
		Thread.sleep(7000);

		Reader reader = Files.newBufferedReader(Paths.get(downloadPath + fileName));

		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

		for (int pageCount = 1; pageCount <= 5; pageCount++) {
			List<WebElement> results = driver.findElements(By.xpath("//tbody//tr//td"));
			List<TableRow> tableRows = new ArrayList<TableRow>();
			for(int j = 1; j <= results.size(); j++) {
				TableRow row = null;
				if(j==1 || (j%8==0)) {
					tableRows.add(row);
					row = new TableRow();
				} else {
					row.setEmployee(results.get(j).getText());
				}
				
			}
			
			//for (CSVRecord csvRecord : csvParser) {

				for (int i = 0; i < results.size(); i++) {
					System.out.println("results.get(i).getText()---------------->"+results.get(i).getText());
					//if (results.get(i).getText().equals(csvRecord.get(0))) {
						//System.out.println("results are similar");
					//}
				}
			//}
			if (pageCount < 5) {
				clickNext();
				Thread.sleep(4000);
			}
		}

	}

	public void isFileDownloaded(String downloadPath) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmss");
		Date date = new Date();
		String timestamp = dateFormat.format(date);
		File downloadedFile = new File(downloadPath + fileName);
		File downloadedFileBkp = new File(downloadPath + "absences_" + timestamp + ".csv");

		if (downloadedFile.exists()) {
			downloadedFile.renameTo(downloadedFileBkp);
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