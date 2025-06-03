package application.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_RF_004 {

		// TODO Auto-generated method stub
		@Test(priority=1)
		public void verifyWarningWhenDoNotProvideAnything() throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.id("input-confirm")).sendKeys("123");
			driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
			
			
			String firstName = "First Name must be between 1 and 32 characters!";
			String lastName = "Last Name must be between 1 and 32 characters!";
			String email = "E-Mail Address does not appear to be valid!";
			String telephone = "Telephone must be between 3 and 32 characters!";
			String password = "Password must be between 4 and 20 characters!"; 
			String confirmPassword = "Password confirmation does not match password!";
			String warning = "Warning: You must agree to the Privacy Policy!";
			
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,\"alert-danger\")]")).getText(), warning);	
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(),firstName);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText(),lastName);			
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText(),email);			
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText(),telephone);			
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText(),password);			
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Password confirmation does not match password!')]")).getText(),confirmPassword);
			 
			Thread.sleep(5);
			
			driver.quit();
			
		
	}

}
