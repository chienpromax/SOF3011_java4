package fpoly.edu.vn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/TamGiacSeverlet", "/dien-tich", "/chu-vi" })
public class TamGiacSeverlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/Form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String canha = request.getParameter("CanhA");
	    String canhb = request.getParameter("CanhB");
	    String canhc = request.getParameter("CanhC");

	    try {
	        double a = Double.parseDouble(canha);
	        double b = Double.parseDouble(canhb);
	        double c = Double.parseDouble(canhc);

	        if ((a > 0) && (b > 0) && (c > 0) && (a + b > c) && (a + c > b) && (b + c > a)) {
	            double chuvi = (a + b + c);
	            String uri = request.getRequestURI();
	            if (uri.contains("dien-tich")) {
	                double s = chuvi / 2;
	                double dientich = Math.sqrt(s * (s - a) * (s - b) * (s - c));
	                request.setAttribute("message", "Diện tích tam giác là: " + dientich);
	            } else {
	                request.setAttribute("message", "Chu vi tam giác là: " + chuvi);
	            }
	        } else {
	            request.setAttribute("message", "Không thỏa mãn cạnh của một tam giác");
	        }
	    } catch (NumberFormatException e) {
	        request.setAttribute("message", "Vui lòng nhập vào số cho các cạnh của tam giác.");
	    }
	    request.getRequestDispatcher("/views/Form.jsp").forward(request, response);
	}

}
