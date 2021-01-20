package com.jy.sb7.admin.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.sb7.res.ReservationVO;

@Service
public class AdminReservationService {

	@Autowired
	private AdminReservationMapper adminReservationMapper;
	
	public List<ReservationVO> getReservationList() throws Exception {
		return adminReservationMapper.getReservationList();
	}
}
