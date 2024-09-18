package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	private static ThreadLocal<WebDriver> browser = new ThreadLocal<>();

	public static WebDriver getBrowser() {
		if (browser.get() == null) {
			io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
			browser.set(new ChromeDriver());
			browser.get().manage().window().maximize();
		}
		return browser.get();
	}

	public static void quitBrowser() {
		if (browser.get() != null) {
			browser.get().quit();
			browser.remove();
		}
	}
}