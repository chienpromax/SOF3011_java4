package poly.edu.severlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import poly.edu.dao.UserDao;
import poly.edu.model.User;

@WebServlet("/Bai1Severlet")
public class Bai1Severlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	    try {
//	        User newUser = new User();
//	        newUser.setAdmin(true);
//	        newUser.setEmail("bb@gmail.com");
//	        newUser.setFullname("bb");
//	        newUser.setId("bb");
//	        newUser.setPassword("bb");
//	        
//	        UserDao insertDao = new UserDao();
//	        insertDao.insert(newUser);
//	        
//	        response.getWriter().println("<h1>Insertion OK</h1>");
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        response.getWriter().println("<h1>Error during insertion</h1>");
//	    }

//	    edit
//	    try {
//	        User editUser = new User();
//	        editUser.setAdmin(false);
//	        editUser.setEmail("updated@gmail.com");
//	        editUser.setFullname("Updated Name");
//	        editUser.setId("1");
//	        editUser.setPassword("updatedPassword");
//	        
//	        UserDao editDao = new UserDao();
//	        editDao.edit(editUser);
//	        response.getWriter().println("<h1>Update OK</h1>");
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        response.getWriter().println("<h1>Error during update</h1>");
//	    }

//	    xóa
//		try {
//			String userIdToDelete = "123";
//			UserDao deldao = new UserDao();
//			deldao.delete(userIdToDelete);
//			response.getWriter().println("<h1>delete OK</h1>");
//		} catch (Exception e) {
//			e.printStackTrace();
//			response.getWriter().println("<h1>Error during delete</h1>");
//		}

//		findAll
//		try {
//            UserDao userDao = new UserDao();
//            List<User> userList = userDao.findAll();
//            request.setAttribute("userList", userList);
//            request.getRequestDispatcher("/userList.jsp").forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.getWriter().println("<h1>Error occurred</h1>");
//        }

//		findRole
//		UserDao userDao = new UserDao();
//		List<User> adminUsers = userDao.findByRole(true);
//		List<User> normalUsers = userDao.findByRole(false);
//		request.setAttribute("adminUsers", adminUsers);
//		request.setAttribute("normalUsers", normalUsers);
//		request.getRequestDispatcher("/role.jsp").forward(request, response);

//		findByKey
//		try {
//		    String key = "123";
//		    UserDao dao = new UserDao();
//		    List<User> users = dao.findByKeyWord(key);
//		    request.setAttribute("userList", users);
//		    request.getRequestDispatcher("/userList.jsp").forward(request, response);
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
		
//		findOne
//		try {
//		    String id = "xx";
//		    String pass = "123";
//		    UserDao dao = new UserDao();
//		    List<User> users = dao.findOne(id,pass);
//		    request.setAttribute("userList", users);
//		    request.getRequestDispatcher("/userList.jsp").forward(request, response);
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
		
//		findpage
		try {
		    UserDao dao = new UserDao();
		    List<User> pageUsers = dao.findPage(1, 3); // Lấy trang thứ 3 với 5 người dùng trên mỗi trang
		    request.setAttribute("userList", pageUsers); // Gán danh sách người dùng vào thuộc tính của request
		    request.getRequestDispatcher("/userList.jsp").forward(request, response); // Chuyển hướng sang trang userList.jsp để hiển thị
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}
}
