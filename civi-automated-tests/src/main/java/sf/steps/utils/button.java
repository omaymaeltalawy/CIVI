package sf.steps.utils;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.WebElementFacade;


public class button{

    public static final Logger logger = LoggerFactory.getLogger(GetClassLoader.class);
    
	public static void click(WebElementFacade element)
	{
		logger.info("Click " + element.getText());
		element.click();
	}
	
	/*public static boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                element.findByisDisplayed();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
}*/
}
