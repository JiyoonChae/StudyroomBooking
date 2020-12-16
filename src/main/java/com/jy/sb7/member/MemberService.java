package com.jy.sb7.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;

	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception{
		return memberMapper.getMemberLogin(memberVO);
	}
}
