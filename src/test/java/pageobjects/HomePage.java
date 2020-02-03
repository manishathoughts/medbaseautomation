package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.medbase.test.DriverUtils;

public class HomePage {

	WebDriver driver = DriverUtils.getDriver();

	By womanlink = By.cssSelector("a.sf-with-ul");

	By summerDresses = By.xpath("//a[text()='Summer Dresses']");

	By imageLink = By.cssSelector("img.replace-2x.img-responsive");

	By addToCart = By.xpath("//span[text()='Add to cart']");

	By proceedToCheckout = By.xpath("//a[@title='Proceed to checkout']");

	By signInLink = By.className("login");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement womanlink() {
		return driver.findElement(womanlink);
	}

	public WebElement summerDresses() {
		return driver.findElement(summerDresses);
	}

	public WebElement imageLink() {
		return driver.findElement(imageLink);
	}

	public WebElement addToCart() {
		return driver.findElement(addToCart);
	}

	public WebElement proceedToCheckout() {
		return driver.findElement(proceedToCheckout);
	}

	public WebElement signInLink() {
		return driver.findElement(signInLink);
	}

}
