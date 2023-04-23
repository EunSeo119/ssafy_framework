package com.ssafy.samples.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.samples.model.User;
import com.ssafy.samples.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;

	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public User login(User user) throws Exception {
		return memberDao.selectUser(user);
	}

}
