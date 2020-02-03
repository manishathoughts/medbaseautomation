package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.medbase.test.DriverUtils;

public class AbsenceOverviewPage {
	
	WebDriver driver = DriverUtils.getDriver();

	By mireports = By.xpath("//span[contains(text(),'MI reports')]");
	
	By absenceOverpage=By.xpath("//td[text()='Absence Overview']");
	
	By updateDate=By.xpath("//input[@name='date']");
	
	By employeeSurName=By.xpath("//tbody//tr//td[17]");
	
	public AbsenceOverviewPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement mireports() {
		return driver.findElement(mireports);
	}
	
	public WebElement absenceOverpage() {
		return driver.findElement(absenceOverpage);
	}
	
	public List<WebElement> updateDate() {
		return driver.findElements(updateDate);
	}
	
	public List<WebElement> employeeSurName() {
		return driver.findElements(employeeSurName);
	}

}
