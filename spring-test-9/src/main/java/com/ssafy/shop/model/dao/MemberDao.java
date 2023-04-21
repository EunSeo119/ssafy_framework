package com.ssafy.shop.model.dao;

import java.sql.SQLException;

import com.ssafy.shop.model.Member;

public interface MemberDao {

//	int idCheck(String userId) throws SQLException;
//	int joinMember(Member memberDto) throws SQLException;
//	Member loginMember(String userId, String userPwd) throws SQLException;
	Member selectLogin(Member member) throws SQLException;
}
