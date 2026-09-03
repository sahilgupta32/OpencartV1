package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_confirm_password;
	@FindBy(xpath="//input[@name='agree']") WebElement chk_box_privacyPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement cnfm_message;

	public void setFirstName(String fname) {
		txt_firstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txt_lastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}

	public void setTelephone(String telephone) {
		txt_telephone.sendKeys(telephone);
	}

	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}

	public void setCnfmPassword(String pwd) {
		txt_confirm_password.sendKeys(pwd);
	}

	public void clickAgree() {
		chk_box_privacyPolicy.click();
	}

	public void clickContinue() {
		btn_continue.click();
		
		//btn_continue.submit();

		/*
		Actions act=new Actions(driver);
		act.moveToElement(btn_continue).click().build().perform();
		 */

		//btn_continue.sendKeys(Keys.RETURN);
		
		/*
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btn_continue);
		*/

	}

	public String getConfirmMessage() {
		try {
			return(cnfm_message.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}

	}

}
