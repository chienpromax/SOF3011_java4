package edu.poly.site.severlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.model.Favorite;
import edu.poly.model.User;
import edu.poly.model.Video;


@WebServlet("/LikeVideo")
public class LikeVideoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (!SessionUtils.isLogin(request)) {
			response.sendRedirect("login");
			return;
		}
		String page = request.getParameter("page");
		String videoId = request.getParameter("videoId");
		if (videoId == null) {
			response.sendRedirect("/Homepage");
			return;
		}
		try {
			FavoriteDao dao = new FavoriteDao();
			Favorite fav = new Favorite();
			Video video = new Video();
			video.setVideoid(videoId);
			fav.setVideo(video);
			
			String username = SessionUtils.getLoginedUsername(request);
			User user = new User();
			user.setUsername(username);
			fav.setUser(user);
			
			fav.setLikeDate(new Date());
			dao.insert(fav);
			
			request.setAttribute("message", "you like this video: " + videoId);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		if (page == null) {
			page = "/Homepage";
		}
		request.getRequestDispatcher(page).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}

}
