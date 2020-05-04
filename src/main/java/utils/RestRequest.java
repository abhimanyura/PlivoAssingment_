package utils;


import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestRequest {

	/**
	 * HTTP Method type enumeration
	 */
	public enum METHOD {
		GET, POST, PUT, DELETE, PATCH
	};

	private METHOD mMethod;

	private ContentType contentType;

	/**
	 * @return the contentType
	 */
	public ContentType getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            the contentType to set
	 */
	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	private String methodUrl;

	private Map<String, String> methodHeaders;

	private String methodPayload;

	RequestSpecification requestSpec;

	public RequestSpecification getRequestSpec() {
		return requestSpec;
	}

	/**
	 * C'tor Access the defined field for the API request
	 */
	public RestRequest(METHOD aMethod, String aUrl, Map<String, String> methodHeaders, String methodPayload,
			ContentType methodContentType, RequestSpecification requestSpec) {
		this.mMethod = aMethod;
		this.methodUrl = aUrl;
		this.methodHeaders = methodHeaders;
		this.methodPayload = methodPayload;
		this.contentType = methodContentType;
		if (requestSpec != null)
			this.requestSpec = requestSpec;
		else
			this.requestSpec = given().relaxedHTTPSValidation();
	}

	/**
	 * @return the mMethod
	 */
	public METHOD getmMethod() {
		return mMethod;
	}

	/**
	 * @return the mUrl
	 */
	public String getmUrl() {
		return methodUrl;
	}

	/**
	 * @return the mHeaders
	 */
	public Map<String, String> getmHeaders() {
		return methodHeaders;
	}

	/**
	 * @return the mPayload
	 */
	public String getmPayload() {
		return methodPayload;
	}

	/**
	 * @param mMethod
	 *            the mMethod to set
	 */
	public void setmMethod(METHOD mMethod) {
		this.mMethod = mMethod;
	}

	/**
	 * @param mUrl
	 *            the mUrl to set
	 */
	public void setmUrl(String mUrl) {
		this.methodUrl = mUrl;
	}

	/**
	 * @param mHeaders
	 *            the mHeaders to set
	 */
	public void setmHeaders(Map<String, String> mHeaders) {
		this.methodHeaders = mHeaders;
	}

	/**
	 * @param methodHeaders
	 *            the mHeaders to set
	 */
	public void setmHeaders(ContentType mContentType) {
		this.contentType = mContentType;
	}

	/**
	 * @param mPayload
	 *            the mPayload to set
	 */
	public void setmPayload(String mPayload) {
		this.methodPayload = mPayload;
	}

	public static RestRequestBuilder builder() {
		return new RestRequestBuilder();
	}

	public static class RestRequestBuilder {
		private METHOD mMethod;

		private String mUrl;

		private Map<String, String> mHeaders;

		private String mPayload;

		private ContentType mContentType;

		private RequestSpecification mrequestSpec;

		public RestRequestBuilder requestSpec(RequestSpecification requestSpec) {
			mrequestSpec = requestSpec;
			return this;
		}

		/**
		 * Set http request method type
		 */
		public RestRequestBuilder contentType(ContentType aContentType) {
			mContentType = aContentType;
			return this;
		}

		/**
		 * Set http request method type
		 */
		public RestRequestBuilder method(METHOD aMethod) {
			mMethod = aMethod;
			return this;
		}

		/**
		 * Set http request URL
		 */
		public RestRequestBuilder url(String aUrl) {
			mUrl = aUrl;
			return this;
		}

		/**
		 * Set http Request headers map
		 */
		public RestRequestBuilder headers(Map<String, String> aHeaders) {
			mHeaders = aHeaders;
			return this;
		}

		/**
		 * Set http request payload
		 */
		public RestRequestBuilder payload(String aPayload) {
			mPayload = aPayload;
			return this;
		}

		/**
		 * Build the cloud http request for execution by http client
		 */
		public RestRequest build() {
			return new RestRequest(mMethod, mUrl, mHeaders, mPayload, mContentType, mrequestSpec);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

