package civi.civi_automated_tests;

import org.junit.Assert.*;

import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DashboardPage extends PageObject{

	@FindBy(linkText="Documents")
	private WebElementFacade documentsLink;
	
	@FindBy(xpath=".//*[@id='ct-dashboard']/div[1]/div/div[2]/div/a[1]")
	private WebElementFacade addDocumentLink;
	
	@FindBy(xpath=(".//*[@id='civitasks']/div/div[1]/div/div/form/div[1]/div/div[1]/div/div/span"))
	private WebElementFacade nameOrEmailField;
	
	@FindBy(xpath=("//input[@type='text']"))
	private WebElementFacade nameOrEmailTextField;
	
	@FindBy(css=("div.ng-binding.ng-scope"))
	private WebElementFacade nameOrEmailDropDownField;

	@FindBy(xpath=(".//*[@id='civitasks']/div/div[1]/div/div/form/div[2]/div/div[1]/div/div/select"))
	private WebElementFacade documentTypeField;

	@FindBy(id="ct-document-due")
	private WebElementFacade dueDate;

	@FindBy(id="ct-document-exp")
	private WebElementFacade expiryDate;
	
	@FindBy(xpath=".//*[@id='civitasks']/div/div[1]/div/div/form/div[3]/button[3]")
	private WebElementFacade saveButton;
	
	@FindBy(xpath=".//*[@id='civitasks']/div/div[1]/div/div/form/div[3]/button[2]")
	private WebElementFacade saveAndNewButton;
	
	@FindBy(xpath=".//*[@id='civitasks']/div/div[1]/div/div/form/div[2]/div/div[5]/div/span")
	private WebElementFacade showMoreLink;
	
	@FindBy(xpath=".//*[@id='civitasks']/div/div[1]/div/div/form/div[2]/div/div[6]/div[2]/div/div[2]/div[3]")
	private WebElementFacade detailsTextField;
	
	@FindBy(id="ct-document-files")
	private WebElementFacade dropFileLink;
	
	@FindBy(linkText="Add Assignee")
	private WebElementFacade addAssigneeLink;
	
	@FindBy(xpath=".//*[@id='civitasks']/div/div[1]/div/div/form/div[2]/div/div[4]/div[3]/span/a")
	private WebElementFacade addToAssignmentLink;
	

	@FindBy(xpath=".//*[@id='civitasks']/div/div[1]/div/div/form/div[2]/div/div[4]/div[2]/div/div/span")
			
	private WebElementFacade assigneeNameOrEmailField;
	
	@FindBy(xpath=".//*[@id='civitasks']/div/div[1]/div/div/form/div[2]/div/div[4]/div[2]/div/input[1]")
	private WebElementFacade assigneeNameOrEmailTextField;
	
	@FindBy(css=(".ui-select-choices-row-inner"))
	private WebElementFacade assigneeNameOrEmailDropDownField;
	
	@FindBy(xpath=".//*[@id='crm-notification-container']/div/a")
	private WebElementFacade popupCloseButton;
	
	@FindBy(xpath="//div[@id='ct-dashboard']/div[2]/div/div/div/div/div/div/div[2]/div/ul/li[2]/a")
	private WebElementFacade dueTodayLink;
	
	@FindBy(xpath=".//*[@id='ct-dashboard']/div[2]/div/div/div/div/div[2]/div/div[2]/table/tbody/tr")
	private List<WebElementFacade> tableRows;
	
	@FindBy(css=".panel-title.ng-binding")
	private WebElementFacade viewDocumentByTitle;
	
	@FindBy(css="button.close")
	private WebElementFacade addDocumentCloseButton;
	
	@FindBy(xpath=".//*[@id='civitasks']/div/div[1]/div/div/div[3]/button[2]")
	private WebElementFacade saveConfirmationYesButton;
	
	@FindBy(xpath=".//*[@id='civitasks']/div/div[1]/div/div/div[3]/button[1]")
	private WebElementFacade saveConfirmationNoButton;
	
	@FindBy(xpath=".//*[@id='civitasks']/div/div[1]/div/div/form/div[2]/div/div[3]/div[2]/table/tbody/tr")
	private List<WebElementFacade> filesAdded;
	
	@FindBy(xpath=".//*[@id='civitasks']/div/div[1]/div/div/form/div[2]/div/div[6]/div[1]/div/select")
	private WebElementFacade statusField;
	
	@FindBy(css=".fa.fa-ellipsis-v")
	private WebElementFacade moreButton;

	@FindBy(linkText="Edit")
	private WebElementFacade editLink;	
	
	public static final Logger logger = LoggerFactory.getLogger(GetClassLoader.class);
	private static final String nameOrEmailData = "Emoka DADAM";
	private static final String DocumentTypeData = "Joining Document 1";
	private static final String assigneeData = "Mr. Craig Prentice II";
	//private static final String nameOrEmailData = "Emoka DADAM";
	//private static final String nameOrEmailData = "Emoka DADAM";
	
	public Boolean verifyPageUrl() {
		logger.info("Verify page url");
        return (new WebDriverWait(getDriver(), 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains("dashboard");
            }
        });
    }
	
	public void clickDocuments()
	{
		logger.info("Click on \"Documents\"");
		documentsLink.waitUntilClickable();
		closePopup();
		documentsLink.click();
	}
	
	public void clickAddDocument()
	{
		waitForAddDocumentToAppear();
		addDocumentLink.click();
	}

	private void waitForAddDocumentToAppear() {
		logger.info("Click on \"Add Document\"");
		(new WebDriverWait(getDriver(), 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains("Add Document");
            }
        });
	}
	
	public void clickEditDocument()
	{
		waitForAddDocumentToAppear();
		moreButton.waitUntilClickable();
		moreButton.click();
		editLink.waitUntilClickable();
		editLink.click();
	}
	
	public void addDocument()
	{
		setNameOrEmailField(nameOrEmailData);		
		setDocumentTypeField(DocumentTypeData);
		setDatesField();		
		logger.info("Click \"Add Assignee\"");
		addAssigneeLink.click();	
		setAssigneeField(assigneeData);
	}

	private void setDatesField() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dueDate.type(dateFormat.format(new Date()));

		expiryDate.type(addDays(14));
	}

	private void setDocumentTypeField(String DocumentTypeData) {
		Select documentTypeSelectField = new Select(documentTypeField);
		documentTypeSelectField.selectByVisibleText(DocumentTypeData);
	}

	private void setNameOrEmailField(String nameOrEmailData) {
		nameOrEmailField.waitUntilVisible();
		nameOrEmailField.click();
		nameOrEmailTextField.click();
		nameOrEmailTextField.type(nameOrEmailData);
		nameOrEmailDropDownField.waitUntilVisible();
		nameOrEmailTextField.sendKeys(Keys.ENTER);
	}
	
	public void editDocument(Map<String, String> data)
	{
		setNameOrEmailField(data.get("NameOrEmail"));
		setDocumentTypeField(data.get("DocumentType"));
		//setDatesField();		
		setAssigneeField(data.get("Assignee"));
		showMoreLink.click();
		setDetailsField(data.get("Details"));
		setStatus(data.get("Status"));
	}
	
	public void verifyDocumentIsEdited(Map<String, String> data)
	{
		
		logger.info("data.get"+data.get("DocumentType"));
		assert(verifyNameOrEmailField(data.get("NameOrEmail")));
		assert(verifyDocumentTypeField(data.get("DocumentType")));
		assert(verifyAssigneeField(data.get("Assignee")));
		showMoreLink.click();
		assert(verifyDetailsField(data.get("Details")));
		assert(verifyStatus(data.get("Status")));
	}

	private boolean verifyStatus(String statusData) {
		return statusField.getSelectedVisibleTextValue().equals(statusData);
		
	}

	private boolean verifyDetailsField(String detailsData) {
		// TODO Auto-generated method stub
		return detailsTextField.getText().equals(detailsData);
	}

	private boolean verifyAssigneeField(String assigneeData) {
		// TODO Auto-generated method stub
		return assigneeNameOrEmailField.getText().equals(assigneeData);
	}

	private boolean verifyDocumentTypeField(String documentTypeData) {
		// TODO Auto-generated method stub
		return documentTypeField.getSelectedVisibleTextValue().equals(documentTypeData);
	}

	private boolean verifyNameOrEmailField(String nameOrEmailData) {
		// TODO Auto-generated method stub
		nameOrEmailField.waitUntilVisible();
		logger.info("nameOrEmailField.getText()"+nameOrEmailField.getText());
		return nameOrEmailField.getText().contains(nameOrEmailData);
	}

	public void clickSave() {
		saveButton.click();
		saveButton.waitUntilNotVisible();
		addDocumentCloseButton.waitUntilNotVisible();
	}

	public void clickSaveAndNew() {
		saveAndNewButton.waitUntilEnabled();
		saveAndNewButton.click();
		addDocumentCloseButton.waitUntilEnabled();
		assert(verifyDocumentDialogLoaded());
		assert(verifyNewDocumentFieldsLoaded());
	}
	
	public void setAssigneeField(String assigneeData)
	{		
		assigneeNameOrEmailField.click();
		assigneeNameOrEmailTextField.click();
		assigneeNameOrEmailTextField.type(assigneeData);
		assigneeNameOrEmailDropDownField.waitUntilVisible();
		assigneeNameOrEmailTextField.sendKeys(Keys.ENTER);
	}
	
	private String addDays(int noOfDays)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());            
		calendar.add(Calendar.DATE, noOfDays);
		Date date = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}
	
	private void closePopup()
	{
		logger.info("Close Popup");
		popupCloseButton.click();
	}
	
	public boolean verifyDocumentDialogLoaded() {
        return (new WebDriverWait(getDriver(), 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath(".//*[@id='civitasks']/div/div[1]/div/div")).isDisplayed();
            }
        });
    }
      
	public boolean verifyNewDocumentFieldsLoaded()
	{
		dueDate.waitUntilEnabled();
		 return (new WebDriverWait(getDriver(), 15)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	                return 
	                documentTypeField.getSelectedValue().equals("")&&
			         dueDate.getText().equals("") &&
			         expiryDate.getText().equals("");
	            }
		 });
	}
    public boolean validateDocumentCreated()
    {
    	dueTodayLink.waitUntilClickable();
    	(new WebDriverWait(getDriver(), 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return dueTodayLink.isCurrentlyVisible();
            }
        });
    	Actions actions = new Actions(getDriver());
    	actions.moveToElement(dueTodayLink).click().perform();

      	(new WebDriverWait(getDriver(), 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return viewDocumentByTitle.containsText("Due Today");
            }
        });
       	return(tableRows.size() > 0);
    }
    
    public void cancelChanges(boolean cancel)
    {
    	addDocumentCloseButton.waitUntilEnabled();
    	addDocumentCloseButton.waitUntilClickable();

    	if((new WebDriverWait(getDriver(), 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector("button.close")).isEnabled();
            }
        }))
    	
    	addDocumentCloseButton.click();
    	saveConfirmationNoButton.waitUntilVisible();
    	if(cancel)
    	{
    		logger.info("Click \"Yes\" to exit witout saving changes");
    		saveConfirmationYesButton.click();
    	}
    	else
    	{
    		logger.info("Click \"No\" to remain in page");
    		saveConfirmationNoButton.click();    		
    	}
    	saveButton.waitUntilNotVisible();
    }
    
    public boolean addDocumentDialogIsClosed()
    {
        return (saveButton.isCurrentlyVisible() == false);
    }
    
    private void setFileField(String filePath)
    {
    	String fileName = Paths.get(filePath).getFileName().toString();
    	
		logger.info("Add new file" + fileName);
    	dropFileLink.sendKeys(filePath);
   
    	assert(isFileAdded(fileName));
    }
    
    private boolean isFileAdded(String fileName)
    {
    	(new WebDriverWait(getDriver(), 15)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (filesAdded.size() > 0);
            }
        });
    	for(int i=0; i< filesAdded.size(); i++)
    	{
    		if(filesAdded.get(i).equals(fileName))
    			return true;
    	}
    	return false;
    }
    private void setDetailsField(String detailsData)
    {
		logger.info("Enter details" + detailsData);
		detailsTextField.waitUntilVisible();
		detailsTextField.type(detailsData);    	
    }
    
    private void setStatus(String statusData)
    {
    	logger.info("Enter Status: " + statusData);
    	Select statusSelectField = new Select(statusField);
    	statusSelectField.selectByVisibleText(statusData);
    }
}
