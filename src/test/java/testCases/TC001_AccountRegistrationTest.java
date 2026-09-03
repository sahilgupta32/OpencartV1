package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	@Test(groups={"Regression", "Master"})
	public void verify_account_registration() 
	{
		logger.info("**** Starting TC001_AccountRegistrationTest ****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");

		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer Details");
		arp.setFirstName(randomString().toUpperCase());
		arp.setLastName(randomString().toUpperCase());
		arp.setEmail(randomString()+"@opencart.com");
		arp.setTelephone(randomNumber());

		String password=randomAplhaNumeric();
		arp.setPassword(password);
		arp.setCnfmPassword(password);
		arp.clickAgree();
		arp.clickContinue();

		logger.info("Validating Expected Message");
		String confmsg=arp.getConfirmMessage();
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!");
		}
		catch(Exception e) {			
			Assert.fail();
		}
		
		logger.info("**** Finished TC001_AccountRegistrationTest ****");
		
	}
	

}