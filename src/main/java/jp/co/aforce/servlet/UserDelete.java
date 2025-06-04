package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.UsersDAO;

@WebServlet(urlPatterns = { "/views/userDelete" })
public class UserDelete extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		try {
			UsersDAO dao = new UsersDAO();
			dao.deleteUser(memberId);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		response.sendRedirect("userDeleteSuccess.jsp");

	}

}