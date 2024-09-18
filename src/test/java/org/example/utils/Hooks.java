package org.example.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void setUp() {
		WebDriverManager.getBrowser().manage().deleteAllCookies();
	}

	@After
	public void tearDown() {
		WebDriverManager.quitBrowser();
	}
}