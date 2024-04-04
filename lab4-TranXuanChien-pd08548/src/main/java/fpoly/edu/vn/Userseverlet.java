package fpoly.edu.vn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Userseverlet")
public class Userseverlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		try {
		    List<User> userList = dao.dumyData();
		    User user = userList.get(0);
		    request.setAttribute("USER", user);
		    request.setAttribute("LIST_USER", userList);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    request.setAttribute("message", "Quản lý người sử dụng!");
	    request.getRequestDispatcher("/Bai2/Index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {


	    request.getRequestDispatcher("/Bai2/Index.jsp").forward(request, response);
	}

}
