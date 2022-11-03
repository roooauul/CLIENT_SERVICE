package cl.challenge.restclient.shared;

public class SystemConstants {
	
	public static final String API_RESPONSE_SUCCESS = "success";
	public static final String API_VALIDATION_ERROR = "VALIDATION_FAILED";
	public static final String API_RESOURCE_NOT_FOUND_ERROR = "RESOURCE_NOT_FOUND";
	public static final String API_INVALID_PATH_ERROR = "INVALID_PATH";
	public static final String EMAIL_REGEX = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private SystemConstants() { }
}
