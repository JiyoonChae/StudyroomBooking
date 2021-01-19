package com.jy.sb7.mypage;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jy.sb7.member.MemberVO;
import com.jy.sb7.res.ReservationVO;

@Mapper
@Repository
public interface MyPageMapper {

	public List<ReservationVO> getList() throws Exception;
	
	public List<ReservationVO> getReservationList(ReservationVO reservationVO);
	
}
