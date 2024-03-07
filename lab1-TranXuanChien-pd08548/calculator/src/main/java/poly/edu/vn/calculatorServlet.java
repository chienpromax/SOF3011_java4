package poly.edu.vn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculatorServlet")
public class calculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public calculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/views/calculator.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double a= Double.parseDouble(request.getParameter("numberA"));
		double b =Double.parseDouble(request.getParameter("numberB"));
		String action = request.getParameter("action");
		double rs = a + b;
		switch (action) {
		case "+": {
			rs = a + b;
			break;
		}
		case "-": {
			rs = a - b;
			break;
		}
		case "*": {
			rs = a * b;
			break;
		}
		case "/": {
			rs = a / b;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
		request.setAttribute("RESULT", rs);
		request.setAttribute("NUMBER_A", a);
		request.setAttribute("NUMBER_B", b);
		request.setAttribute("ACTION", action);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/result.jsp");
		rd.forward(request, response);
	}

}
