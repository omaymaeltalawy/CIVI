package civi.crm.steps;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import civi.civi_automated_tests.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.*;

public class LoginSteps extends ScenarioSteps{
	
	/**
	 * Created By Omayma Eltalawy 8/1/2016
	 */
	LoginPage loginPage;
	
	public static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
		
	@Step
	public void enter_login_credentials()
	{
		loginPage.login();
	}
	
	@Step
	public void login_page_is_opened()
	{
		loginPage.open();		
	}

	@Step
	public void verifyPageLoaded() {
       assertTrue(loginPage.verifyPageLoaded());
    }
}
