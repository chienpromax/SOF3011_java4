package edu.poly.vn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifecyclesServlet")
public class LifecyclesServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service" + Thread.currentThread().getId());
	}

	@Override
	public void destroy() {
		System.out.println("destroy" + Thread.currentThread().getId());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init" + Thread.currentThread().getId());
	}

	
}
