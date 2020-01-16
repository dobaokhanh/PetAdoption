package com.petadoption.dao;

import java.util.List;

import com.petadoption.entity.Pet;

public interface PetDAO {
	
	public List<Pet> getPets();
	
	public Pet getPet(int theId);
	
	public void savePet(Pet pet);
	
	public void deletePet(int theId);
}
