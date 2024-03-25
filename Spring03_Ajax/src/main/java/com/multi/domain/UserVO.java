package com.multi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 인자 생성자 <- 기본 생성자 사라짐
@NoArgsConstructor // 기본 생성자 (매개 변수 안 받음)
public class UserVO {

	private int no;
	private String name;
	private String addr;
	private String phone;

}
