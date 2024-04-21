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
import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.VideoDao;
import edu.poly.model.Favorite;
import edu.poly.model.Video;


@WebServlet("/FavoriteVideo")
public class FavoriteVideoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");

	    // Lấy tên người dùng đã đăng nhập từ session
	    String username = SessionUtils.getLoginedUsername(request);

	    if (username != null) {
	        FavoriteDao dao = new FavoriteDao();

	        List<Video> favoriteVideos = dao.findAllByUserId(username);

	        if (favoriteVideos != null && !favoriteVideos.isEmpty()) {
	            request.setAttribute("listVideo", favoriteVideos);
	            request.setAttribute("username", username);

	            PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FAVORITE_PAGE);
	        } else {
	            request.setAttribute("message", "Bạn chưa yêu thích video nào, vui lòng quay lại sau.");
	            request.setAttribute("username", username);

	            PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FAVORITE_PAGE);
	        }
	    } else {
	        response.sendRedirect(request.getContextPath() + "/login");
	    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
	}

}
