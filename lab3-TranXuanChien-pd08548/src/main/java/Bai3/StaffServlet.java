package Bai3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import Bai3.StaffModel;


@MultipartConfig
@WebServlet("/staff")
public class StaffServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/Bai3/form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String[] favorites = request.getParameterValues("favorites");
			request.setAttribute("favorites", Arrays.toString(favorites));
			
			DateTimeConverter dtc= new DateConverter(new Date());
			dtc.setPattern("MM/dd/yyyy");
			ConvertUtils.register(dtc, Date.class);
			StaffModel staff= new StaffModel();
			BeanUtils.populate(staff, request.getParameterMap());
			
			String uploadFolder = request.getServletContext().getRealPath("/uploads");
			Path uploadPath = Paths.get(uploadFolder);
			if(!Files.exists(uploadPath)) {
				Files.createDirectory(uploadPath);
			}
			Part imagePart = request.getPart("image");
			String imageFilename = Path.of(imagePart.getSubmittedFileName()).getFileName().toString();
	    	imagePart.write(Paths.get(uploadPath.toString(), imageFilename).toString());	
			//request.setAttribute("image",imageFilename);
	    	
			staff.setImageName(imageFilename);
			request.setAttribute("staff", staff);
			request.getRequestDispatcher("/Bai3/result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
