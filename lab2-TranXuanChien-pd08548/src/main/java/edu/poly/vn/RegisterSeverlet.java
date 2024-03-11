package edu.poly.vn;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterSeverlet")
public class RegisterSeverlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usename = request.getParameter("name");
		String pass = request.getParameter("pass");
		String[] hobbies = request.getParameterValues("favs");
		request.setAttribute("message",
		String.format("Username: %s , Pass: %s , hobbies %s", usename, pass, Arrays.toString(hobbies)));
		doGet(request, response);
	}

}
