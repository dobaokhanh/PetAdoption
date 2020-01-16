package com.petadoption.service;

import java.util.List;

import com.petadoption.entity.Foster;

public interface FosterService {

	public List<Foster> getFosters();

	public Foster getFoster(int theId);

	public void saveFoster(Foster theFoster);

	public void deleteFoster(int theId);

}
