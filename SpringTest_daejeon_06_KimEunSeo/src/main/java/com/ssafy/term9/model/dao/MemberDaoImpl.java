package com.ssafy.term9.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.term9.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	private DataSource dataSource;

	public MemberDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Member selectLogin(Member member) throws SQLException {
		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
				"select userid, name, userpw from userinfo where userid = ? and userpw = ?"
			);
		){
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getUserpw());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Member userInfo = new Member();
				userInfo.setUserid(rs.getString("userid"));
				userInfo.setUserpw(rs.getString("userpw"));
				userInfo.setName(rs.getString("name"));
				return userInfo;
			}
		}
		return null;
	}

//	@Override
//	public int idCheck(String userId) throws SQLException {
//		int cnt = 1;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = dataSource.getConnection();
//			StringBuilder loginMember = new StringBuilder();
//			loginMember.append("select count(user_id) \n");
//			loginMember.append("from members \n");
//			loginMember.append("where user_id = ? ");
//			pstmt = conn.prepareStatement(loginMember.toString());
//			pstmt.setString(1, userId);
//			rs = pstmt.executeQuery();
//			rs.next();
//			cnt = rs.getInt(1);
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//		return cnt;
//	}
//
//	@Override
//	public int joinMember(Member memberDto) throws SQLException {
//		int cnt = 0;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = dataSource.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("insert into members (user_name, user_id, user_password, email_id, email_domain, join_date) \n");
//			sql.append("values (?, ?, ?, ?, ?, now())");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setString(1, memberDto.getUserName());
//			pstmt.setString(2, memberDto.getUserId());
//			pstmt.setString(3, memberDto.getUserPwd());
//			pstmt.setString(4, memberDto.getEmailId());
//			pstmt.setString(5, memberDto.getEmailDomain());
//			cnt = pstmt.executeUpdate();
//		} finally {
//			dbUtil.close(pstmt, conn);
//		}
//		return cnt;
//	}
//
//	@Override
//	public Member loginMember(String userId, String userPwd) throws SQLException {
//		Member memberDto = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = dataSource.getConnection();
//			StringBuilder loginMember = new StringBuilder();
//			loginMember.append("select user_id, user_name \n");
//			loginMember.append("from members \n");
//			loginMember.append("where user_id = ? and user_password = ? \n");
//			pstmt = conn.prepareStatement(loginMember.toString());
//			pstmt.setString(1, userId);
//			pstmt.setString(2, userPwd);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				memberDto = new Member();
//				memberDto.setUserId(rs.getString("user_id"));
//				memberDto.setUserName(rs.getString("user_name"));
//			}
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//		return memberDto;
//	}

}
