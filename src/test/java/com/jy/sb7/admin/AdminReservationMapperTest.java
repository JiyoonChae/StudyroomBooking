package com.jy.sb7.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jy.sb7.admin.reservation.AdminReservationMapper;
import com.jy.sb7.res.ReservationVO;

@SpringBootTest
class AdminReservationMapperTest {

	@Autowired
	private AdminReservationMapper adminReservationMapper;
	
	@Test
	void getResrvationListTest() throws Exception {
		List<ReservationVO> list = adminReservationMapper.getReservationList();
		
		for(ReservationVO reservationVO : list) {
			System.out.println(reservationVO.getNum());
			System.out.println(reservationVO.getId());
			System.out.println(reservationVO.getRoomDate());
			System.out.println(reservationVO.getStartTime());
			System.out.println(reservationVO.getEndTime());
			System.out.println(reservationVO.getRoomUser());
			System.out.println("----------------------");
		}
		assertNotNull(list);
	}

}
