package fpoly.edu.vn;

import java.io.IOException;
import java.nio.file.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HitCounterServlet")
public class HitCounterServlet extends HttpServlet {
    int count;
    Path path = Paths.get("C:/Windows/Temp/count.txt");

    public void init(ServletConfig config) throws ServletException {
        try {
            // Đọc số đếm từ tệp và khởi tạo cho count
            count = Integer.parseInt(Files.readAllLines(path).get(0));
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Tăng count lên 1 và chia sẻ count vào request
        count++;
        request.setAttribute("count", count);
        // Chuyển hướng đến hit-counter.jsp
        request.getRequestDispatcher("/views/hit-counter.jsp").forward(request, response);
    }

    public void destroy() {
        try {
            // Lưu số đếm vào tệp trước khi servlet bị hủy
            Files.write(path, String.valueOf(count).getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
