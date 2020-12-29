package com.jy.sb7.auth;

import lombok.Data;

@Data
public class EmailAuth {
	 //이메일 인증 여부 확인
	  private boolean emailVerified;  
	   //이메일 토큰
	  private String emailCheckToken;
}
