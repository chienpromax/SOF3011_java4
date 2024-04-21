package edu.poly.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashedMap();
    static {
        pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management", "/admin/users/users.jsp", null));
        pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("User Management", "/admin/reports/reports.jsp", null));
        pageRoute.put(PageType.VIDEOS_MANAGEMENT_PAGE, new PageInfo("User Management", "/admin/videos/videos.jsp", null));
        pageRoute.put(PageType.HOME_MANAGEMENT_PAGE, new PageInfo("home Management", "/admin/home/homeAdmin.jsp", null));
        
        pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Home", "/sites/home/home.jsp", null));
        pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("login", "/sites/users/login.jsp", null));
        pageRoute.put(PageType.SITE_REGISTRATION_PAGE, new PageInfo("registration", "/sites/users/registration.jsp", null));
        pageRoute.put(PageType.SITE_CHANGE_PASSWORD_PAGE, new PageInfo("change-password", "/sites/users/change-password.jsp", null));
        pageRoute.put(PageType.SITE_EDIT_PROFILE_PAGE, new PageInfo("edit-profile", "/sites/users/edit-profile.jsp", null));
        pageRoute.put(PageType.SITE_FORGOT_PASSWORD_PAGE, new PageInfo("forgot-password", "/sites/users/forgot-password.jsp", null));
        pageRoute.put(PageType.SITE_FAVORITE_PAGE, new PageInfo("favorite", "/sites/videos/favorite.jsp", null));
        pageRoute.put(PageType.SITE_VIDEO_DETAIL_PAGE, new PageInfo("detail", "/sites/videos/detail.jsp", null));
        pageRoute.put(PageType.SITE_SHARE_PAGE, new PageInfo("share", "/sites/videos/share.jsp", null));
    }

    public static void prepareAndForward(HttpServletRequest request, HttpServletResponse response, PageType pageType) throws ServletException, IOException {
        PageInfo page = pageRoute.get(pageType);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/admin/layout.jsp").forward(request, response);
    }
    
	public static void prepareAndForwardSite(HttpServletRequest request, HttpServletResponse response,
			PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/sites/layout.jsp").forward(request, response);
	}

    private String title;
    private String contentUrl;
    private String scriptUrl;
    
	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}

}
