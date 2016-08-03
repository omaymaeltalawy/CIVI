package civi.civi_automated_tests;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import civi.constants.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/welcome-page")
public class LoginPage extends PageObject{

	@FindBy(id="edit-name")
	private WebElementFacade usernameField;

	@FindBy(id="edit-pass")
	private WebElementFacade passwordField;
	
	@FindBy(id="edit-submit")
	private WebElementFacade loginButton;

	public static final Logger logger = LoggerFactory.getLogger(GetClassLoader.class);
	
	public void login()
	{
		logger.info("Enter username: "+ Constants.civiCRMUserName);
		usernameField.type(Constants.civiCRMUserName);
		
		logger.info("Enter password");
		passwordField.type(Constants.civiCRMPassword);
		
		logger.info("Click \"Login\"");
		loginButton.click();
	}
	
	public void validateDashboard()
	{
		logger.info("Enter username: "+ Constants.civiCRMUserName);
		
	}
	
	public boolean verifyPageLoaded() {
        return (new WebDriverWait(getDriver(), 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains("Don't have a login");
            }
        });
    }
	
}
