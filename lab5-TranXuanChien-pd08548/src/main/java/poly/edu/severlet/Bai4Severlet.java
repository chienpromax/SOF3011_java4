package poly.edu.severlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.edu.dao.UserDao;
import poly.edu.model.User;

@WebServlet(urlPatterns = { "/account/sign-in", "/account/sign-up", "/account/sign-out", "/account/forgot-password",
		"/account/change-password", "/account/edit-profile" })
public class Bai4Severlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("sign-in")) {
			doSignIn(request, response);
		} else if (uri.contains("sign-up")) {
			doSignUp(request, response);
		} else if (uri.contains("sign-out")) {
		} else if (uri.contains("edit-profile")) {
			doEditProfile(request, response);
		} else if (uri.contains("forgot-password")) {
		} else if (uri.contains("change-password")) {
		}
	}

	private void doEditProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				BeanUtils.populate(user, request.getParameterMap());
				UserDao dao = new UserDao();
				dao.edit(user);
				request.setAttribute("message", "Cập nhật tài khoản thành công!");
			} catch (Exception e) {
				request.setAttribute("message", "Lỗi cập nhật tài khoản!");
			}
		}
		request.getRequestDispatcher("/views/account/edit-profile.jsp").forward(request, response);
	}

	private void doSignUp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				User user = new User();
	            user.setId(request.getParameter("userId"));
	            user.setPassword(request.getParameter("password"));
	            user.setFullname(request.getParameter("fullname"));
	            user.setEmail(request.getParameter("email"));
	            user.setAdmin(Boolean.parseBoolean(request.getParameter("admin")));

	            UserDao dao = new UserDao();
	            dao.insert(user);
				request.setAttribute("message", "Đăng ký thành công!");
				response.setHeader("Refresh", "1;url=/Lab5/account/sign-in");
			} catch (Exception e) {
				request.setAttribute("message", "Lỗi đăng ký!");
			}
		}
		request.getRequestDispatcher("/views/account/sign-up.jsp").forward(request, response);
		
	}

	private void doSignIn(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String method = request.getMethod();
	    if (method.equalsIgnoreCase("POST")) {
	        String userId = request.getParameter("userId");
	        String pw = request.getParameter("password");
	        
	        if (userId == null || userId.isEmpty() || pw == null || pw.isEmpty()) {
	            request.setAttribute("message", "Vui lòng nhập đủ thông tin đăng nhập!");
	        } else {
	            try {
	                UserDao dao = new UserDao();
	                User user = dao.findById(userId);
	                if (user == null) {
	                    request.setAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
	                } else if (!user.getPassword().equals(pw)) {
	                    request.setAttribute("message", "Sai mật khẩu!");
	                } else {
	                    request.setAttribute("message", "Đăng nhập thành công!");
	                    request.getSession().setAttribute("user", user);
	                    response.sendRedirect("/Lab5/account/edit-profile");
	                    return;
	                }
	            } catch (Exception e) {
	                request.setAttribute("message", "Đã xảy ra lỗi");
	            }
	        }
	    }
	    request.getRequestDispatcher("/views/account/sign-in.jsp").forward(request, response);
	}

}
