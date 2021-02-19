package com.jy.sb7.mypage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.sb7.member.MemberVO;
import com.jy.sb7.res.ReservationVO;
import com.jy.sb7.utill.Pager;

@SpringBootTest
class MyPageMapperTest {
	
	@Autowired
	private MyPageMapper mypageMapper;

	
	@Test
	void getMemberReservationListTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("admin");
		List<ReservationVO> list = mypageMapper.getMemberReservationList(memberVO);
		
		System.out.println(memberVO.getId());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for(ReservationVO reservationVO : list) {
			System.out.println(reservationVO.getRevNum());
			System.out.println(reservationVO.getStartTime());
			System.out.println(reservationVO.getEndTime());
			System.out.println(reservationVO.getRoomTime());
			System.out.println(reservationVO.getRoomUser());
			System.out.println(reservationVO.getRoomDate());
			System.out.println(reservationVO.getRoomType());
			System.out.println(reservationVO.getRoomPrice());
			System.out.println("---------------------");
			System.out.println(reservationVO.getStudyRoomsVO().getRoomName());
			System.out.println(reservationVO.getStudyRoomsVO().getFileUrl());
		}
		
		assertNotNull(list);
		
	}
	
	
	
	
	//@Test
	void getListTest() throws Exception {
		List<ReservationVO> list = mypageMapper.getList();
		
		for(ReservationVO reservationVO : list) {
			System.out.println(reservationVO.getRevNum());
//			System.out.println(reservationVO.getId());
//			System.out.println(reservationVO.getEmail());
			System.out.println(reservationVO.getStartTime());
			System.out.println(reservationVO.getEndTime());
			System.out.println("----------------------");
		}
		assertNotNull(list);
	}
	
	

	//@Test
//	void getAdminListTest() throws Exception {
//		ReservationVO reservationVO = new ReservationVO();
//		reservationVO.setId("admin");
//		
//		List<ReservationVO> list = mypageMapper.getList();
//		
//		for(ReservationVO resVO : list) {
//			System.out.println(resVO.getRevNum());
//			System.out.println(resVO.getId());
//			System.out.println(resVO.getEmail());
//			System.out.println(resVO.getStartTime());
//			System.out.println(resVO.getEndTime());
//			System.out.println("**********");
//			System.out.println(resVO.getStudyRoomsVO().getRoomNum());
//			System.out.println(resVO.getStudyRoomsVO().getFileUrl());
//			System.out.println("-----------------------------");
//		}
//		
//		assertNotNull(list);
//	}
//	
//	@Test
//	void getReservationListTest() throws Exception {
////		MemberVO memberVO = new MemberVO();
////		memberVO.setId("admin");
////		HashMap<String, Object> map = new HashMap<String, Object>();
////		map.put("member", memberVO);
//		
//		ReservationVO reservationVO = new ReservationVO();
//		reservationVO.setId("admin");
//		
//		Pager pager = new Pager();
//		pager.setPage(1);
//		pager.setSize(4);
//		
//		List<ReservationVO> list = mypageMapper.getReservationList(reservationVO);
//		PageHelper.startPage(pager.getPage(), pager.getSize());
//		
//		PageInfo<ReservationVO> pageInfo = new PageInfo(list);
//		
//		//PageInfo<ReservationVO> pageInfo = mypageMapper.getReservationList(reservationVO);
//		
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		System.out.println("Page Num : "+ pageInfo.getPageNum());
//		System.out.println("Total : " + pageInfo.getTotal());
//		System.out.println("TotalPage = Page Size : " + pageInfo.getPageSize());
//		System.out.println("Start Row : " + pageInfo.getStartRow());
//		System.out.println("End Row : " + pageInfo.getEndRow());
//		System.out.println("Pre Page : " + pageInfo.getPrePage());
//		System.out.println("Next Page : " + pageInfo.getNextPage());
//		System.out.println("First Page : " + pageInfo.getNavigateFirstPage());
//		System.out.println("Last Page : " + pageInfo.getNavigateLastPage());
//		System.out.println("Get Pages : " + pageInfo.getPages());
//		System.out.println("Has Pre? : " + pageInfo.isHasPreviousPage());
//		System.out.println("Has Next? : " + pageInfo.isHasNextPage());
//		System.out.println("Get List 0 : " + pageInfo.getList().get(0));
//		System.out.println("Is First Page? : " + pageInfo.isIsFirstPage());
//		System.out.println("Is Last Page? : " + pageInfo.isIsLastPage());
//		
//		
//		for(ReservationVO reservation : pageInfo.getList()) {
//			System.out.println(reservation.getId());
//			System.out.println(reservation.getRoomDate());
//			System.out.println(reservation.getRoomPrice());
//			System.out.println(reservation.getStudyRoomsVO().getFileUrl());
//			System.out.println("----------------");
//		}
//		assertEquals(2, pageInfo.getTotal());
//	}

}
