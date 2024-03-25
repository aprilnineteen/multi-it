package com.multi.mapper;

import java.util.List;

import com.multi.domain.ReviewVO;

public interface ReviewMapper {
	
	int insertReview(ReviewVO rvo);
	
	List<ReviewVO> getReviewList(int pnum); 

	int getReviewCount(int pnum); // Ư�� ��ǰ�� ���� ����� ���
	
	ReviewVO getReview(int no); //����۹�ȣ(PK)�� ��ǰ �� ��������
	
	int deleteReview(int no);
	
	int updateReview(ReviewVO rvo);
	
}
