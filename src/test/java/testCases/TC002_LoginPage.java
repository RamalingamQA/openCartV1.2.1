package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccount;
import pageObjects.loginPage;
import testBase.BaseClass;
import testBase.BaseClass2;

public class TC002_LoginPage extends BaseClass2{
	
	@Test(groups= {"Regression","Master"})
	public void login() throws InterruptedException {
		//logger.info("----Execution Started-----");
		HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
		hp.accountBtn();
		hp.loginBtn();
		loginPage lg=new loginPage(driver);
		Thread.sleep(2000);
		//lg.userNametxt("merssal");
		lg.userNametxt(p.getProperty("email"));
		lg.passwordtxt(p.getProperty("password"));
		lg.loginBtn();
		Thread.sleep(2000);
		MyAccount acc=new MyAccount(driver);
		if(acc.myAccountTitle()==true) {
			Assert.assertTrue(true);
		}
		else {
			//logger.error("err message");
			//logger.debug("debug msg");
			Assert.fail();
		}
		
		
	}
}
