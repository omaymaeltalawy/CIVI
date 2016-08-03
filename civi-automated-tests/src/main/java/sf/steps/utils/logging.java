package sf.steps.utils;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class logging {

	public static final Logger logger = LoggerFactory.getLogger(GetClassLoader.class);
	public static void log(String logMessage)
	{
        logger.info("<---------------------------------------------------------------->");
        logger.info("<----- " + logMessage + " ----->");
        logger.info("<---------------------------------------------------------------->");
        
	}
}
