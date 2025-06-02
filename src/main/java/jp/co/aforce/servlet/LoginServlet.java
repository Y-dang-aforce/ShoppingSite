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


@WebServlet("/views/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        
        try {
            UsersDAO dao = new UsersDAO();// データベース操作用の UsersDAO インスタンスを作成します
            User user=dao.getUser(memberId,password);//getUserを使って結果はuserです
            if (user!=null) {
            	session.setAttribute("user", user);//ユーザー情報をセッションに保存します（ログイン状態の保持）
                response.sendRedirect("user-menu.jsp");
            } else {            	
            	response.sendRedirect("login-error.jsp");
            }
        }catch (Exception e) {
        	throw new ServletException(e);
        }
        
	}
}
