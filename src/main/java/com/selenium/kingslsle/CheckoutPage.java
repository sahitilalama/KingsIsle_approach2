package com.selenium.kingslsle;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = Configuration.oneMonth)
	public WebElement oneMonth;

	@FindBy(xpath = Configuration.numberOfCrowns)
	public WebElement numberOfCrowns;

	@FindBy(xpath = Configuration.arcaneBuildersBundle)
	public WebElement arcaneBuildersBundle;

	@FindBy(xpath = Configuration.account)
	public WebElement account;

	@FindBy(xpath = Configuration.quantityPrepaid)
	public WebElement quantityPrepaid;

	@FindBy(xpath = Configuration.quantityCrowns)
	public WebElement quantityCrowns;

	@FindBy(xpath = Configuration.quantityBundles)
	public WebElement quantityBundles;

	@FindBy(xpath = Configuration.pricePrepaid)
	public WebElement pricePrepaid;

	@FindBy(xpath = Configuration.priceCrowns)
	public WebElement priceCrowns;

	@FindBy(xpath = Configuration.priceBundles)
	public WebElement priceBundles;

	@FindBy(xpath = Configuration.tax)
	public WebElement tax;

	@FindBy(xpath = Configuration.total)
	public WebElement total;

	public FinalCheckOut verifyPaymentInformation() {

		// Write the assert Statements.
		Assert.assertEquals("Gift Item: KI Prepaid 1 Month",
				driver.findElement(By.xpath(Configuration.oneMonth)).getText());
		
		Assert.assertEquals("Gift Item: 5000 Crowns",
				driver.findElement(By.xpath(Configuration.numberOfCrowns))
						.getText());

		Assert.assertEquals(
				"Gift Bundle: Arcane Builders Bundle  + show items",
				driver.findElement(By.xpath(Configuration.arcaneBuildersBundle))
						.getText());

		Assert.assertEquals("Gift Certificate",
				driver.findElement(By.xpath(Configuration.account)).getText());
		Assert.assertEquals("1",
				driver.findElement(By.xpath(Configuration.quantityPrepaid))
						.getText());

		Assert.assertEquals("5,000",
				driver.findElement(By.xpath(Configuration.quantityCrowns))
						.getText());

		Assert.assertEquals("1",
				driver.findElement(By.xpath(Configuration.quantityBundles))
						.getText());

		Assert.assertEquals("$9.95",
				driver.findElement(By.xpath(Configuration.pricePrepaid))
						.getText());

		Assert.assertEquals("$10.00",
				driver.findElement(By.xpath(Configuration.priceCrowns))
						.getText());

		Assert.assertEquals("$39.00",
				driver.findElement(By.xpath(Configuration.priceBundles))
						.getText());

		Assert.assertEquals("$0.00", driver.findElement(By.xpath(Configuration.tax))
				.getText());

		Assert.assertEquals("$58.95", driver
				.findElement(By.xpath(Configuration.total)).getText());

		return PageFactory.initElements(driver, FinalCheckOut.class);
	}

}
