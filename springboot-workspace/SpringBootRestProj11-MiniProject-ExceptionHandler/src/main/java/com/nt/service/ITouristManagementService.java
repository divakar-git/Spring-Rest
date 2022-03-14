package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;
import com.nt.exception.TouristNotFoundException;

public interface ITouristManagementService {
	public String registerTourist(Tourist tourist) throws Exception;
	public List<Tourist> fetchAllTourists() throws Exception;
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException;
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;
	public String deleteTourist(Integer id) throws Exception;
	public String updateTouristBudgetById(Integer id, Float hikePercent) throws TouristNotFoundException;
}
