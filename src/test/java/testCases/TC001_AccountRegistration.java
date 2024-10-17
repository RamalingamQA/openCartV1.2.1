package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import testBase.BaseClass2;

public class TC001_AccountRegistration extends BaseClass2 {
	@Test(groups= {"Sanity","Master"})
	public void registration() throws InterruptedException {
		try {
			//logger.info("----Home Page----");
			HomePage hp=new HomePage(driver);
			Thread.sleep(2000);
			hp.accountBtn();
			Thread.sleep(2000);
			hp.registerBtn();
			//logger.info("----Registration Page----");
			RegistrationPage rp=new RegistrationPage(driver);
			rp.firstNametxt(randomString());
			rp.lastNametxt(randomString());
			rp.emailtxt(randomString()+"@gmail.com");
			rp.telePhonetxt(randomNumber());
			String password=randomAlphaNumber();
			rp.passWordtxt(password);
			rp.confirmPasswordtxt(password);
			rp.agreeBtn();
			rp.submitBtn();
			Thread.sleep(2000);
			String message=rp.successMsg();
			if(message.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else {
				//logger.info("---it is failing---");
				//logger.error("error");
				//logger.debug("debug");
				Assert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
		
	


