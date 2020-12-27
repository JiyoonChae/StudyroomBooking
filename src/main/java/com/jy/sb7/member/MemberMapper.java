package com.jy.sb7.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	public MemberVO memberCheck(MemberVO memberVO) throws Exception;
	
	//회원가입
	public int setMemberJoin(MemberVO memberVO) throws Exception;
	//login
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception;
}
