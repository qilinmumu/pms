/**
 * 
 */
package edu.fjnu.pms.exception;

/**
 * 声明数据库访问异常
 * @author lzx
 *
 */
public class DataAccessException extends ApplicationException {

	public DataAccessException() {
		super();
	}

	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(Throwable cause) {
		super(cause);
	}
	
}
