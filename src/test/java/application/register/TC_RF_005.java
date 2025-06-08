package application.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_RF_005 {
	@Test(priority=1)
	public void verifyNoOption() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Duc");
		driver.findElement(By.id("input-lastname")).sendKeys("Nguyen");
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateBrandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//label[@class = \"radio-inline\"][2]/input")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);
		
		String actualProperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String actualProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetailsFour = "contact us";
		
		//Continue button at step 6
		
		
		String expectedProperDetails = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		driver.findElement(By.xpath("//a[text()=\"Subscribe / unsubscribe to newsletter\"]")).click();
		String actualNewlettersSubscription = "Newsletter Subscription";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText(), actualNewlettersSubscription);
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value=\"0\"]")).isSelected());
	
		driver.quit();
	}
	
}
