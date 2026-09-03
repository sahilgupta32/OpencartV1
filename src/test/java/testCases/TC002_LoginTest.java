package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity", "Master"})
	public void verify_login() 
	{
		logger.info("**** Starting TC002_LoginTest ****");
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPwd(p.getProperty("password"));
			lp.btnLogin();

			MyAccountPage maccp=new MyAccountPage(driver);
			boolean targetPage=maccp.isMyAccountPageExist();
			Assert.assertTrue(targetPage);
			maccp.clickLogout();
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC002_LoginTest ****");
		
	} 

}