package exception.car;

public class CarTypeException extends Exception{
	private int errorCode;
	public CarTypeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarTypeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CarTypeException(int errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
