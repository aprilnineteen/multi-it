package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.board.domain.BoardVO;
import com.board.domain.PagingVO;
import com.multi.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service("boardService")
@RequiredArgsConstructor //������ ����
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

	//�亯 �۾���	-------------------------
	
	@Override
	public int rewriteBoard(BoardVO board) {
		//[1] �θ��(����) �۹�ȣ(num)�� �θ���� refer(�۱׷��ȣ), lev(�亯����), sunbun(����) ��������
		BoardVO parent = this.selectRefLevSunbun(board.getNum());
		log.info("parent: "+parent);
		//[2] ������ �޸� �亯���� �ִٸ�, �� �亯���� insert�ϱ� ���� ���� �亯���� ������ �ϳ��� ��������
		this.updateSunbun(parent);
		//[3] ���� �� �亯 ���� insert�Ѵ� == insert��
		//���� �� �亯 �� => board
		//�θ�� => parent (�θ�� refer, lev, sunbun)
		board.setRefer(parent.getRefer());//�θ���� �۱׷��ȣ�� �����ϰ�
		board.setLev(parent.getLev()+1); //�亯����=�θ�lev+1
		board.setSunbun(parent.getSunbun()+1);//����=�θ����+1
		
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
