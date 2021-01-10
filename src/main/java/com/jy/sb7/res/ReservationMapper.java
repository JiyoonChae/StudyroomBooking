package com.jy.sb7.res;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {
	
	public int roomConfirm (ReservationVO reservationVO) throws Exception;
	
}
