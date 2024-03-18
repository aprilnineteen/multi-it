package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.common.exception.NotUserException;
import com.multi.mapper.MemberMapper;
import com.user.domain.MemberVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service("memberService")
@RequiredArgsConstructor  //������ ������ �ϰ��� �� �� ==> ���Ե� �������� ���� ��ü�� final �ʵ忩�� �Ѵ�
@Log4j
public class MemberServiceImpl implements MemberService {
	
	//@Inject
	//private MemberMapper mMapper;//Field Injection
	private final MemberMapper mMapper;//final field ==> ������ ����(@RequiredArgsConstructor )

	@Override
	public int insertMember(MemberVO vo) {
		log.info("mMapper: "+mMapper);
		return mMapper.insertMember(vo);
	}

	@Override
	public int idCheck(String userid) {
		return mMapper.idCheck(userid);
	}

	@Override
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectByUserid(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO loginCheck(MemberVO tmpUser) throws NotUserException {
		return mMapper.loginCheck(tmpUser);
	}

}