package com.jy.sb7.admin.reservation;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jy.sb7.res.ReservationVO;

@Mapper
public interface AdminReservationMapper {

	public List<ReservationVO> getReservationList() throws Exception;
}
