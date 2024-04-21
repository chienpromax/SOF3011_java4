package edu.poly.site.severlet;

import java.io.IOException;
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

@WebServlet("/UnLike")
public class UnLikeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = SessionUtils.getLoginedUsername(request); // Lấy username từ session
        String videoId = request.getParameter("videoId");
        if (username == null) {
            PageInfo.prepareAndForwardSite(request, response, PageType.SITE_LOGIN_PAGE);
            return;
        }

        try {
            FavoriteDao dao = new FavoriteDao();
            dao.deleteFavorite(username, videoId);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/Homepage");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

