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

public class TC_RF_007 {
	@Test(priority=1)
	public void verifyDiffirentWwayNavigateToRegisterPage() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Continue\"]")).click();
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.xpath("//div[@class='list-group']/a[text()='Register']")).click();
		
		
		String expectedHeading = "Register Account";
		String expectedFollowing = "If you already have an account with us, please login at the login page.";		
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText(), expectedHeading);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"content\"]/p")).getText(), expectedFollowing);
	
		driver.quit();
	}
	
}
