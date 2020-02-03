package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.medbase.test.DriverUtils;

public class LoggedInUsersPage {

	WebDriver driver = DriverUtils.getDriver();

	By inputemail = By.id("inputEmail");
	By inputpassword=By.id("inputPassword");
	By signInClick=By.xpath("//div[text()='Sign in']");
	By navigateLoggedinpage=By.xpath("//a[@data-original-title='My Account']");
	By workAddressDetails=By.cssSelector("input[ng-model*='account.BillingAddress']");
	By contactOptions=By.xpath("//tr[@ng-repeat='option in account.ContactOptions']");
	By message=By.cssSelector("button.btn.btn-primary.block-display");
	By alertMessage=By.cssSelector("div.alert.alert-danger.dark.ng-binding");
	By saveChangespassword=By.xpath("//input[@placeholder='Password']");
	By updateAccount=By.xpath("//div[@ng-if='showAlert']");

	public LoggedInUsersPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement inputemail() {
		return driver.findElement(inputemail);
	}
	
	
	public WebElement inputpassword() {
		return driver.findElement(inputpassword);
	}
	
	public WebElement signInClick() {
		return driver.findElement(signInClick);
	}
	
	public WebElement navigateLoggedinpage() {
		return driver.findElement(navigateLoggedinpage);
	}
	
	public List<WebElement> workAddressDetails() {
		return driver.findElements(workAddressDetails);
	}
	
	public List<WebElement> contactOptions() {
		return driver.findElements(contactOptions);
	}
	
	public WebElement message() {
		return driver.findElement(message);
	}
	
	public WebElement alertMessage() {
		return driver.findElement(alertMessage);
	}
	
	public WebElement saveChangespassword() {
		return driver.findElement(saveChangespassword);
	}
	
	public WebElement updateAccount() {
		return driver.findElement(updateAccount);
	}
	
	
}
