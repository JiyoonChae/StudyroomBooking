package com.jy.sb7.mypage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jy.sb7.res.ReservationVO;

@SpringBootTest
class MyPageMapperTest {
	
	@Autowired
	private MyPageMapper mypageMapper;

	@Test
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

}
