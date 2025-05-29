package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.User;

public class UsersDAO extends DAO {
	public List<User> getAllUsers() throws Exception {
		
		List<User> users = new ArrayList<>();
		Connection con = getConnection();
		String sql = "SELECT * FROM users";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			
			String memberId = rs.getString("MEMBER_ID");
			String password = rs.getString("PASSWORD");
			String lastName = rs.getString("LAST_NAME");
			String firstName = rs.getString("FIRST_NAME");
			String address = rs.getString("ADDRESS");
			String mailAddress = rs.getString("MAIL_ADDRESS");
			User user = new User(memberId, password, lastName, firstName, address, mailAddress);
			users.add(user);
		}

		st.close();
		con.close();
		return users;
	}
	public User getUser(String memberId, String password) throws Exception {
		Connection con = getConnection();
		String sql = "SELECT * FROM users WHERE MEMBER_ID=? AND PASSWORD=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberId);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		User user = null;
		if (rs.next()) {
			String lastName = rs.getString("LAST_NAME");
			String firstName = rs.getString("FIRST_NAME");
			String address = rs.getString("ADDRESS");
			String mailAddress = rs.getString("MAIL_ADDRESS");
			user = new User(memberId, password, lastName, firstName, address, mailAddress);
		}

		rs.close();
		st.close();
		con.close();

		return user;
	}

}
