package com.petadoption.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petadoption.dao.OwnerDAO;
import com.petadoption.entity.Owner;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerDAO ownerDAO;

	@Override
	@Transactional
	public List<Owner> getOwners() {
		return ownerDAO.getOwners();
	}

	@Override
	@Transactional
	public Owner getOwner(int theId) {
		return ownerDAO.getOwner(theId);
	}

	@Override
	@Transactional
	public void saveOwner(Owner theOwner) {
		ownerDAO.saveOwner(theOwner);
	}

	@Override
	@Transactional
	public void deleteOwner(int theId) {
		ownerDAO.deleteOwner(theId);
	}

}
