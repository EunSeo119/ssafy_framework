package com.ssafy.term9.model.dao;

import java.sql.SQLException;

import com.ssafy.term9.model.Member;


public interface MemberDao {

//	int idCheck(String userId) throws SQLException;
//	int joinMember(Member memberDto) throws SQLException;
//	Member loginMember(String userId, String userPwd) throws SQLException;
	Member selectLogin(Member member) throws SQLException;
}
