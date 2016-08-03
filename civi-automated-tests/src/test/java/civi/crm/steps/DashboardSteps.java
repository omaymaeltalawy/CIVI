package civi.crm.steps;

import java.util.Map;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import civi.civi_automated_tests.DashboardPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.junit.Assert.*;

public class DashboardSteps extends ScenarioSteps{
	
	/**
	 * Created By Omayma Eltalawy 8/1/2016
	 */
	private static final long serialVersionUID = 1L;
	DashboardPage dashboardPage;
	
	public static final Logger logger = LoggerFactory.getLogger(GetClassLoader.class);
	
	
	@Step
	public void page_is_loaded() {
		assertTrue(dashboardPage.verifyPageUrl());
    }
	@Step
	public void documents_are_displayed()
	{
		dashboardPage.clickDocuments();
	}
	@Step
	public void click_save() {
		dashboardPage.clickSave();
	}
	@Step
	public void click_save_and_new() {
		dashboardPage.clickSaveAndNew();
	}
	@Step
	public void add_document() {
		dashboardPage.clickAddDocument();
		assertTrue(dashboardPage.verifyDocumentDialogLoaded());
		dashboardPage.addDocument();
	}

	@Step
	public void document_is_created()
	{
		assertTrue(dashboardPage.validateDocumentCreated());
	}
	@Step
	public void edit_document(Map<String,String> data)
	{
		dashboardPage.clickEditDocument();
		assertTrue(dashboardPage.verifyDocumentDialogLoaded());
		dashboardPage.editDocument(data);
	}

	@Step
	public void document_is_edited(Map<String,String> data)
	{
		dashboardPage.clickEditDocument();
		assertTrue(dashboardPage.verifyDocumentDialogLoaded());
		dashboardPage.verifyDocumentIsEdited(data);
	}
	@Step
	public void close_without_saving()
	{
		dashboardPage.cancelChanges(true);
		assertTrue(dashboardPage.addDocumentDialogIsClosed());
	}
	
	@Step
	public void close_with_saving()
	{
		dashboardPage.cancelChanges(false);
		assertTrue(dashboardPage.addDocumentDialogIsClosed());
	}
}
