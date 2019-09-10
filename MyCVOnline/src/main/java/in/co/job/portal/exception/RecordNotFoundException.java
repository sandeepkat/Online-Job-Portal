package in.co.job.portal.exception;

/**
 * RecordNotFoundException thrown when a record not found occurred
 * 
 * @author Sandeep Kumar
 * @version 1.0
 * 
 */

public class RecordNotFoundException extends Exception
{

	/**
	 * @param msg
	 *            error message
	 */
	public RecordNotFoundException(String msg) {
		super(msg);

	}
}
