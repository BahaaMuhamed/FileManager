package stc.assigment.ex;

public class UserNotAuthorizedException extends Exception {
	public UserNotAuthorizedException(String message) {
		super(message);
	}
}
