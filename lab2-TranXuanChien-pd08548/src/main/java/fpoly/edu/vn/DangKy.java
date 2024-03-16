package fpoly.edu.vn;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DangKy")
public class DangKy extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/FormBai2/Form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String notes = request.getParameter("notes");
		boolean gender =  Boolean.parseBoolean(request.getParameter("gender"));
		boolean married = (request.getParameter("married") != null);
		String country = request.getParameter("country");
		String[] hobbies = request.getParameterValues("hobbies");
		
		request.setAttribute("NAME", name);
		request.setAttribute("PASS", pass);
		request.setAttribute("GENDER", gender);
		request.setAttribute("MARRIED", married);
		request.setAttribute("CUONTRY", country);
		request.setAttribute("HOBBIES", Arrays.toString(hobbies));
		request.setAttribute("NOTES", notes);
		
		request.getRequestDispatcher("/FormBai2/Info.jsp").forward(request, response);
	}

}
