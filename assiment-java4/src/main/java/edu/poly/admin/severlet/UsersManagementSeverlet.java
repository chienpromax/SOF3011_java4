package edu.poly.admin.severlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.model.User;

@WebServlet({ "/Admin/UsersManagement", "/Admin/UsersManagement/create", "/Admin/UsersManagement/update",
		"/Admin/UsersManagement/delete", "/Admin/UsersManagement/reset", "/Admin/UsersManagement/edit"})
@MultipartConfig
public class UsersManagementSeverlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();
		if (url.contains("edit")) {
			edit(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("reset")) {
			reset(request, response);
			return;
		}
		findAll(request, response);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();
		if (url.contains("create")) {
			create(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("update")) {
			update(request, response);
			return;
		}
		if (url.contains("reset")) {
			reset(request, response);
			return;
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("username");
		if (id == null) {
			request.setAttribute("error", "Username is required !");
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
			return;
		}
		try {
			UserDao dao = new UserDao();
			User user = dao.findById(id);

			if (user == null) {
				request.setAttribute("error", "User id not found !");
				PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
				return;
			}
			dao.delete(id);
			request.setAttribute("message", "xóa thành công!");
			request.setAttribute("user", new User());
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("username");

		if (id == null) {
			request.setAttribute("error", "Username is required !");
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
			return;
		}
		try {
			UserDao dao = new UserDao();
			User user = dao.findById(id);
			request.setAttribute("user", user);
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id = request.getParameter("username");
	    UserDao dao = new UserDao();
	    User user = dao.findById(id);
	    if (user == null) {
	        request.setAttribute("error", "Không tìm thấy user!");
	    } else {
	        try {
	            // Lấy dữ liệu từ request để cập nhật thông tin cho user
	            BeanUtils.populate(user, request.getParameterMap());
	            
	            // Xử lý checkbox admin
	            String isAdmin = request.getParameter("admin");
	            user.setAdmin(isAdmin != null && isAdmin.equals("true")); // Nếu isAdmin không null và bằng "true", set admin là true, ngược lại là false
	            
	            // Thực hiện cập nhật thông tin vào cơ sở dữ liệu
	            dao.update(user);
	            request.setAttribute("user", user);
	            request.setAttribute("message", "Cập nhật thành công!");
	            findAll(request, response); // Tìm tất cả các người dùng sau khi cập nhật
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("error", "Lỗi: " + e.getMessage());
	        }
	    }
	    PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	private boolean isValidEmail(String email) {
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    Pattern pattern = Pattern.compile(emailRegex);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    User user = new User();
	    try {
	        BeanUtils.populate(user, request.getParameterMap());
	        if (!isValidEmail(user.getEmail())) {
	        	request.setAttribute("error", "Email không hợp lệ");
	            response.sendRedirect(request.getContextPath() + "/Admin/UsersManagement");
	            return;
	        }
	        // Lấy giá trị của checkbox admin và user từ request parameter
	        String admin = request.getParameter("admin");
	        String userRole = request.getParameter("user");
	        
	        // Kiểm tra và gán giá trị cho thuộc tính admin của user
	        if ("true".equals(admin)) {
	            user.setAdmin(true);
	        } else {
	            user.setAdmin(false);
	        }
	        
	        UserDao dao = new UserDao();
	        dao.insert(user);
	        request.setAttribute("user", user);
	        request.setAttribute("message", "Thêm thành công");
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Error: " + e.getMessage());
	    }
	    findAll(request, response);
	    PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}


	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		try {
			UserDao dao = new UserDao();
			List<User> list = dao.findAll();
			request.setAttribute("users", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		request.setAttribute("user", user);
		findAll(request, response);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}
}
