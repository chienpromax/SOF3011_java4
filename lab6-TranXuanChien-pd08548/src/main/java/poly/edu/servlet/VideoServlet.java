package poly.edu.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.dao.VideoDao;
import poly.edu.jpautils.JpaUtil;
import poly.edu.model.Report;
import poly.edu.model.User;
import poly.edu.model.Video;

@WebServlet(urlPatterns = { "/cau1", "/cau2", "/cau3", "/cau4", "/cau5", "/cau6", "/cau7", "/cau8", "/cau9", "/bai4C2", "/bai4", })
public class VideoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String url = request.getRequestURI().toString();
		if (url.contains("cau1")) {
			Cau1(request, response);
		} else if (url.contains("cau2")) {
			Cau2(request, response);
		} else if (url.contains("cau3")) {
			Cau3(request, response);
		} else if (url.contains("cau4")) {
			Cau4(request, response);
		}else if (url.contains("cau5")) {
			cau5(request, response);
		}else if (url.contains("cau6")) {
			Cau6(request, response);
		}else if (url.contains("cau7")) {
			Cau7(request, response);
		}else if (url.contains("cau8")) {
			Cau8(request, response);
		}else if (url.contains("cau9")) {
			Cau9(request, response);
		}else if (url.contains("bai4C2")) {
			doBai4C2(request, response);
		}else if (url.contains("bai4")) {
			doBai4(request, response);
		}
	}
	
	private void doBai4C2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        int year = Integer.parseInt(request.getParameter("year"));
	        VideoDao dao = new VideoDao();
	        List<Report> report = dao.favoriteByYear(year);
	        request.setAttribute("report", report);
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Lỗi: " + e.getMessage());
	    }
	    request.getRequestDispatcher("/views/video.jsp").forward(request, response);
	}
	
	private void doBai4(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			VideoDao vdao = new VideoDao();
			request.setAttribute("videos", vdao.random2Video());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi: " + e.getMessage());
		}
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);
	}

	private void Cau9(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VideoDao dao = new VideoDao();
			String keyword = request.getParameter("search");
			request.setAttribute("video", dao.findFavoritesByUserId(keyword));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi: " + e.getMessage());
		}
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);
	}

	private void Cau8(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VideoDao dao = new VideoDao();
			String keyword = request.getParameter("search");
			request.setAttribute("video", dao.findLikeVideoAndKeyWord(keyword));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi: " + e.getMessage());
		}
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);
	}
	
	private void Cau7(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        // 1. Lấy danh sách các tháng được chọn từ request
	        String[] selectedMonths = request.getParameterValues("months");
	        // 2. Chuyển đổi danh sách các tháng từ dạng chuỗi sang dạng số nguyên
	        List<Integer> months = new ArrayList<>();
	        for (String month : selectedMonths) {
	            months.add(Integer.parseInt(month));
	        }
	        VideoDao dao = new VideoDao();
	        List<Video> favoriteVideos = dao.findFavoritesByMonths(months);
	        request.setAttribute("months", favoriteVideos);
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Lỗi: " + e.getMessage());
	    }
	    request.getRequestDispatcher("/views/video.jsp").forward(request, response);
	}


	private void Cau6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        VideoDao dao = new VideoDao();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date minDate = dateFormat.parse(request.getParameter("mindate"));
	        Date maxDate = dateFormat.parse(request.getParameter("maxdate"));
	        List<Video> favoriteVideos = dao.findFavoritesByDateRange(minDate, maxDate);
	        request.setAttribute("video", favoriteVideos);
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Lỗi: " + e.getMessage());
	    }
	    request.getRequestDispatcher("/views/video.jsp").forward(request, response);
	}


	private void cau5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VideoDao dao = new VideoDao();
			request.setAttribute("report", dao.countLikeVideo());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi: " + e.getMessage());
		}
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);
	}

	private void Cau4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				VideoDao dao = new VideoDao();
				Boolean favorite = Boolean.parseBoolean(request.getParameter("favorite"));
				request.setAttribute("videos", dao.findUserLikeOrNotLike(favorite));
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Lỗi: " + e.getMessage());
			}
		}
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);
	}

	protected void Cau3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				VideoDao udao = new VideoDao();
				String videoid = request.getParameter("search");
				if (videoid.equals("")) {
					request.setAttribute("message", "Vui lòng nhập VideoID!");
				} else {
					request.setAttribute("videos", udao.findUserLikeVideo(videoid));
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Lỗi: " + e.getMessage());
			}
		}
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);
	}

	private void Cau2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				VideoDao dao = new VideoDao();
				String keyword = request.getParameter("search");
				if (keyword.equals("")) {
					request.setAttribute("message", "Hãy nhập Từ khóa");
				} else {
					request.setAttribute("video", dao.findVideoFavoriteByTitle(keyword));
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Lỗi: " + e.getMessage());
			}
		}
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);
	}

	private void Cau1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				EntityManager em = JpaUtil.getEntityManager();
				VideoDao vdao = new VideoDao();
				String id = request.getParameter("search");
				if (id.equals("")) {
					request.setAttribute("message", "Vui lòng nhập UserID!");
				} else {
					User user = em.find(User.class, id);
					request.setAttribute("user", user);
					request.setAttribute("video", vdao.findVideoFavoriteByUserID(id));
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Lỗi: " + e.getMessage());
			}
		}
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);
	}

}
