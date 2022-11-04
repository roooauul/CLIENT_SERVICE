package cl.challenge.restclient.shared;

public class SystemConstants {
	
	public static final String API_RESPONSE_SUCCESS = "success";
	public static final String API_VALIDATION_ERROR = "VALIDATION_FAILED";
	public static final String API_RESOURCE_NOT_FOUND_ERROR = "RESOURCE_NOT_FOUND";
	public static final String API_INVALID_PATH_ERROR = "INVALID_PATH";
	public static final String ALPHABETICAL_WITH_SPACES_REGEX = "^[A-Za-z0-9À-ÖØ-öø-ÿ \\']+$";
	public static final String EMAIL_REGEX = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static final int GENERIC_MIN_LENGHT = 2;
	public static final int GENERIC_MAX_LENGHT = 30;
	public static final int PHONE_MIN = 100000000;
	public static final int PHONE_MAX = 999999999;
	
	public static final int CLIENT_REGISTERED = 1001;
	public static final int CLIENT_NOT_REGISTERED = 1002;
	
	private SystemConstants() { }
}
