package com.medbase.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverUtils {

	public static WebDriver driver;
	public static Properties prop;

	public static void initialize() throws IOException {
		prop = new Properties();
		String project = System.getProperty("user.dir", "chromedriver.exe");
		System.out.println(project);
		FileInputStream fis = new FileInputStream(project + "\\src\\test\\resources\\global.properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", project + "\\src\\test\\resources\\chromedriver.exe");
		
		String downloadFilepath = project+"\\downloadfolder";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();

		driver.get(prop.getProperty("URL"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void close() {
		driver.close();

	}
	
	public static Properties getprop()
	{
		return prop;
	}
	
	

}
