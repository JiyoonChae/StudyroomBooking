package com.jy.sb7.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jy.sb7.member.MemberService;
import com.jy.sb7.member.MemberVO;

@RestController // data만 리턴해줄 것
public class MemberApiController {
		@Autowired
		private MemberService memberService;
	
		@PostMapping("/api/member")
		public int save(@RequestBody MemberVO memberVO) throws Exception {
			System.out.println("userapiController 호출"); 
			//db에 insert를 하기.
			int result = memberService.setMemberJoin(memberVO);
			return result;
		}
}
