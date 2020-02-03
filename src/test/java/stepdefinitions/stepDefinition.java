package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Properties;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.medbase.test.DriverUtils;

import context.ScenarioContext;

@RunWith(Cucumber.class)
public class stepDefinition {

	private static Logger log = LogManager.getLogger(stepDefinition.class.getName());

	Properties prop = DriverUtils.getprop();

	ScenarioContext scenarioContext = new ScenarioContext();

	@Given("^I have navigated to the AUT$")
	public void i_have_navigated_to_the_aut() throws Throwable {
//    	DriverUtils.initialize();
		DriverUtils.getDriver().get(prop.getProperty("URL"));

	}

	@Given("^I log in with valid Credentilas$")
	public void i_log_in_with_valid_EMAIL_and_PASSWORD(DataTable data) throws Throwable {

		WebDriver driver = DriverUtils.getDriver();

		List<List<String>> obj = data.raw();
		driver.findElement(By.id("inputEmail")).sendKeys(obj.get(0).get(0));
		driver.findElement(By.id("inputPassword")).sendKeys(obj.get(0).get(1));

		scenarioContext.getContext().put("password", obj.get(0).get(1));
		driver.findElement(By.xpath("//div[text()='Sign in']")).click();
		Thread.sleep(3000);

	}

	@When("^I navigate to the Logged-In-User's Profile page$")
	public void i_navigate_to_the_Logged_In_User_s_Profile_page() throws Throwable {
		DriverUtils.getDriver().findElement(By.xpath("//a[@data-original-title='My Account']")).click();
		Thread.sleep(5000);

	}

	@And("^I update the work address details$")
	public void i_update_the_work_address_details(DataTable data) throws Throwable {
		List<List<String>> obj = data.raw();

		List<WebElement> workAddress = DriverUtils.getDriver()
				.findElements(By.cssSelector("input[ng-model*='account.BillingAddress']"));

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

		List<WebElement> table = driver.findElements(By.xpath("//tr[@ng-repeat='option in account.ContactOptions']"));
		Thread.sleep(3000);

		for (int i = 0; i < table.size(); i++) {
			String allContactOptions = table.get(i).getText();
			System.out.println(allContactOptions);

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
			}
			else if (contactoption.equalsIgnoreCase(prop.getProperty("option4"))) {
				
				List<WebElement> Email = driver.findElements(By.xpath("//input[@ng-model='option.Email']"));
				List<WebElement> SMS = driver.findElements(By.xpath("//input[@ng-model='option.SMS']"));
				
					if (prop.getProperty("Contact-option1").equalsIgnoreCase(options))// for Email
					{
						
                      for(int j=0; j<Email.size()-1;j++)
                      {
                    	 // System.out.println(Email.size());
						actions.moveToElement(Email.get(j)).click().build().perform();
                      }
					} else if (prop.getProperty("Contact-option2").equalsIgnoreCase(options))// SMS
					{
						
						 for(int k=0; k<SMS.size()-1;k++)
	                      {
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

		System.out.println(driver.findElement(By.xpath("//div[@ng-if='showAlert']")).getText());

		assertEquals(prop.getProperty("Account-Update-Verify-message"),
				driver.findElement(By.xpath("//div[@ng-if='showAlert']")).getText());

	}

	@And("^I confirm that an error occurs upon attempting to save without populating the required fields$")
	public void i_confirm_that_an_error_occurs_upon_attempting_to_save_without_populating_the_required_fields()
			throws Throwable {

		WebDriver driver = DriverUtils.getDriver();

		driver.findElement(By.cssSelector("button.btn.btn-primary.block-display")).click();
		Thread.sleep(3000);

		System.out.println(driver.findElement(By.cssSelector("div.alert.alert-danger.dark.ng-binding")).getText());
		assertEquals(prop.getProperty("Error-message"),
				driver.findElement(By.cssSelector("div.alert.alert-danger.dark.ng-binding")).getText());
	}

	@And("^I save the changes$")
	public void i_save_the_changes() throws Throwable {
		WebDriver driver = DriverUtils.getDriver();

		driver.findElement(By.xpath("//input[@placeholder='Password']"))
				.sendKeys(scenarioContext.getContext().get("password").toString());
		driver.findElement(By.cssSelector("button.btn.btn-primary.block-display")).click();
		Thread.sleep(3000);
	}
	
	@When("^I navigate to the Absence Overview page$")
	public void i_navigate_to_the_Absence_Overview_page() throws Throwable {
	   
	   
	}
	
	@When("^I set the time window$")
	public void i_set_the_time_window(DataTable arg1) throws Throwable {
	  
	}
	
	@When("^I update the data$")
	public void i_update_the_data() throws Throwable {
	    
	}
	 @Then("^The employee surnames on the first 5 pages should include \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\", but not \"([^\"]*)\" or \"([^\"]*)\"$")
	    public void the_employee_surnames_on_the_first_5_pages_should_include_something_something_and_something_but_not_something_or_something(String strArg1, String strArg2, String strArg3, String strArg4, String strArg5) throws Throwable {
	       
	    }
	 @And("^Print the number of occurrences to the browser console$")
	    public void print_the_number_of_occurrences_to_the_browser_console() throws Throwable {
	        
	    }

}