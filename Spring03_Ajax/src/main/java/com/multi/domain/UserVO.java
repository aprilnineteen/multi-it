package com.multi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // ���� ������ <- �⺻ ������ �����
@NoArgsConstructor // �⺻ ������ (�Ű� ���� �� ����)
public class UserVO {

	private int no;
	private String name;
	private String addr;
	private String phone;

}
