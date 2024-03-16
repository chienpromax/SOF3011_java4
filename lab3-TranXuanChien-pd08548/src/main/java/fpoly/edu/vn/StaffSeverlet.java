package fpoly.edu.vn;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;


@WebServlet("/Staff")
public class StaffSeverlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/FormBai2/Form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			DateTimeConverter dtc = new DateConverter();
			dtc.setPattern("MM/dd/yyyy");
			ConvertUtils.register(dtc, Date.class);
			
			Staff staff = new Staff();
			BeanUtils.populate(staff, request.getParameterMap());
			
			String[] hobbies = request.getParameterValues("hobbies");
		    staff.setHobbies(hobbies);
			
			request.setAttribute("bean", staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/FormBai2/Info.jsp").forward(request, response);
	}
}
