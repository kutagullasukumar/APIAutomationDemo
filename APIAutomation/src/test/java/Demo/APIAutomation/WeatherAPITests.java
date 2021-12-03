package Demo.APIAutomation;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Common.TestUtils.Utility;

import Utils.PropertyReader;
import io.restassured.response.Response;

/**
 * @author Sukumar
 *
 */
public class WeatherAPITests {
	private final static Logger LOGGER = 
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	Properties props = new PropertyReader().readProperties();
	SoftAssert softAssert = new SoftAssert();
	Utility utility = new Utility();
	Response resonse;

	@Test
	public void verifyResponseForValidCityId() {
		softAssert.assertEquals(
				utility.getResponseData(props.getProperty("getByCityID").replace("{0}", props.getProperty("validCityId"))
						.replace("{1}", props.getProperty("api_key"))).getStatusCode(),
				props.getProperty("successStatusCode"));
		softAssert.assertEquals(utility.getPojoData().getId(), props.getProperty("validCityId"));
		LOGGER.log(Level.INFO, "Verify response for valid city id and valid api_key");
	}
	
	@Test
	public void verifyResponseForInvalidCityId() {
		softAssert.assertEquals(
				utility.getResponseData(props.getProperty("getByCityID").replace("{0}", props.getProperty("invalidCityId"))
						.replace("{1}", props.getProperty("api_key"))).getStatusCode(),
				props.getProperty("badRequestStatusCode"));
		LOGGER.log(Level.INFO, "Verify response for invalid city id and valid api_key");
	}
	
	@Test
	public void verifyResponseForInvalidApiKey() {
		softAssert.assertEquals(
				utility.getResponseData(props.getProperty("getByCityID").replace("{0}", props.getProperty("validCityId"))
						.replace("{1}", props.getProperty("invalidApi_key"))).getStatusCode(),
				props.getProperty("unAuthorizedStatusCode"));
		LOGGER.log(Level.INFO, "Verify response for valid city and invalid api_key");
	}
}
