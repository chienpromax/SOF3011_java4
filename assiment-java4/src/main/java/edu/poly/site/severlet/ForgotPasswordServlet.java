package edu.poly.site.severlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.EmailUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import edu.poly.model.User;


@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailFrom = "xuanchient033@gmail.com";
			String passForm = "ayiw lqih jicy vmgd";
			UserDao dao = new UserDao();
			String emailAddress = request.getParameter("email");
			String username = request.getParameter("username");
			// lấy thông tin người dùng 
			User user = dao.findByUsernameEmail(username, emailAddress);
			if (user == null) {
				request.setAttribute("error", "Username or email are incorrect");
			} else {
				Email email = new Email();
				email.setFrom(emailFrom);
				email.setFromPassword(passForm);
				email.setTo(emailAddress);
				email.setSubject("Forgot Password");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear").append(username).append("<br>");
				sb.append("You are used the forgot password function.<br>");
				sb.append("You password is: <b> ").append(user.getPassword()).append("</b>");
				sb.append("Regards<br>");
				sb.append("Administrator");
				email.setContent(sb.toString());
				EmailUtils.send(email);
				request.setAttribute("message", "ForgotPassword ok");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}
}
