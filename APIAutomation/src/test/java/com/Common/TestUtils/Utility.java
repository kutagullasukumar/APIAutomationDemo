package com.Common.TestUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

import Demo.APIAutomation.ResponsePOJOClasses.ValidResponsePOJO;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @author Sukumar
 *
 */
public class Utility {

	Response response;
	private final static Logger LOGGER = 
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	/**+
	 * 
	 * @param endpoint
	 * @return response
	 */
	public Response getResponseData(String endpoint) {
		response = RestAssured.get(endpoint);
		LOGGER.log(Level.INFO, "Getting response data");
		return response;
	}
	
	/**+
	 * 
	 * @return deserialized object
	 */
	public ValidResponsePOJO getPojoData() {
		ValidResponsePOJO responsePojo = response.getBody().as(ValidResponsePOJO.class);
		LOGGER.log(Level.INFO, "Deserializing response data to POJO classes");
		return responsePojo;
	}
}
