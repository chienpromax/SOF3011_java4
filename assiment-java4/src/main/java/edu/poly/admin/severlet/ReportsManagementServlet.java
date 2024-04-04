package edu.poly.admin.severlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import org.apache.jasper.tagplugins.jstl.core.If;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.VideoDao;
import edu.poly.domain.FavoriteUserReport;
import edu.poly.model.Video;

@WebServlet("/ReportsManagement")
public class ReportsManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reportFavoritUserByVideo(request, response);
		PageInfo.prepareAndForward(request, response, PageType.REPORT_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void reportFavoritUserByVideo(HttpServletRequest request, HttpServletResponse response) {
	    try {
	        String videoUserId = request.getParameter("videoUserId");

	        VideoDao vdao = new VideoDao();
	        List<Video> vlist = vdao.findAll();

	        if (videoUserId == null && vlist.size() > 0) {
				videoUserId = vlist.get(0).getVideoid();
			}

	        FavoriteDao dao = new FavoriteDao();
	        List<FavoriteUserReport> list = dao.reportFavoriteUserByVideo(videoUserId);

	        request.setAttribute("videoUserId", videoUserId);
	        request.setAttribute("vidList", vlist);
	        request.setAttribute("favUser", list);
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Error" + e.getMessage());
	    }
	}
}
