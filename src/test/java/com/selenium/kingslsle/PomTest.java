package com.selenium.kingslsle;

import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class PomTest {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}
	
	GiftCertificatesPage gcp = PageFactory.initElements(driver,
			GiftCertificatesPage.class);
	SelectBundle gchp = PageFactory.initElements(driver, SelectBundle.class);
	PersonalizedMessagePage pmp = PageFactory.initElements(driver,
			PersonalizedMessagePage.class);
	CheckoutPage cop = PageFactory.initElements(driver, CheckoutPage.class);
	FinalCheckOut fco = PageFactory.initElements(driver, FinalCheckOut.class);

	@Test
	public void getCheckOutNavigationPage() throws URISyntaxException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Configuration.gamepage);
		driver.manage().window().maximize();

		// Sequence calling..
		GiftCardsPage giftCardsPage = PageFactory.initElements(driver,
				GiftCardsPage.class);
		GiftCertificatesPage gcp = giftCardsPage.getToGiftCardsPage();
		SelectBundle gchp = gcp.getToGiftCertificatesPage();
		PersonalizedMessagePage pmp = gchp.getToBundlePage();
		CheckoutPage cop = pmp.getToPersonalizedMessagePage();

		// Handle the popup.
		FinalCheckOut fco = cop.verifyPaymentInformation();

		// Print the completion of AutomationTest.
		fco.print();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
}
