 package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.User;

public class UsersDAO extends DAO {
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
			user = new User(lastName, firstName, address, mailAddress);
		}

		rs.close();
		st.close();
		con.close();

		return user;
	}

}
