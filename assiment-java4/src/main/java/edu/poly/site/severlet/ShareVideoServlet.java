package edu.poly.site.severlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.EmailUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.ShareDao;
import edu.poly.domain.Email;
import edu.poly.model.Share;
import edu.poly.model.User;
import edu.poly.model.Video;

/**
 * Servlet implementation class ShareServlet
 */
@WebServlet("/ShareVideo")
public class ShareVideoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (!SessionUtils.isLogin(request)) {
			response.sendRedirect("login");
			return;
		}
		String videoId = request.getParameter("videoId");
		if (videoId == null) {
			response.sendRedirect("/Homepage");
			return;
		}
		request.setAttribute("videoId", videoId);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_SHARE_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			String emailFrom = "xuanchient033@gmail.com";
			String passForm = "ayiw lqih jicy vmgd";
			String emailAddress = request.getParameter("email");
			String videoId = request.getParameter("videoId");
			request.setAttribute("videoId", videoId);
			if (videoId == null) {
				request.setAttribute("error", "Video Id is null");
			} 
			else {
				
				Email email = new Email();
				email.setFrom(emailFrom);
				email.setFromPassword(passForm);
				email.setTo(emailAddress);
				email.setSubject("Share favorite video");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear Ms/Mr .<br>");
				sb.append("The video is more interesting and I want to share with you.<br>");
				sb.append("Please click the link").append(String.format("<a href='http://localhost:8080/PolyAss/admin/detail?videoId=</a><br>"+videoId));
				sb.append("Regards<br>");
				sb.append("Administrator");
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				ShareDao dao= new ShareDao();
				Share share = new Share();
				share.setEmail(emailAddress);
				share.setShareDate(new Date());
				
				String username = SessionUtils.getLogInedUsername(request);
				User user = new User();
				user.setUsername(username);
				share.setUser(user);
				Video video = new Video();
				video.setVideoid(videoId);
				
				dao.insert(share);
			
				
				request.setAttribute("message", "Video share ok");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_SHARE_PAGE);
	}
	}


