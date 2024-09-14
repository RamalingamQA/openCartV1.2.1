package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class summa {
	@Test()
	public void log(){
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("pavanoltraining@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("test@12");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//boolean txt=driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed();
		String txt=driver.findElement(By.xpath("//h2[text()='My Account']")).getTagName();
		Assert.assertEquals(txt, "My Account");
	}

}
