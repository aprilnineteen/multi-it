package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.multi.domain.NewsVO;
@Mapper
public interface SampleMapper {
	
	
	//SampleMapper.xml==>mybatis-config.xml�� ���

	public int createNews(NewsVO vo);

}
