package com.board.domain;

import lombok.Data;

@Data
public class BoardVO {

	private String mode; //write (���۾���), edit (�� ����), rewrite (�亯 �۾���)
	private int newImg;
	
	private int num;
	private String userid;
	private String passwd;
	
	private String subject;
	private String content;
	
	private java.sql.Date wdate;
	private int readnum;
	
	private String filename; //������ ���ϸ�(uuid_���ϸ�.txt)
	private String originFilename; //���� ���ϸ� (���ϸ�.txt)
	private long filesize; //÷������
	
	private String old_filename; //������ ÷���� ���ϸ� -> �� ����/���� �� �ʿ�
	
	//�亯�� �Խ��ǿ� �ʿ��� ������Ƽ
	private int refer; // �� �׷� ��ȣ
	private int lev; //�亯 ����
	private int sunbun; //���� �� �׷� �� ����(����)
}