package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageobjects.AbsenceManagementPage;
import pageobjects.AbsenceOverviewPage;
import pageobjects.LoggedInUsersPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.medbase.test.ClickNextTest;
import com.medbase.test.DriverUtils;

import context.ScenarioContext;

@RunWith(Cucumber.class)
public class StepDefinition {

	private static Logger log = LogManager.getLogger(StepDefinition.class.getName());

	Properties prop = DriverUtils.getprop();

	WebDriver driver = DriverUtils.getDriver();
	LoggedInUsersPage lp = new LoggedInUsersPage(driver);
	AbsenceOverviewPage ap = new AbsenceOverviewPage(driver);
	AbsenceManagementPage amp = new AbsenceManagementPage(driver);
	ScenarioContext scenarioContext = new ScenarioContext();

	ArrayList<String> inclusionlist = new ArrayList<String>();
	ArrayList<String> exclusionlist = new ArrayList<String>();

	Map<String, Integer> lastNamesInPage = new HashMap<String, Integer>();
	Map<String, ArrayList> firstNamesInPage = new HashMap<String, ArrayList>();

	@Given("^I have navigated to the AUT$")
	public void i_have_navigated_to_the_aut() throws Throwable {
//    	DriverUtils.initialize();
		DriverUtils.getDriver().get(prop.getProperty("URL"));

	}

	@Given("^I log in with valid Credentilas$")
	public void i_log_in_with_valid_EMAIL_and_PASSWORD(DataTable data) throws Throwable {

		List<List<String>> obj = data.raw();
		lp.inputemail().sendKeys(obj.get(0).get(0));
		lp.inputpassword().sendKeys(obj.get(0).get(1));

		scenarioContext.getContext().put("password", obj.get(0).get(1));
		lp.signInClick().click();
		Thread.sleep(3000);

	}

	@When("^I navigate to the Logged-In-User's Profile page$")
	public void i_navigate_to_the_Logged_In_User_s_Profile_page() throws Throwable {

		lp.navigateLoggedinpage().click();
		Thread.sleep(5000);

	}

	@And("^I update the work address details$")
	public void i_update_the_work_address_details(DataTable data) throws Throwable {
		List<List<String>> obj = data.raw();
		List<WebElement> workAddress = lp.workAddressDetails();

		// HashMap<String, Object> context = new HashMap<String, Object>();
		workAddress.get(0).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), obj.get(0).get(0));

		workAddress.get(1).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), obj.get(0).get(1));

		workAddress.get(2).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), obj.get(0).get(2));

		workAddress.get(3).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), obj.get(0).get(3));

		workAddress.get(4).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), obj.get(0).get(4));

		Thread.sleep(3000);

	}

	@And("^I update the (.+) by (.+)$")
	public void i_update_the_by(String contactoption, String options) throws Throwable {
		WebDriver driver = DriverUtils.getDriver();
		Actions actions = new Actions(driver);
		List<WebElement> table = lp.contactOptions();
		Thread.sleep(3000);

		for (int i = 0; i < table.size(); i++) {
			String allContactOptions = table.get(i).getText();
			// System.out.println(allContactOptions);

			Thread.sleep(3000);

			if (contactoption.equalsIgnoreCase(prop.getProperty("option1")))// General
			{
				if (contactoption.equalsIgnoreCase(allContactOptions)) {
					if (prop.getProperty("Contact-option1").equalsIgnoreCase(options))// for Email
					{
						WebElement Email = driver.findElements(By.xpath("//input[@ng-model='option.Email']")).get(0);

						actions.moveToElement(Email).click().build().perform();
					} else if (prop.getProperty("Contact-option2").equalsIgnoreCase(options))// SMS
					{
						WebElement SMS = driver.findElements(By.xpath("//input[@ng-model='option.SMS']")).get(0);
						actions.moveToElement(SMS).click().build().perform();
					}

					else if (prop.getProperty("Contact-option3").equalsIgnoreCase(options))// both
					{
						WebElement Email = driver.findElements(By.xpath("//input[@ng-model='option.Email']")).get(0);

						actions.moveToElement(Email).click().build().perform();

						WebElement SMS = driver.findElements(By.xpath("//input[@ng-model='option.SMS']")).get(0);
						actions.moveToElement(SMS).click().build().perform();
					}
				}
			} else if (contactoption.equalsIgnoreCase(prop.getProperty("option2")))// refereral
			{
				if (contactoption.equalsIgnoreCase(allContactOptions)) {
					if (prop.getProperty("Contact-option1").equalsIgnoreCase(options))// for Email
					{
						WebElement Email = driver.findElements(By.xpath("//input[@ng-model='option.Email']")).get(1);

						actions.moveToElement(Email).click().build().perform();
					} else if (prop.getProperty("Contact-option2").equalsIgnoreCase(options))// SMS
					{
						WebElement SMS = driver.findElements(By.xpath("//input[@ng-model='option.SMS']")).get(1);
						actions.moveToElement(SMS).click().build().perform();
					}

					else if (prop.getProperty("Contact-option3").equalsIgnoreCase(options))// both
					{
						WebElement Email = driver.findElements(By.xpath("//input[@ng-model='option.Email']")).get(1);

						actions.moveToElement(Email).click().build().perform();

						WebElement SMS = driver.findElements(By.xpath("//input[@ng-model='option.SMS']")).get(1);
						actions.moveToElement(SMS).click().build().perform();
					}
				}
			} else if (contactoption.equalsIgnoreCase(prop.getProperty("option3"))) {
				if (contactoption.equalsIgnoreCase(allContactOptions)) {
					if (prop.getProperty("Contact-option1").equalsIgnoreCase(options))// for Email
					{
						WebElement Email = driver.findElements(By.xpath("//input[@ng-model='option.Email']")).get(2);

						actions.moveToElement(Email).click().build().perform();
					} else if (prop.getProperty("Contact-option2").equalsIgnoreCase(options))// SMS
					{
						WebElement SMS = driver.findElements(By.xpath("//input[@ng-model='option.SMS']")).get(2);
						actions.moveToElement(SMS).click().build().perform();
					}

					else if (prop.getProperty("Contact-option3").equalsIgnoreCase(options))// both
					{
						WebElement Email = driver.findElements(By.xpath("//input[@ng-model='option.Email']")).get(2);

						actions.moveToElement(Email).click().build().perform();

						WebElement SMS = driver.findElements(By.xpath("//input[@ng-model='option.SMS']")).get(2);
						actions.moveToElement(SMS).click().build().perform();
					}
				}
			} else if (contactoption.equalsIgnoreCase(prop.getProperty("option4"))) {

				List<WebElement> Email = driver.findElements(By.xpath("//input[@ng-model='option.Email']"));
				List<WebElement> SMS = driver.findElements(By.xpath("//input[@ng-model='option.SMS']"));

				if (prop.getProperty("Contact-option1").equalsIgnoreCase(options))// for Email
				{

					for (int j = 0; j < Email.size() - 1; j++) {
						// System.out.println(Email.size());
						actions.moveToElement(Email.get(j)).click().build().perform();
					}
				} else if (prop.getProperty("Contact-option2").equalsIgnoreCase(options))// SMS
				{

					for (int k = 0; k < SMS.size() - 1; k++) {
						actions.moveToElement(SMS.get(k)).click().build().perform();
					}
				}

			}
		}

	}

	@Then("^My changes should have successfully applied$")
	public void my_changes_should_have_successfully_applied() throws Throwable {
		WebDriver driver = DriverUtils.getDriver();

		Thread.sleep(2000);

		// System.out.println(driver.findElement(By.xpath("//div[@ng-if='showAlert']")).getText());

		assertEquals(prop.getProperty("Account-Update-Verify-message"), lp.updateAccount().getText());

	}

	@And("^I confirm that an error occurs upon attempting to save without populating the required fields$")
	public void i_confirm_that_an_error_occurs_upon_attempting_to_save_without_populating_the_required_fields()
			throws Throwable {

		WebDriver driver = DriverUtils.getDriver();

		lp.message().click();
		Thread.sleep(3000);

		// System.out.println(driver.findElement(By.cssSelector("div.alert.alert-danger.dark.ng-binding")).getText());
		assertEquals(prop.getProperty("Error-message"), lp.alertMessage().getText());
	}

	@And("^I save the changes$")
	public void i_save_the_changes() throws Throwable {
		WebDriver driver = DriverUtils.getDriver();

		lp.saveChangespassword().sendKeys(scenarioContext.getContext().get("password").toString());
		lp.message().click();
		Thread.sleep(3000);
	}

	@When("^I navigate to the Absence Overview page$")
	public void i_navigate_to_the_Absence_Overview_page() throws Throwable {
		WebDriver driver = DriverUtils.getDriver();
		Actions actions = new Actions(driver);
		actions.moveToElement(ap.mireports()).click().build().perform();
		ap.absenceOverpage().click();
	}

	@When("^I set the time window$")
	public void i_set_the_time_window(DataTable arg1) throws Throwable {
		WebDriver driver = DriverUtils.getDriver();
		List<List<String>> obj = arg1.raw();
		List<WebElement> date = ap.updateDate();
		for (int i = 0; i < date.size(); i++) {

			date.get(i).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), obj.get(1).get(0));

			if (i == 1) {
				date.get(i).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), obj.get(1).get(1));
			}
		}

		Thread.sleep(1000);

	}

	@When("^I update the data$")
	public void i_update_the_data() throws Throwable {
		WebDriver driver = DriverUtils.getDriver();

		driver.findElement(By.cssSelector("button.btn.btn-primary.pull-right")).click();

		Thread.sleep(5000);
	}

	@Then("^The employee surnames on the first 5 pages should include \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\", but not \"([^\"]*)\" or \"([^\"]*)\"$")
	public void the_employee_surnames_on_the_first_5_pages_should_include_something_something_and_something_but_not_something_or_something(
			String strArg1, String strArg2, String strArg3, String strArg4, String strArg5) throws Throwable {

		inclusionlist.add(strArg1);
		inclusionlist.add(strArg2);
		inclusionlist.add(strArg3);

		exclusionlist.add(strArg4);
		exclusionlist.add(strArg5);

		WebDriver driver = DriverUtils.getDriver();
		ClickNextTest cn = new ClickNextTest();
		for (int pageCount = 1; pageCount <= 5; pageCount++) {

			System.out.println("Page no:----------------------------------> " + pageCount);
			List<WebElement> employeeSurName = ap.employeeSurName();
			Thread.sleep(3000);

			for (WebElement e : employeeSurName) {

				System.out.println(e.getText());
				if (lastNamesInPage.containsKey(e.getText().toUpperCase())) {
					lastNamesInPage.put(e.getText().toUpperCase(), lastNamesInPage.get(e.getText().toUpperCase()) + 1);
				} else {
					lastNamesInPage.put(e.getText().toUpperCase(), 1);
				}
			}

			// lastNamesInPage.clear();
			if (pageCount < 5) {
				cn.clickNext();
				Thread.sleep(3000);
			}
		}
	}

	@And("^Print the number of occurrences to the browser console$")
	public void print_the_number_of_occurrences_to_the_browser_console() throws Throwable {

		System.out.println("Last names in page:-------------------->" + lastNamesInPage);
		for (String inclusionName : inclusionlist) {
			System.out.println("inclusionName: " + inclusionName + " lastNamesInPage size: " + lastNamesInPage.size());
			assertTrue(lastNamesInPage.containsKey(inclusionName.toUpperCase()));
			System.out.println(inclusionName + ": " + lastNamesInPage.get(inclusionName.toUpperCase()));
			log.info(inclusionName + ": " + lastNamesInPage.get(inclusionName.toUpperCase()));
		}
		for (String exclusionName : exclusionlist) {
			assertFalse(lastNamesInPage.containsKey(exclusionName.toUpperCase()));
		}

	}

}