package cl.challenge.restclient.shared.exception;

public class SystemException extends Exception {
	private static final long serialVersionUID = -1771671231846836380L;
	
	private final String message;
	private final String causeError;
	private final int internalCode;
	
	public SystemException(String message, String causeError, int internalCode) {
		this.message = message;
		this.causeError = causeError;
		this.internalCode = internalCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public String getCauseError() {
		return causeError;
	}

	public int getInternalCode() {
		return internalCode;
	}
}
