package SMA;

public class ColegioExcepcion extends Exception {

	public ColegioExcepcion() {
		// TODO Auto-generated constructor stub
	}

	public ColegioExcepcion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ColegioExcepcion(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ColegioExcepcion(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ColegioExcepcion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Excepcion de ColegioSMA: " + super.getMessage();
	}

}
