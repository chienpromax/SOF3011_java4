package poly.edu.severlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import java.util.List;
import poly.edu.dao.UserDao;
import poly.edu.model.User;


@WebServlet(urlPatterns = { "/user", "/user/create", "/user/update", "/user/edit", "/user/delete", "/user/reset" })
public class bai3Severlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();
		if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("reset")) {
			request.setAttribute("user", new User());
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/bai3.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();
		if (url.contains("create")) {
			create(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("reset")) {
			request.setAttribute("user", new User());
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/bai3.jsp").include(request, response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User user = new User();
            user.setId(request.getParameter("id"));
            user.setPassword(request.getParameter("password"));
            user.setFullname(request.getParameter("fullname"));
            user.setEmail(request.getParameter("email"));
            user.setAdmin(Boolean.parseBoolean(request.getParameter("admin")));

            UserDao dao = new UserDao();
            dao.insert(user);

            findAll(request, response);
            request.setAttribute("message", "Thêm mới thành công!!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi: " + e.getMessage());
        }
        request.getRequestDispatcher("/views/bai3.jsp").forward(request, response);
    }
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			UserDao dao = new UserDao();
			User user = dao.findById(id);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi: " + e.getMessage());
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			UserDao dao = new UserDao();
			dao.edit(user);
			request.setAttribute("user", user);
			request.setAttribute("message", "Cập nhật thành công!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userId = request.getParameter("id");
			UserDao dao = new UserDao();
			dao.delete(userId);
			request.setAttribute("message", "Xoá thành công!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi: " + e.getMessage());
			request.getRequestDispatcher("/views/user.jsp").forward(request, response);
		}
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDao dao = new UserDao();
			List<User> list = dao.findAll();
			request.setAttribute("users", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi: " + e.getMessage());
			request.getRequestDispatcher("/views/bai3.jsp").include(request, response);
		}
	}
}
