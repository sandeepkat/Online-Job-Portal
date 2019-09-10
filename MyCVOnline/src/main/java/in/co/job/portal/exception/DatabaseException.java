package in.co.job.portal.exception;

/**
 * DatabaseException is propogated by DAO classes when an unhandled Database
 * exception occurred
 *
 * @author Sandeep Kumar
 * @version 1.0
 *
 */

public class DatabaseException  extends Exception
{
	/**
    * @param msg
    *            : Error message
    */
   public DatabaseException(String msg) {
       super(msg);
   }
}

