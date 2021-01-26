package com.jy.sb7.res;

import org.apache.ibatis.annotations.Mapper;

import com.jy.sb7.member.MemberVO;

@Mapper
public interface ReservationMapper {
	
	public MemberVO getResInfo(ReservationVO resVO) throws Exception;
	
	public int roomConfirm (MemberVO memberVO) throws Exception;
	
}
