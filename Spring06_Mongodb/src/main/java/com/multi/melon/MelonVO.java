package com.multi.melon;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class MelonVO {

	@Id
	private String id;

	private String rank; // ����
	private String title; // �뷡 ����
	private String singer; // ����
	private String albumImage; // �ٹ� �̹���
}
