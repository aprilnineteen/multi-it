package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.board.domain.BoardVO;
import com.board.domain.PagingVO;
import com.multi.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service("boardService")
@RequiredArgsConstructor //생성자 주입
@Log4j
public class BoardServiceImpl implements BoardService {

	private final BoardMapper bMapper;
	
	@Override
	public int insertBoard(BoardVO board) {
		return bMapper.insertBoard(board);
	}

	@Override
	public List<BoardVO> getBoardAll(PagingVO paging) {
		// TODO Auto-generated method stub
		return bMapper.getBoardAll(paging);
	}

	@Override
	public int getTotalCount(PagingVO paging) {
		return bMapper.getTotalCount(paging);
	}

	@Override
	public BoardVO selectBoardByNum(int num) {
		// TODO Auto-generated method stub
		return bMapper.selectBoardByNum(num);
	}

	@Override
	public int updateReadnum(int num) {
		return bMapper.updateReadnum(num);
	}

	@Override
	public int deleteBoard(int num) {
		// TODO Auto-generated method stub
		return bMapper.deleteBoard(num);
	}

	@Override
	public int updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return bMapper.updateBoard(board);
	}

	//답변 글쓰기	-------------------------
	
	@Override
	public int rewriteBoard(BoardVO board) {
		//[1] 부모글(원글) 글번호(num)로 부모글의 refer(글그룹번호), lev(답변레벨), sunbun(순서) 가져오기
		BoardVO parent = this.selectRefLevSunbun(board.getNum());
		log.info("parent: "+parent);
		//[2] 기존에 달린 답변글이 있다면, 내 답변글을 insert하기 전에 기존 답변글의 순서를 하나씩 증가하자
		this.updateSunbun(parent);
		//[3] 내가 쓴 답변 글을 insert한다 == insert문
		//내가 쓴 답변 글 => board
		//부모글 => parent (부모글 refer, lev, sunbun)
		board.setRefer(parent.getRefer());//부모글의 글그룹번호와 동일하게
		board.setLev(parent.getLev()+1); //답변레벨=부모lev+1
		board.setSunbun(parent.getSunbun()+1);//순번=부모순번+1
		
		return bMapper.rewriteBoard(board);
	}

	@Override
	public BoardVO selectRefLevSunbun(int num) {
		// TODO Auto-generated method stub
		return bMapper.selectRefLevSunbun(num);
	}

	@Override
	public int updateSunbun(BoardVO parent) {
		// TODO Auto-generated method stub
		return bMapper.updateSunbun(parent);
	}

}
