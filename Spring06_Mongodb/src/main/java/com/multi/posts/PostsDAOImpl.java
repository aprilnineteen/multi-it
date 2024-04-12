package com.multi.posts;

//static import
// where만 쓸게 import static org.springframework.data.mongodb.core.query.Criteria.where;
/* 다 쓸게 */
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

//static import
//where만 쓸게 import static org.springframework.data.mongodb.core.query.Criteria.where;
/* 다 쓸게 */
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.domain.Sort.*;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Repository(value = "postsDAOImpl")
public class PostsDAOImpl implements PostsDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public int insertPosts(PostsVO vo) {
		// sequence 컬렉션에서 collectionName이 posts인 document의 count 필드 값 가져오고
		// count 값을 1씩 증가시킨다 => posts 컬렉션의 글번호(no) 필드값으로 사용하기 위해서
		//Query query = Query.query(Criteria.where("collectionName").is("posts"));
		Query query = query(where("collectionName").is("posts"));
		// db.sequence.find({CollectionName:'posts'})

		Update update = new Update();
		update.inc("count", 1);
		// db.sequence.update({collectionName:'posts'}, {$inc:{count:1}})

		SeqVO svo = mongoTemplate.findAndModify(query, update, SeqVO.class, "sequence");
		System.out.println(svo);

		vo.setNo(svo.getCount()); // sequence에서 가져온 count값을 글 번호로 설정

		PostsVO tmp = mongoTemplate.insert(vo, "posts");
		System.out.println("tmp: " + tmp);
		return (tmp == null) ? 0 : 1;
	}

	@Override
	public List<PostsVO> listPosts() {

		// return mongoTemplate.findAll(PostsVO.class, "posts");
		// class, 컬렉션명 순서로

		// 글번호 내림차순으로 정렬해서 가져오기
		Query query = new Query();
		
		//query.with(Sort.by(Sort.Direction.DESC, "no"));
		query.with(by(Direction.DESC,"no"));
		return mongoTemplate.find(query, PostsVO.class, "posts");
	}

	@Override
	public PostsVO selectPosts(String id) {
		//PostsVO pvo = mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), PostsVO.class, "posts");
		PostsVO pvo = mongoTemplate.findOne(query(where("_id").is(id)), PostsVO.class, "posts");
		return pvo;
	}

	@Override
	public int deletePosts(String id) {
		DeleteResult res = mongoTemplate.remove(
				//Query.query(Criteria.where("_id").is(id)), PostsVO.class, "posts");
				query(where("_id").is(id)), PostsVO.class, "posts");
		return (int) res.getDeletedCount();
		// 반환 타입 long이어서 강제 형변환
	}

	@Override
	public int updatePosts(PostsVO vo) {
		Update uvo = new Update();
		uvo.set("title", vo.getTitle())
			.set("author", vo.getAuthor());
		
		UpdateResult res = mongoTemplate.updateFirst(
				//Query.query(Criteria.where("_id").is(vo.getId())),
				query(where("_id").is(vo.getId())),
					uvo, PostsVO.class, "posts");	
				return (int)res.getModifiedCount();
	}

}
