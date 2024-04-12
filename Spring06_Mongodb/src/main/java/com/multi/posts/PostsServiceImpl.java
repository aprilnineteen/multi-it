package com.multi.posts;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
@Service
public class PostsServiceImpl implements PostsService {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Inject
	private PostsDAO pDao;
	
	@Override
	public int insertPosts(PostsVO vo) {
		return pDao.insertPosts(vo);
	}

	@Override
	public List<PostsVO> listPosts() {
		return pDao.listPosts();
	}

	@Override
	public PostsVO selectPosts(String id) {
		return pDao.selectPosts(id);
	}

	@Override
	public int deletePosts(String id) {
		return pDao.deletePosts(id);
	}

	@Override
	public int updatePosts(PostsVO vo) {
		return pDao.updatePosts(vo);
	}

}
