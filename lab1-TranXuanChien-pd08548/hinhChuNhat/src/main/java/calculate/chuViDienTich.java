package calculate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chuViDienTich")
public class chuViDienTich extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/views/form.jsp");
		rd.forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double a = Double.parseDouble(request.getParameter("numberA"));
		double b = Double.parseDouble(request.getParameter("numberB"));
		double cv = (a + b) * 2; 
		double dt = a * b; 
		
		request.setAttribute("NUMBERA", a);
		request.setAttribute("NUMBERB", b);
		request.setAttribute("CHUVI", cv);
		request.setAttribute("DIENTICH", dt);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/result.jsp");
		rd.forward(request, response);
	}

}
