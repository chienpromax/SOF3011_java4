package fpoly.edu.vn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;


@WebServlet("/LoginSeverlet")
public class LoginSeverlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = CookieUtils.get("username", request);
		String password = CookieUtils.get("password", request);
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.getRequestDispatcher("/Bai4/LoginForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");	
		String password = request.getParameter("password");	
		String remember = request.getParameter("remember");	
		 if (!username.equalsIgnoreCase("chien")) {
			request.setAttribute("message", "Sai tên đăng nhập");
		}else if (password.length() < 3) {
			request.setAttribute("message", "pass phai hon 3 ki tu");
		}else {
			request.setAttribute("message", "Đăng nhập thành công");
			int hours = (remember==null) ? 0:30*24; 
			CookieUtils.add("username", username, hours, response);
			CookieUtils.add("password", password, hours, response);
			request.getRequestDispatcher("/Bai5/sendmail.jsp").forward(request, response);
		}
	}
}
