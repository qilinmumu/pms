/**
 * 
 */
package edu.fjnu.pms.exception;

/**
 * @author lzx
 *
 */
public class ApplicationException extends RuntimeException {

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

}
