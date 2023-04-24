package com.ssafy.term9.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.term9.model.Member;
import com.ssafy.term9.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	
private final MemberDao memberDao;
	
	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}


	@Override
	public Member login(Member member) throws Exception {
		return memberDao.selectLogin(member);
	}

}
