package edu.poly.site.severlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.VideoDao;
import edu.poly.model.Video;

@WebServlet("/Homepage")
public class HomePageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
	    try {
	        VideoDao dao = new VideoDao();
	        List<Video> list = dao.findAll();
	        
	        int page = 1;
	        int recordsPerPage = 6;
	        if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
	        
	        int startIndex = (page - 1) * recordsPerPage;
	        int endIndex = Math.min(startIndex + recordsPerPage, list.size());
	        
	        List<Video> sublist = list.subList(startIndex, endIndex);
	        
	        request.setAttribute("videos", sublist);
	        request.setAttribute("currentPage", page);
	        request.setAttribute("totalPages", (int) Math.ceil((double) list.size() / recordsPerPage));
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", e.getMessage());
	    }
	    PageInfo.prepareAndForwardSite(request, response, PageType.SITE_HOME_PAGE);
	}


//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
//		request.setCharacterEncoding("UTF-8");
//		try {
//			VideoDao dao = new VideoDao();
//			List<Video> list = dao.findAll(); // lưu danh sách video vào list
//			request.setAttribute("videos", list);
//		} catch (Exception e) {
//			e.printStackTrace();
//
//			request.setAttribute("error", e.getMessage());
//		}
//		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_HOME_PAGE);
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
