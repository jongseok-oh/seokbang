package com.ssafy.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dao.RepleLikesDAO;
import com.ssafy.model.dto.RepleLikes;

@Transactional
@Service
public class RepleLikesServiceImpl implements RepleLikesService {

	@Autowired
	private RepleLikesDAO repleLikesDao;

	@Override
	public boolean insertRepleLike(RepleLikes repleLikes) {
		return repleLikesDao.insertRepleLike(repleLikes) > 0;
	}

	@Override
	public boolean deleteRepleLike(RepleLikes repleLikes) {
		return repleLikesDao.deleteRepleLike(repleLikes) > 0;
	}

	@Override
	public boolean getRepleLike(RepleLikes repleLikes) {
		return repleLikesDao.getRepleLike(repleLikes) != null;
	}

	@Override
	public int getRepleLikesCount(Long repleNo) {
		return repleLikesDao.getRepleLikesCount(repleNo);
	}
}
