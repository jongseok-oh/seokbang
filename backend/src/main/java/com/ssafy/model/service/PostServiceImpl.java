package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dao.PostDAO;
import com.ssafy.model.dto.Post;

@Transactional(isolation = Isolation.SERIALIZABLE)
@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO postDao;
	
	@Override
	public boolean insertPost(Post post) {
		return postDao.insertPost(post) > 0;
	}

	@Override
	public List<Post> getPosts(String gugunCode) {
		return postDao.getPosts(gugunCode);
	}

	@Override
	public Post getPost(Long no) {
		return postDao.getPost(no);
	}

	@Override
	public boolean modifyPost(Post post) {
		return postDao.modifyPost(post) > 0;
	}

	@Override
	public boolean deletePost(Long no) {
		return postDao.deletePost(no) > 0;
	}

	@Override
	public boolean hit(Long no) {
		return postDao.hit(no) > 0;
	}


}
