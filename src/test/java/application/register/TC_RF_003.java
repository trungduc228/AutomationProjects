package application.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_RF_003 {

		// TODO Auto-generated method stub
		@Test(priority=1)
		public void verifyRegisteringWithAllFields() throws InterruptedException {
			
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
			driver.findElement(By.name("agree")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
			Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
			
			String expectedHeading = "Your Account Has Been Created!";
			
			Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);
			
			String actualProperDetailsOne = "Congratulations! Your new account has been successfully created!";
			String actualProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
			String actualProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
			String actualProperDetailsFour = "contact us";
			
			String expectedProperDetails = driver.findElement(By.id("content")).getText();
			
			Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
			Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
			Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
			Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));
			
			driver.findElement(By.xpath("//a[text()='Continue']")).click();
			
			String actualChangePassword = "Change your password";
			String actualOrderHistory = "View your order history";
			String actualMyAffiliateAccount = "Register for an affiliate account";
			
			Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.linkText("Change your password")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.linkText("View your order history")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.linkText("Register for an affiliate account")).isDisplayed());
			
			Thread.sleep(5000); 
			
			driver.quit();
			
		
	}

}
