package edu.poly.admin.severlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.UploadUntils;
import edu.poly.dao.VideoDao;
import edu.poly.model.Video;


@WebServlet({"/Admin/VideoManagement", "/Admin/VideoManagement/create", "/Admin/VideoManagement/update",
		 "/Admin/VideoManagement/delete", "/Admin/VideoManagement/resert",
		 "/Admin/VideoManagement/edit","VideoManagement"})
@MultipartConfig
public class VideoManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (url.contains("edit")) {
			edit(request, response);
			return;
		}
		if (url.contains("delete")) {
			edit(request, response);
			return;
		}
		if (url.contains("reset")) {
			edit(request, response);
			return;
		}
		
		Video video =new Video();
		video.setPoster("./images/click.png");
		findAll(request, response);
	    request.setAttribute("video", video);
		PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("create")) {
			create(request, response);
			return;
		}
		if (url.contains("delete")) {
			edit(request, response);
			return;
		}
		if (url.contains("update")) {
			edit(request, response);
			return;
		}
		if (url.contains("reset")) {
			edit(request, response);
			return;
		}
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		
		
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Video video = new Video();
	    try {
	        BeanUtils.populate(video, request.getParameterMap());
	        video.setPoster("uploads/" + UploadUntils.processUploadField("cover", request,
	                "/uploads", video.getVideoid()));
	        VideoDao dao = new VideoDao();
	        dao.insert(video);
	        
	        request.setAttribute("video", video);
	        request.setAttribute("message", "insert ok");
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", e.getMessage());
	    }
	    findAll(request, response);
	    PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
	}
	
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		try {
			VideoDao dao = new VideoDao();
			List<Video> list = dao.findAll();
			request.setAttribute("videos", list);// gán giá trị list vào thuộc tính "videos"
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
}
