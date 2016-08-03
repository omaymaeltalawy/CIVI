package civi.features.document;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import civi.crm.steps.DashboardSteps;
import civi.crm.steps.LoginSteps;

@RunWith(SerenityRunner.class)
public class AddDocumentTest {

	@Managed
	WebDriver driver;
	@Steps
	LoginSteps loginSteps;
	@Steps
	DashboardSteps dashboardSteps;
	
	@Test
	public void addDocumentTest()
	{
		loginSteps.login_page_is_opened();
		loginSteps.verifyPageLoaded();
		loginSteps.enter_login_credentials();
		dashboardSteps.page_is_loaded();
		dashboardSteps.documents_are_displayed();
		dashboardSteps.add_document();
		dashboardSteps.click_save();
		dashboardSteps.document_is_created();
	}
	
	@Test
	public void addDocumentWithSaveAndNewTest()
	{
		loginSteps.login_page_is_opened();
		loginSteps.verifyPageLoaded();
		loginSteps.enter_login_credentials();
		dashboardSteps.page_is_loaded();
		dashboardSteps.documents_are_displayed();
		dashboardSteps.add_document();
		dashboardSteps.click_save_and_new();
		dashboardSteps.close_without_saving();
		dashboardSteps.document_is_created();
	}
}
