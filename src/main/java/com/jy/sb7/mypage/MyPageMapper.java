package com.jy.sb7.mypage;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jy.sb7.res.ReservationVO;

@Mapper
@Repository
public interface MyPageMapper {

	public List<ReservationVO> getList() throws Exception;
}
