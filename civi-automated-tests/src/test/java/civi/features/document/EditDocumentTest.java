package civi.features.document;

import java.util.HashMap;
import java.util.Map;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import civi.crm.steps.DashboardSteps;
import civi.crm.steps.LoginSteps;

@RunWith(SerenityRunner.class)
public class EditDocumentTest {

	@Managed
	WebDriver driver;
	@Steps
	LoginSteps loginSteps;
	@Steps
	DashboardSteps dashboardSteps;
	
	Map<String, String> data;
	
	@Test
	public void editDocumentTest()
	{
		loginSteps.login_page_is_opened();
		loginSteps.verifyPageLoaded();
		loginSteps.enter_login_credentials();
		dashboardSteps.page_is_loaded();
		dashboardSteps.documents_are_displayed();
		getData();
		dashboardSteps.edit_document(data);
		dashboardSteps.click_save();
		dashboardSteps.document_is_edited(data);
	}
	
	private void getData()
	{
		data = new HashMap<String, String>();
		data.put("NameOrEmail", "Flower");
		data.put("DocumentType", "Exiting document 3");
		data.put("File", "testFile.txt");
		data.put("Assignee", "Mr. Norris Cruz");
		data.put("Status", "awaiting approval");
		data.put("Details", "Needs to be Approved by manager");
	}
}
