
drop table review;
-- products ���̺��� pnum(pk)�� member ���̺��� userid(pk)�� �ܷ�Ű�� ����
-- �ϴ� ajax�� �����ϰ� �׽�Ʈ�ϱ� ���� �ܷ�Ű ���� �����ϰ� ������ ����.

create table review(
	no number(8) primary key, -- ���� �� ��ȣ
	userid varchar2(20) not null, -- references member(userid) on delete cascade,
	pnum number(8) not null, -- references products(pnum) on delete cascade,
	title varchar2(200) not null, -- ����	
	content varchar2(500), -- ���� �� ����
	score number(1) constraint score_ck check(score>0 and score<=5), -- �� ����
	filename varchar2(300), -- ÷�� ���ϸ�
	wdate date default sysdate
	);
	
	
	drop sequence review_seq;
	
	create sequence review_seq nocache;