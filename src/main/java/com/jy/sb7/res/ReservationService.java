package com.jy.sb7.res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservationService {
	@Autowired
	private ReservationMapper reservationMapper;
	
	public int roomConfirm(ReservationVO reservationVO) throws Exception{
		return reservationMapper.roomConfirm(reservationVO);
	}
	
	public ReservationVO getResInfo(ReservationVO resVO) throws Exception{
		return reservationMapper.getResInfo(resVO);
	}
}
