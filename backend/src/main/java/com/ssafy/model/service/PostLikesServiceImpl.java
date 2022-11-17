package com.ssafy.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dao.PostLikesDAO;
import com.ssafy.model.dto.PostLikes;

@Transactional
@Service
public class PostLikesServiceImpl implements PostLikesService {

	@Autowired
	private PostLikesDAO postLikesDao;

	@Override
	public boolean insertPostLike(PostLikes postLikes) {
		return postLikesDao.insertPostLike(postLikes) > 0;
	}

	@Override
	public boolean deletePostLike(PostLikes postLikes) {
		return postLikesDao.deletePostLike(postLikes) > 0;
	}

	@Override
	public boolean getPostLike(PostLikes postLikes) {
		return postLikesDao.getPostLike(postLikes) != null;
	}

	@Override
	public int getPostLikesCount(Long postNo) {
		return postLikesDao.getPostLikesCount(postNo);
	}
}
