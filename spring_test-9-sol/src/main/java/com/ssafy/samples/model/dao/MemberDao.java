package com.ssafy.samples.model.dao;

import java.sql.SQLException;

import com.ssafy.samples.model.User;

public interface MemberDao {

	User selectUser(User user) throws SQLException;

}
