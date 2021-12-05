package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sukumar
 *
 */
public class PropertyReader {
	private final static Logger LOGGER = 
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
public Properties props = new Properties();
	
	/**+
	 * 
	 * @return properties
	 */
	public Properties readProperties() {
		
		try {
			props.load(new FileInputStream(System.getProperty("user.dir") + "/Resources/endpoints.properties"));
			props.load(new FileInputStream(System.getProperty("user.dir") + "/Resources/TestData.properties"));
			LOGGER.log(Level.INFO, "Reading data from properties file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return props;
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
}
