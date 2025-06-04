package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.UsersDAO;

/**
 * Servlet implementation class userAddConfirm
 */
@WebServlet("/views/userAddConfirm")
public class userAddConfirm extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");
        String lastName=request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String address = request.getParameter("address");
        String mailAddress = request.getParameter("mailAddress");
        HttpSession session = request.getSession();
        
        try {
            UsersDAO dao = new UsersDAO();
            User user=dao.getUser(memberId,password);
            if (user!=null) {
            	session.setAttribute("user", user);
                response.sendRedirect("registrationError.jsp");
            } else {
            	dao.addUser(memberId,password,lastName,firstName,address,mailAddress);
            	response.sendRedirect("userSuccess.jsp");
            }
        }catch (Exception e) {
        	throw new ServletException(e);
        }
	}

}
