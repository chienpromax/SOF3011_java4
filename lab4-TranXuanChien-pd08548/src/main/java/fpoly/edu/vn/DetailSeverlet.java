package fpoly.edu.vn;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DetailSeverlet")
public class DetailSeverlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		LocalDate localDate = LocalDate.of(2012, 12, 12);
	    Date date = Date.valueOf(localDate);
		Item item = new Item("Samsung 14 pro max", "samsung.jfif", 500, 0.1);
		request.setAttribute("itemImage", "samsung.jfif");
		item.setDate(date);
		request.setAttribute("item", item);
		request.getRequestDispatcher("/Bai3/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Bai3/detail.jsp").forward(request, response);
	}
}
