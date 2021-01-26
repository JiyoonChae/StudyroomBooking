package com.jy.sb7.res;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.sb7.member.MemberVO;


@Service
public class ReservationService {
	@Autowired
	private ReservationMapper reservationMapper;
	
	public int roomConfirm(MemberVO memberVO) throws Exception{
		/*
		 * List<ReservationVO> list = new ArrayList<ReservationVO>(); for(int i=0; i<
		 * memberVO.getReservationVO().size(); i++) { if(i==0) { MemberVO memberVO = new
		 * Member } }
		 */
		/*
		 * System.out.println("리스트는 : "+memberVO.getReservationVO()); long num =
		 * memberVO.getReservationVO().get(0).getRevNum();
		 */
		System.out.println("service --------------");
		//System.out.println("number: " +num);
		
		/*
		 * for(MemberVO i : memberVO.getReservationVO()) { System.out.println(i);
		 * 
		 * }
		 */
		return reservationMapper.roomConfirm(memberVO);
	}
	
	public MemberVO getResInfo(ReservationVO resVO) throws Exception{
		return reservationMapper.getResInfo(resVO);
	}
}
