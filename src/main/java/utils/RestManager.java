package utils;


import io.restassured.config.DecoderConfig;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestManager {

	/** Singleton instance of Rest manager */
	private static RestManager instance = new RestManager();
	private RestAssuredConfig restAssuredConfig = null;

	/**
	 * Get Rest Client instance
	 */
	public static RestManager getInstance() {

		return instance;
	}

	/**
	 * C'tor private for singleton instance
	 */
	private RestManager() {
		restAssuredConfig = new RestAssuredConfig()
				.decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset("UTF-8"))
				.objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON));
	}

	/**
	 * Execute rest request
	 */
	public Response execute(RestRequest restRequest){
		Response restResponse = null;
		switch (restRequest.getmMethod()) {
		case GET:
			restResponse = executeGetRequest(restRequest);
			break;

		case POST:
			restResponse = getPostRequest(restRequest);
			break;

		case PUT:
			restResponse = getPutRequest(restRequest);
			break;

		case PATCH:
			restResponse = getPatchRequest(restRequest);
			break;

		case DELETE:
			restResponse = getDeleteRequest(restRequest);
			break;

		default:
			break;

		}
		return restResponse;
	}

	/**
	 * Create Get request
	 */
	private Response executeGetRequest(RestRequest restRequest) {
		RequestSpecification requestSpec = restRequest.getRequestSpec();
		return requestSpec.given().config(restAssuredConfig).relaxedHTTPSValidation().headers(restRequest.getmHeaders())
				.contentType(restRequest.getContentType()).when().log().all().get(restRequest.getmUrl()).then().log()
				.all().extract().response();
	}

	/**
	 * Create Post request
	 */
	private Response getPostRequest(RestRequest restRequest) {
		RequestSpecification requestSpec = given().relaxedHTTPSValidation();
		return requestSpec.given().config(restAssuredConfig).relaxedHTTPSValidation().headers(restRequest.getmHeaders())
				.contentType(restRequest.getContentType()).body(restRequest.getmPayload()).when().log().all()
				.post(restRequest.getmUrl()).then().log().all().extract().response();
	}

	/**
	 * Create Put request
	 */
	private Response getPutRequest(RestRequest restRequest) {
		RequestSpecification requestSpec = given().relaxedHTTPSValidation();
		return requestSpec.given().config(restAssuredConfig).relaxedHTTPSValidation().headers(restRequest.getmHeaders())
				.contentType(restRequest.getContentType()).when().log().all().put(restRequest.getmUrl()).then().log()
				.all().extract().response();
	}

	/**
	 * Create Patch request
	 */
	private Response getPatchRequest(RestRequest restRequest) {
		RequestSpecification requestSpec = given().relaxedHTTPSValidation();
		return requestSpec.given().config(restAssuredConfig).relaxedHTTPSValidation().headers(restRequest.getmHeaders())
				.contentType(restRequest.getContentType()).body(restRequest.getmPayload()).when().log().all()
				.patch(restRequest.getmUrl()).then().log().all().extract().response();
	}

	/**
	 * Create Delete request
	 */
	private Response getDeleteRequest(RestRequest restRequest) {
		RequestSpecification requestSpec = given().relaxedHTTPSValidation();
		return requestSpec.given().config(restAssuredConfig).relaxedHTTPSValidation().headers(restRequest.getmHeaders())
				.contentType(restRequest.getContentType()).when().log().all().delete(restRequest.getmUrl()).then().log()
				.all().extract().response();
	}

}
