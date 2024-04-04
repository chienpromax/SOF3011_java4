package poly.edu.vn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.UserDao;
import model.User;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet(urlPatterns = { "/account/sign-in",  
	 "/account/sign-out","/account/admin" })
public class AccountServletBai2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountServletBai2() {
		super();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if (uri.contains("sign-in")) {
			doSignIn(request, response);
		} else if (uri.contains("sign-out")) {
			doSignOut(request, response);
		}  else if (uri.contains("admin")) {
			doadmin(request, response);
		} 
	}


	private void doSignIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		User entity = new User();
		if (method.equalsIgnoreCase("POST")) {
			String userId = request.getParameter("userId");
			String pw = request.getParameter("password");
			 //SessionUtils.add(request, "fullname", entity.getFullname());
			
			try {
				UserDao dao = new UserDao();
				User user = dao.findById(userId);
				if (!user.getPassword().equals(pw)) {
					request.setAttribute("message", "Sai mật khẩu!");
				} else {
					request.setAttribute("message", "Đăng nhập thành công!");
					response.setHeader("Refresh", "1;url=/Lab7.1/home.jsp");
					//request.getRequestDispatcher("/account/logout.jsp").forward(request, response);
					request.getSession().setAttribute("user", user);
					User users = (User) request.getSession().getAttribute("user");
					String id = user.getUserId();
					
				}
			} catch (Exception e) {
				request.setAttribute("message", "Sai tên đăng nhập!");
			}
		}
		request.getRequestDispatcher("/sign-in.jsp").forward(request, response);
	}
	private void doadmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/admin.jsp").forward(request, response);
	}
 
 
	

	private void doSignOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.removeAttribute("userId");
		session.invalidate();
		request.setAttribute("message", "Đăng xuất thành công!");
		request.getRequestDispatcher("/sign-in.jsp").forward(request, response);
	}
}
