package fpoly.edu.vn;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SenMailServelet")
public class SenMailServelet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Bai5/sendmail.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String name = "xuanchient033@gmail.com";
        final String pass = "ayiw lqih jicy vmgd";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session s = Session.getInstance(prop, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(name, pass);
			}
		});

        String toemail = request.getParameter("to");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		try {
			Message msg = new MimeMessage(s);
			msg.setFrom(new InternetAddress(name));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toemail));
			msg.setSubject(subject);
			msg.setText(content);
			Transport.send(msg);
		} catch (Exception e) {
			System.err.println(e);
		}
		// kiểm tra gửi mail
		if (toemail.equalsIgnoreCase("") || subject.equalsIgnoreCase("") || content.equalsIgnoreCase("")) {
			request.setAttribute("message", "Vui lòng nhập đẩy đủ!");
		} else {
			request.setAttribute("message", "Gửi email thành công!");
		}
		request.getRequestDispatcher("/Bai5/sendmail.jsp").forward(request, response);
	}
}
