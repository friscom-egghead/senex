package senex.core;

@SuppressWarnings("serial")
final public class SenexException extends Exception{
	public SenexException(String message) {
		super(message);
	}
	
	public SenexException(String message, Throwable exe) {
		super(message,exe);
	}
}
