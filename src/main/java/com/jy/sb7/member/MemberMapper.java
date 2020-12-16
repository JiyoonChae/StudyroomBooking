package com.jy.sb7.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	//login
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception;
}
