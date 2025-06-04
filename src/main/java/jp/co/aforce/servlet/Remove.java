package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class CartRemove
 */
@WebServlet(urlPatterns = { "/views/remove" })
public class Remove extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);

		HttpSession session = request.getSession();
		session.removeAttribute("user");
		System.out.println(session.getAttribute("user"));
		session.removeAttribute("userBean");
		System.out.println(session.getAttribute("userBean"));
		
		Page.footer(out);
		response.sendRedirect("userLogout.jsp");
	}

}
