package com.petadoption.service;

import java.util.List;

import com.petadoption.entity.Pet;

public interface PetService {

	public List<Pet> getPets();
	
	public Pet getPet(int theId);
	
	public void savePet(Pet thePet);
	
	public void deletePet(int theId);
}
