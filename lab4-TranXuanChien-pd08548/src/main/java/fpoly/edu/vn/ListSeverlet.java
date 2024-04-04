package fpoly.edu.vn;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListSeverlet")
public class ListSeverlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Item> items = Arrays.asList(new Item("Samsung 14 pro max", "samsung.jfif", 500, 0.1),
				new Item("Samsung 14 pro max", "samsung.jfif", 500, 0.1),
				new Item("Iphone 14 pro max", "hong.png", 500, 0.1),
				new Item("Iphon 12 pro max", "xam.jfif", 500, 0.1),
				new Item("Dell g15 5511", "dell.jfif", 500, 0.1),
				new Item("Iphone 13 pro max", "xanh.jfif", 500, 0.1));
		request.setAttribute("items", items);
		request.getRequestDispatcher("layout2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("layout2.jsp").forward(request, response);
	}

}
