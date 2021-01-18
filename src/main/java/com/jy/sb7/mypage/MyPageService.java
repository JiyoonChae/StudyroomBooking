package com.jy.sb7.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.sb7.res.ReservationVO;
import com.jy.sb7.utill.Pager;

@Service
public class MyPageService {

	@Autowired
	private MyPageMapper mypageMapper;
	
	public PageInfo<ReservationVO> getReservationList(ReservationVO reservationVO, Pager pager) throws Exception {
		List<ReservationVO> list = mypageMapper.getReservationList(reservationVO);
		
		PageHelper.startPage(pager.getPage()+1, pager.getSize());
		PageInfo<ReservationVO> pageInfo = new PageInfo(list);
		
		return pageInfo;
	}
}
