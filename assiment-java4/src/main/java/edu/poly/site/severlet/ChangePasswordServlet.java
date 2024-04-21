package edu.poly.site.severlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.UserDao;
import edu.poly.domain.ChangePasswordForm;


@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(request);
		if (username == null) {
			request.getRequestDispatcher("/login").forward(request, response);
			return;
		}
		request.setAttribute("ussername", username);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        String username = SessionUtils.getLoginedUsername(request);
	        ChangePasswordForm form = new ChangePasswordForm();
	        BeanUtils.populate(form, request.getParameterMap());
	        request.setAttribute("username", username);
	        
	        if (form.getConfirmPassword() == null || form.getPassword() == null) {
	            request.setAttribute("error", "Confirm password or password is null");
	        } else if (!form.getConfirmPassword().equals(form.getPassword())) {
	            request.setAttribute("error", "Confirm password does not match");
	        } else {
	            UserDao dao = new UserDao();
	            dao.changePassword(form.getUsername(), form.getCurrentPassword(), form.getPassword());
	            request.setAttribute("message", "Password changed successfully");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", e.getMessage());
	    }
	    PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}

}
