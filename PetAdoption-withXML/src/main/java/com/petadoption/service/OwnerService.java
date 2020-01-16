package com.petadoption.service;

import java.util.List;

import com.petadoption.entity.Owner;

public interface OwnerService {
	
	public List<Owner> getOwners();
	
	public Owner getOwner(int theId);
	
	public void saveOwner(Owner theOwner);
	
	public void deleteOwner(int theId);
}
