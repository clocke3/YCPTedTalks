package edu.ycp.cs320.aroby.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.aroby.controller.AccountController;
import edu.ycp.cs320.aroby.controller.LoginController;
import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.Professor;
import edu.ycp.cs320.aroby.model.Student;

public class CreateAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/_view/accountCreation.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Create our account controller, generic model object, and some objects for session info
		AccountController controller= new AccountController();
		Account model = new Account();
		Boolean accountCreated = false;
		Boolean noPasswordMatch = false;
		HttpSession session =  req.getSession(true);
		
		// Get all the parameters we passed into our JSP
		String inputEmail = req.getParameter("email");
		String inputPass = req.getParameter("password");
		String reenteredPass = req.getParameter("reenteredPassword");
		String inputFirstName = req.getParameter("firstname");
		String inputLastName = req.getParameter("lastname");
		String inputAdminKey = req.getParameter("admin_key");
		String inputMajor = req.getParameter("major");
		String inputYCPID = req.getParameter("ycp_id");
		
		// If all of our basic fields have been filled out, check to see if the passwords match
		if(inputEmail != "" && inputPass != "" && inputFirstName != "" && inputLastName != "" &&
				reenteredPass != "" && reenteredPass != null && inputEmail != null && 
				inputPass != null && inputFirstName != null && inputLastName != null) {
			// If our passwords match
			if(inputPass.equals(reenteredPass)) {
				if(inputAdminKey != "" && inputAdminKey != null) {

					// Create an account to hold the info we got from the JSP, then pass into controller
					// and create a new account
					Account acc = new Account();
					acc.setEmail(inputEmail);
					acc.setFirstName(inputFirstName);
					acc.setLastName(inputLastName);
					acc.setPassword(inputPass);
					acc.setAdmin(true);
					controller.setModel(acc);
					accountCreated = controller.createAccount(acc);
					
					// Set our generic model object to the account we just created
					model = acc;
				}
				// If our student fields are filled out, make a student account for the user
				else if(inputMajor != "" && inputYCPID != "" && inputMajor != null && inputYCPID != null) {
					
					// Parse the YCP id real quick
					int student_id = Integer.parseInt(inputYCPID);
					
					// Create the student object, add it to the controller, then add it to the
					// database
					Student std = new Student();
					std.setEmail(inputEmail);
					std.setFirstName(inputFirstName);
					std.setLastName(inputLastName);
					std.setPassword(inputPass);
					std.setMajor(inputMajor);
					std.setAdmin(false);
					std.setYCPId(student_id);
					
					controller.setModel(std);
					accountCreated = controller.createStudent(std);
					model = std;
				}
			} else {
				noPasswordMatch = true;
			}
		} else {
			accountCreated = false;
		}
		
		// Session information signals if an account has been created successfully.
		// If so, we'll set the session attributes and redirect them to the index page.
		// If not, the page will tell them to enter all required fields
		if (accountCreated == true) {
			session.setAttribute("login", true);
			session.setAttribute("name", model.getFirstName());
			if (session.getAttribute("bad_info") != null) {
				session.removeAttribute("bad_info");
				session.removeAttribute("no_pw_match");
			}
			resp.sendRedirect("/aroby/index");
		}
		else {
			if (noPasswordMatch) {
				session.setAttribute("no_pw_match", true);
			} else if(!accountCreated){
				session.setAttribute("bad_info", true);
			}
			req.getRequestDispatcher("/_view/accountCreation.jsp").forward(req, resp);
		}
	}
}
