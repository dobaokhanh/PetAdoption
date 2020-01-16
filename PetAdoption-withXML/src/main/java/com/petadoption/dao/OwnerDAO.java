package com.petadoption.dao;

import java.util.List;

import com.petadoption.entity.Owner;

public interface OwnerDAO {
	
	public List<Owner> getOwners();
	
	public Owner getOwner(int theId);
	
	public void saveOwner(Owner owner);
	
	public void deleteOwner(int theId);
}
