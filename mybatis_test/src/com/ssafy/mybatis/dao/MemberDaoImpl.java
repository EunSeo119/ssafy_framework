package com.ssafy.mybatis.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.mybatis.MemberDto;
import com.ssafy.mybatis.config.SqlMapConfig;

public class MemberDaoImpl implements MemberDao {
	
	private final String NAMESPACE = "com.ssafy.mybatis.dao.MemberDao.";

	@Override
	public void joinMember(MemberDto memberDto) throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()){
			// insert 명은 겹치지 않게 하기 위해 namespace + 메소드명
			sqlSession.insert(NAMESPACE + "joinMember", memberDto);
			sqlSession.commit();
		}
	}

	@Override
	public List<MemberDto> listMember() throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()){
			return sqlSession.selectList(NAMESPACE + "listMember");
		}
	}

}
