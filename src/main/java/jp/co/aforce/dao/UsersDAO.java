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
			memberId = rs.getString("MEMBER_ID");
			password = rs.getString("PASSWORD");
			String lastName = rs.getString("LAST_NAME");
			String firstName = rs.getString("FIRST_NAME");
			String address = rs.getString("ADDRESS");
			String mailAddress = rs.getString("MAIL_ADDRESS");
			user = new User(memberId,password,lastName, firstName, address, mailAddress);
		}

		rs.close();
		st.close();
		con.close();

		return user;
	}

	public void addUser(String memberId, String password, String lastName, String firstName, String address,
			String mailAddress) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"insert into users(member_id, password, last_name, first_name, address, mail_address) values(?,?,?,?,?,?)");
		st.setString(1, memberId);
		st.setString(2, password);
		st.setString(3, lastName);
		st.setString(4, firstName);
		st.setString(5, address);
		st.setString(6, mailAddress);
		st.executeUpdate();

		st.close();
		con.close();

	}

	public void updateUser(String memberId, String lastName, String firstName, String address, String mailAddress)
			throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"UPDATE users SET last_name=?, first_name=?, address=?, mail_address=? WHERE member_id=?");
		st.setString(1, lastName);
		st.setString(2, firstName);
		st.setString(3, address);
		st.setString(4, mailAddress);
		st.setString(5, memberId);
		st.executeUpdate();

		st.close();
		con.close();
	}
	
	public void deleteUser(String memberId) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
			"DELETE FROM users WHERE member_id = ?");
		st.setString(1, memberId);
		st.executeUpdate();
		int rows = st.executeUpdate();
		System.out.println("削除件数：" + rows); 
		
		st.close();
		con.close();
	}

}
