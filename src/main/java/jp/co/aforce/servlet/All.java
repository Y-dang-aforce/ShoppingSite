package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class All
 */
@WebServlet(urlPatterns = { "/chapter14/all" })
public class All extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup(
					"java:/comp/env/jdbc/shoppingsite");
			Connection con = ds.getConnection();

			PreparedStatement st = con.prepareStatement(
					"select*from users");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				out.println(rs.getString("MEMBER_ID"));
				out.println(":");
				out.println(rs.getString("PASSWORD"));
			}

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);

	}

}
