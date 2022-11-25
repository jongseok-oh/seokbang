package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dao.RepleDAO;
import com.ssafy.model.dto.Reple;
import com.ssafy.model.dto.RepleDTO;

@Transactional(isolation = Isolation.SERIALIZABLE)
@Service
public class RepleServiceImpl implements RepleService {
	
	@Autowired
	private RepleDAO repleDao;
	
	@Override
	public boolean insertReple(Reple reple) {
		return repleDao.insertReple(reple) > 0;
	}

	@Override
	public List<RepleDTO> getReples(Long postNo) {
		return repleDao.getReples(postNo);
	}

	@Override
	public RepleDTO getReple(Long no) {
		return repleDao.getReple(no);
	}

	@Override
	public boolean modifyReple(Reple reple) {
		return repleDao.modifyReple(reple) > 0;
	}

	@Override
	public boolean deleteReple(Long no) {
		return repleDao.deleteReple(no) > 0;
	}
	
}
