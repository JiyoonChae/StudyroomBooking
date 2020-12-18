package com.jy.sb7.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;

	public int setMemberJoin(MemberVO memberVO) throws Exception{
		System.out.println("회원가입 서비스----------");
		return memberMapper.setMemberJoin(memberVO);
	}
	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception{
		System.out.println("왜 안넘어오지?????????");
		return memberMapper.getMemberLogin(memberVO);
	}
}
