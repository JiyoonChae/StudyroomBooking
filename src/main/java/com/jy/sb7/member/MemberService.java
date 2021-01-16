package com.jy.sb7.member;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	public MemberVO findMyId(MemberVO memberVO) throws Exception {
		return memberMapper.findMyId(memberVO);
	}

	public MemberVO emailCheck(MemberVO memberVO) throws Exception{
		return memberMapper.emailCheck(memberVO);
	}
	public MemberVO memberCheck(MemberVO memberVO) throws Exception{
		return memberMapper.memberCheck(memberVO);
	}
	
	@Transactional
	public int setMemberJoin(MemberVO memberVO) throws Exception{
		System.out.println("회원가입 서비스----------");
		return memberMapper.setMemberJoin(memberVO); 
	}
	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception{
		System.out.println("로그인 서비스--------");
		return memberMapper.getMemberLogin(memberVO);
	}
}
