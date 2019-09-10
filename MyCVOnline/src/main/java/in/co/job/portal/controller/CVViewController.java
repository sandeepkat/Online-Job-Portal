package in.co.job.portal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import in.co.job.portal.bean.BaseBean;
import in.co.job.portal.bean.CVBean;
import in.co.job.portal.bean.UserBean;
import in.co.job.portal.exception.ApplicationException;
import in.co.job.portal.model.UserModel;
import in.co.job.portal.util.DataUtility;
import in.co.job.portal.util.DataValidator;
import in.co.job.portal.util.PropertyReader;
import in.co.job.portal.util.ServletUtility;



/**
 * Servlet implementation class ChangeCVController
 */

/**
 * 
 * @author Sandeep Kumar
 * @version 1.0
 * 
 */
@WebServlet(name = "CVViewController", urlPatterns = { "/ctl/ChangeCVView" })
public class CVViewController extends BaseCtl {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(ChangePasswordCtl.class);

	public static final String OP_CHANGE_MY_PROFILE = "Change My Profile";
	public static final String OP_CHANGE_MY_PASSWORD = "ChangePassword";

	/**
	 * Validates input data entered by User
	 * 
	 * @param request
	 * @return
	 */

	@Override
	protected boolean validate(HttpServletRequest request) {
		log.debug("ChangeCV  validate method start");

		boolean pass = true;

		String op = request.getParameter("operation");

		if (OP_CHANGE_MY_PROFILE.equalsIgnoreCase(op)) {

			return pass;
		}
		
		if (DataValidator.isNull(request.getParameter("mainSkills"))) {
			request.setAttribute("mainSkills", PropertyReader.getValue("error.require", "Main Skills"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("workExperience"))) {
			request.setAttribute("workExperience", PropertyReader.getValue("error.require", "Work Experience"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("educaTion"))) {
			request.setAttribute("educaTion", PropertyReader.getValue("error.require", "Education"));
			pass = false;
		}
		
		log.debug("ChangeCV  validate method end");
		return pass;
	}
	/**
	 * Populates bean object from request parameters
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("ChangeCV  populateBean method start");

		CVBean bean = new CVBean();
		bean.setMainSkills(DataUtility.getString(request.getParameter("mainSkills")));

		bean.setWorkExperience(DataUtility.getString(request.getParameter("workExperience")));
		bean.setEducaTion(DataUtility.getString(request.getParameter("educaTion")));
		log.debug("ChangeCV  populateBean method end");
		return bean;
	}

	/**
	 * Display Logics inside this method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("ChangeCV  doGet method start");
		HttpSession session=request.getSession(true);
		
		String user=request.getParameter("user");
		
		long id=Long.parseLong(user);
		
		String op=DataUtility.getString(request.getParameter("operation"));
		//get Model
		
		UserModel model=new UserModel();
		
		
		if(id>0||op !=null){
			System.out.println("in id>0 condition");
			CVBean bean;
			try{
				bean=model.findByUserId(id);
				ServletUtility.setBean(bean, request);
				
			}catch(ApplicationException e){
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("ChangeCV  doGet method end");
	}

	
	/**
	 * Returns the VIEW page of this Controller
	 * 
	 * @return
	 */
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return JPView.CV_VIEW_STATIC;
	}

}
