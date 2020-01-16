package com.petadoption.dao;

import java.util.List;

import com.petadoption.entity.Foster;

public interface FosterDAO {

	public List<Foster> getFosters();
	
	public Foster getFoster(int theId);
	
	public void saveFoster(Foster theFoster);
	
	public void deleteFoster(int theId);
}
