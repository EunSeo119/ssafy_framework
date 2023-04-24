package com.ssafy.samples.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.samples.model.User;

@Repository
public class MemberDaoImpl implements MemberDao {

	private DataSource dataSource;

	public MemberDaoImpl(javax.sql.DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public User selectUser(User user) throws SQLException {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("select * from members where user_id = ? and user_password = ? ");) {
			int idx = 0;
			pstmt.setString(++idx, user.getUserId());
			pstmt.setString(++idx, user.getUserPassword());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				User result = new User();

				result.setUserId(rs.getString("user_id"));
				result.setUserName(rs.getString("user_name"));
				result.setUserPassword(rs.getString("user_password"));
				result.setEmailId(rs.getString("email_id"));
				result.setEmailDomain(rs.getString("email_domain"));
				result.setJoinDate(rs.getString("join_date"));

				return result;
			}
			return null;
		}
	}

}
