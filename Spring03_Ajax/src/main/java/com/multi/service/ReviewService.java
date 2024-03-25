package com.multi.service;

import java.util.List;

import com.multi.domain.ReviewVO;

public interface ReviewService {

	
	int insertReview(ReviewVO rvo);
	
	List<ReviewVO> getReviewList(int pnum); 

	int getReviewCount(int pnum); // 특정 상품에 대한 리뷰글 목록
	
	ReviewVO getReview(int no); //리뷰글번호(PK)로 상품 글 가져오기
	
	int deleteReview(int no);
	
	int updateReview(ReviewVO rvo);
	
}
