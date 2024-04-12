package com.multi.posts;

//static import
// where�� ���� import static org.springframework.data.mongodb.core.query.Criteria.where;
/* �� ���� */
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
//where�� ���� import static org.springframework.data.mongodb.core.query.Criteria.where;
/* �� ���� */
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
		// sequence �÷��ǿ��� collectionName�� posts�� document�� count �ʵ� �� ��������
		// count ���� 1�� ������Ų�� => posts �÷����� �۹�ȣ(no) �ʵ尪���� ����ϱ� ���ؼ�
		//Query query = Query.query(Criteria.where("collectionName").is("posts"));
		Query query = query(where("collectionName").is("posts"));
		// db.sequence.find({CollectionName:'posts'})

		Update update = new Update();
		update.inc("count", 1);
		// db.sequence.update({collectionName:'posts'}, {$inc:{count:1}})

		SeqVO svo = mongoTemplate.findAndModify(query, update, SeqVO.class, "sequence");
		System.out.println(svo);

		vo.setNo(svo.getCount()); // sequence���� ������ count���� �� ��ȣ�� ����

		PostsVO tmp = mongoTemplate.insert(vo, "posts");
		System.out.println("tmp: " + tmp);
		return (tmp == null) ? 0 : 1;
	}

	@Override
	public List<PostsVO> listPosts() {

		// return mongoTemplate.findAll(PostsVO.class, "posts");
		// class, �÷��Ǹ� ������

		// �۹�ȣ ������������ �����ؼ� ��������
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
		// ��ȯ Ÿ�� long�̾ ���� ����ȯ
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
