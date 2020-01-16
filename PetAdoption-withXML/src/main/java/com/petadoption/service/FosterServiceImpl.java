package com.petadoption.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petadoption.dao.FosterDAO;
import com.petadoption.entity.Foster;

@Service
public class FosterServiceImpl implements FosterService {
	
	@Autowired
	private FosterDAO fosterDAO;

	@Override
	@Transactional
	public List<Foster> getFosters() {
		return fosterDAO.getFosters();
	}

	@Override
	@Transactional
	public Foster getFoster(int theId) {
		return fosterDAO.getFoster(theId);
	}

	@Override
	@Transactional
	public void saveFoster(Foster theFoster) {
		fosterDAO.saveFoster(theFoster);
	}

	@Override
	@Transactional
	public void deleteFoster(int theId) {
		fosterDAO.deleteFoster(theId);
	}

}
