package fpoly.edu.vn;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

public class CookieUtils {
	public static Cookie add(String name, String value, int hours,
			HttpServletResponse resp) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(hours*60*60);
		cookie.setPath("/");
		resp.addCookie(cookie);
		return cookie;
	}
	public static String get(String name, HttpServletRequest req) {
		Cookie[] cookie = req.getCookies();
		if (cookie != null) {
			for(Cookie cookie1: cookie) {
				if (cookie1.getName().equalsIgnoreCase(name)) {
					return cookie1.getValue();				}
			}
		}
		return "";
	}
	
	
}
