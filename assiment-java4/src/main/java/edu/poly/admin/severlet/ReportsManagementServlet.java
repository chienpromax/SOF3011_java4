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
import edu.poly.dao.ShareDao;
import edu.poly.dao.VideoDao;
import edu.poly.domain.FavoriteReport;
import edu.poly.domain.FavoriteUserReport;
import edu.poly.domain.ShareReport;
import edu.poly.model.Share;
import edu.poly.model.Video;

@WebServlet("/ReportsManagement")
public class ReportsManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		reportFavoriteByVideos(request, response);
		reportFavoriteUsersByVideo(request, response);
		findshare(request, response);
		PageInfo.prepareAndForward(request, response, PageType.REPORT_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		reportFavoriteByVideos(request, response);
		reportFavoriteUsersByVideo(request, response);
		findshare(request, response);
	}

	private void findshare(HttpServletRequest request, HttpServletResponse response) {
		String videoUserId = request.getParameter("videoUserId");
		ShareDao shareDAO = new ShareDao();
		List<ShareReport> userShares = shareDAO.getSharesByVideoTitle(videoUserId);
		request.setAttribute("userShares", userShares);
	}

	private void reportFavoriteUsersByVideo(HttpServletRequest request, HttpServletResponse response) {
		try {
			String videoUserId = request.getParameter("videoUserId");
			VideoDao vdao = new VideoDao();
			List<Video> vlist = vdao.findAll();
			if (videoUserId == null && vlist.size() > 0) {
				videoUserId = vlist.get(0).getVideoid();
			}

			FavoriteDao dao = new FavoriteDao();
			List<FavoriteUserReport> list = dao.reportUsersByVideo(videoUserId);
			request.setAttribute("videoUserId", videoUserId);
			request.setAttribute("vidList", vlist);
			request.setAttribute("favUsers", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
	}

	private void reportFavoriteByVideos(HttpServletRequest request, HttpServletResponse response) {
		try {
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteReport> list = dao.reportFavoritesByVideos();
			request.setAttribute("favList", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}
