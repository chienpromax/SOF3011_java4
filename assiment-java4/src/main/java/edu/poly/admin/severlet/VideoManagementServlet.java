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

@WebServlet({ "/Admin/VideoManagement", "/Admin/VideoManagement/create", "/Admin/VideoManagement/update",
		"/Admin/VideoManagement/delete", "/Admin/VideoManagement/resert", "/Admin/VideoManagement/edit",
		"/VideoManagement"})
@MultipartConfig
public class VideoManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (url.contains("edit")) {
			edit(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("resert")) {
			resert(request, response);
			return;
		}

		Video video = new Video();
		video.setPoster("./images/click.png");
		findAll(request, response);
		request.setAttribute("video", video);
		PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("create")) {
			create(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("update")) {
			update(request, response);
			return;
		}
		if (url.contains("resert")) {
			resert(request, response);
			return;
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			VideoDao dao = new VideoDao();
			Video oldVideo = dao.findById(video.getVideoid());
			if (request.getPart("cover").getSize() == 0) {
				oldVideo.setPoster(oldVideo.getPoster());

			} else {
				video.setPoster("uploads/" + UploadUntils.processUploadField("cover", request, "/uploads", null));
			}
			if (video.getVideoid() == null || video.getVideoid().isEmpty() || video.getTitle() == null
					|| video.getTitle().isEmpty() || video.getViews() == 0) {
				request.setAttribute("error", "Vui lòng điền đầy đủ thông tin.");
			} else {
				dao.update(video);
				request.setAttribute("video", video);
				request.setAttribute("message", "updated video thành công!");
				findAll(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoid");
		if (id == null) {
			request.setAttribute("error", "Video ID is required!");
			PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
			return;
		}
		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);
			if (video == null) {
				request.setAttribute("error", "Không tìm thấy video với ID: " + id);
				PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
				return;
			}
			if (video.getVideoid() == null || video.getVideoid().isEmpty() || video.getTitle() == null
					|| video.getTitle().isEmpty() || video.getViews() == 0) {
				request.setAttribute("error", "Vui lòng điền đầy đủ thông tin.");
			} else {
				dao.delete(id);
				request.setAttribute("message", "Xóa thành công!");
				request.setAttribute("video", new Video());
				findAll(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi: " + e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		if (id == null) {
			request.setAttribute("error", "Video ID is required!");
			PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
			return;
		}
		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);
			request.setAttribute("video", video);
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {
			// Lấy dữ liệu từ request và gán vào video
			BeanUtils.populate(video, request.getParameterMap());

			if (video.getVideoid() == null || video.getVideoid().isEmpty() || video.getTitle() == null
					|| video.getTitle().isEmpty() || video.getViews() == 0) {
				request.setAttribute("error", "Vui lòng điền đầy đủ thông tin.");
			} else {
				video.setPoster(
						"uploads/" + UploadUntils.processUploadField("cover", request, "/uploads", video.getVideoid()));
				VideoDao dao = new VideoDao();
				dao.insert(video);

				request.setAttribute("video", video);
				request.setAttribute("message", "Thêm video thành công!");
			}
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
			request.setAttribute("videos", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	private void resert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		video.setPoster("images/click.png");
		request.setAttribute("video", video);
		findAll(request, response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
	}
}
