package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.medbase.test.DriverUtils;

public class SignInPage {

	WebDriver driver = DriverUtils.getDriver();

	By emailLink = By.id("email");

	By password = By.id("passwd");

	By loginInLink = By.id("SubmitLogin");

	By userNameVerf = By.cssSelector("a.account");

	By noOfItemsVerf = By.className("ajax_cart_quantity");

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement emailLink() {
		return driver.findElement(emailLink);
	}

	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement loginInLink() {
		return driver.findElement(loginInLink);
	}

	public WebElement userNameVerf() {
		return driver.findElement(userNameVerf);
	}

	public WebElement noOfItemsVerf() {
		return driver.findElement(noOfItemsVerf);
	}
}
