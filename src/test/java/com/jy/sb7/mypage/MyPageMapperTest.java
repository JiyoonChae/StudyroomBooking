package com.jy.sb7.mypage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jy.sb7.member.MemberVO;
import com.jy.sb7.res.ReservationVO;
import com.jy.sb7.utill.Pager;

@SpringBootTest
class MyPageMapperTest {
	
	@Autowired
	private MyPageMapper mypageMapper;

	//@Test
	void getListTest() throws Exception {
		List<ReservationVO> list = mypageMapper.getList();
		
		for(ReservationVO reservationVO : list) {
			System.out.println(reservationVO.getRevNum());
			System.out.println(reservationVO.getId());
			System.out.println(reservationVO.getEmail());
			System.out.println(reservationVO.getStartTime());
			System.out.println(reservationVO.getEndTime());
			System.out.println("----------------------");
		}
		assertNotNull(list);
	}
	
	//@Test
	void getAdminListTest() throws Exception {
		ReservationVO reservationVO = new ReservationVO();
		reservationVO.setId("admin");
		
		List<ReservationVO> list = mypageMapper.getList();
		
		for(ReservationVO resVO : list) {
			System.out.println(resVO.getRevNum());
			System.out.println(resVO.getId());
			System.out.println(resVO.getEmail());
			System.out.println(resVO.getStartTime());
			System.out.println(resVO.getEndTime());
			System.out.println("**********");
			System.out.println(resVO.getStudyRoomsVO().getRoomNum());
			System.out.println(resVO.getStudyRoomsVO().getFileUrl());
			System.out.println("-----------------------------");
		}
		
		assertNotNull(list);
	}
	
	@Test
	void getReservationListTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		//memberVO.setId("admin");
		ReservationVO reservationVO = new ReservationVO();
		reservationVO.setId("admin");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member", memberVO);
		
		List<ReservationVO> list = mypageMapper.getReservationList(reservationVO);
		Page<ReservationVO> page = PageHelper.startPage(0, 10);
		
		for(ReservationVO reservation : list) {
			System.out.println(reservation.getId());
			System.out.println(reservation.getRoomDate());
			System.out.println(reservation.getRoomPrice());
			System.out.println(reservation.getStudyRoomsVO().getFileUrl());
			System.out.println("----------------");
		}
		
		
//		System.out.println(page.getPageSize());
//		reservationVO = page.get(0); 
//		
//		System.out.println(reservationVO.getId());
//		System.out.println(reservationVO.getRoomDate());
//		System.out.println(reservationVO.getRoomPrice());
//		System.out.println(reservationVO.getStudyRoomsVO().getFileUrl());
		
		assertNotNull(list);
	}

}
