package stepdefinitions;

import java.io.IOException;

import com.medbase.test.DriverUtils;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before("@practical1")
	public void openbrowser() throws IOException {
		DriverUtils.initialize();
	}

	@After("@practical")
	public void closebrowser() {
		DriverUtils.close();
	}
}
