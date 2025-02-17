package de.retest.recheck.example;

import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;

class ExplicitChecksTest {

	RemoteWebDriver driver;
	Recheck re;

	@BeforeEach
	public void setup() {
		re = new RecheckImpl();
		driver =  new ChromeDriver();
	}

	@Test
	public void check() throws Exception {
		re.startTest();
		String url = Paths.get( "src/test/resources/demo-app.html" ).toUri().toURL().toString();
		driver.get(url);
		re.check(driver, "init");
		re.capTest();
	}

	@AfterEach
	public void tearDown() throws InterruptedException {
		driver.quit();
		re.cap();
	}
}
