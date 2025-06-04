package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.beans.userBean;
import jp.co.aforce.dao.UsersDAO;

/**
 * Servlet implementation class userEdit
 */
@WebServlet("/views/userEdit")
public class userEdit extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");
        String lastName1=request.getParameter("lastName");
        String firstName1 = request.getParameter("firstName");
        String address1 = request.getParameter("address");
        String mailAddress1 = request.getParameter("mailAddress");
        HttpSession session = request.getSession();
        
        
        try {
            UsersDAO dao = new UsersDAO();
            User loginUser=dao.getUser(memberId,password);
            System.out.println("取得結果: " + loginUser);
            if (loginUser!=null) {
            	dao.updateUser(memberId,lastName1,firstName1,address1,mailAddress1);
            	userBean user=new userBean(memberId, password, lastName1, firstName1, address1, mailAddress1);           	
            	session.setAttribute("userBean", user);
            	User updatedUser=new User();
            	updatedUser.setMemberId(memberId);
            	updatedUser.setPassword(password);
            	updatedUser.setLastName(lastName1);
            	updatedUser.setFirstName(firstName1);
            	updatedUser.setAddress(address1);
            	updatedUser.setMailAddress(mailAddress1);
            	System.out.println("===== セッション確認 START =====");
            	System.out.println("名前（姓）：" + updatedUser.getLastName());
            	System.out.println("名前（名）：" + updatedUser.getFirstName());
            	System.out.println("住所：" + updatedUser.getAddress());
            	System.out.println("メール：" + updatedUser.getMailAddress());
            	System.out.println("===== セッション確認 END =====");
            	session.setAttribute("user", updatedUser);
                response.sendRedirect("userEditSuccess.jsp");    
            }else {
                response.sendRedirect("error.jsp");
            }
        }catch (Exception e) {
        	System.out.println("例外発生");
        	e.printStackTrace();
        	response.sendRedirect("error.jsp");
        }
	}
	

}
