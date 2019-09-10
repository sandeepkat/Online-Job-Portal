package in.co.job.portal.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * 
 * @author Sandeep Kumar
 * @version 1.0
 * 
 */
public class DuplicateRecordException  extends Exception
{
	/**
	 * @param msg
	 *            error message
	 */
	public DuplicateRecordException(String msg) {
		super(msg);
	}
}
