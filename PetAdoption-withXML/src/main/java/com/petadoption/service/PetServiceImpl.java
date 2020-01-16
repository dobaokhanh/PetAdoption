package com.petadoption.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petadoption.dao.PetDAO;
import com.petadoption.entity.Pet;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetDAO petDAO;
	
	@Override
	@Transactional
	public List<Pet> getPets() {
		return petDAO.getPets();
	}

	@Override
	@Transactional
	public Pet getPet(int theId) {
		return petDAO.getPet(theId);
	}

	@Override
	@Transactional
	public void savePet(Pet thePet) {
		petDAO.savePet(thePet);
	}

	@Override
	@Transactional
	public void deletePet(int theId) {
		petDAO.deletePet(theId);
	}

}
