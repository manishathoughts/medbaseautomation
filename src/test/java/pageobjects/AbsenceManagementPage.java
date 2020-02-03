package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.medbase.test.DriverUtils;

public class AbsenceManagementPage {
	WebDriver driver = DriverUtils.getDriver();

	By mireports = By.xpath("//span[contains(text(),'MI reports')]");
	
	public AbsenceManagementPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement mireports() {
		return driver.findElement(mireports);
	}
}
