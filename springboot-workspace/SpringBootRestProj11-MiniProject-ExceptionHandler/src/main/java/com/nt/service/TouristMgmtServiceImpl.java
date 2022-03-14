package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.exception.TouristNotFoundException;
import com.nt.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristManagementService {

	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {

		int idVal = touristRepo.save(tourist).getTid();
		return "Tourist is registered with id value: " + idVal;
	}

	@Override
	public List<Tourist> fetchAllTourists() {
		List<Tourist> list = touristRepo.findAll();
		list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException {
		return touristRepo.findById(tid).orElseThrow(() -> new TouristNotFoundException(tid + " Tourist Not Found"));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> tourist1 = touristRepo.findById(tourist.getTid());
		if (tourist1.isPresent()) {
			touristRepo.save(tourist);
			return tourist.getTid() + " tourist is updated";
		} else {
			throw new TouristNotFoundException(tourist.getTid() + " tourist not found");
		}
	}

	@Override
	public String deleteTourist(Integer id) throws Exception {
		Optional<Tourist> opt = touristRepo.findById(id);
		if (opt.isPresent()) {
			touristRepo.delete(opt.get());
			return id + " Tourist deleted";
		} else {
			throw new Exception(id + " Tourist not found");
		}
	}

	@Override
	public String updateTouristBudgetById(Integer id, Float hikePercent) throws TouristNotFoundException {
		Optional<Tourist> opt = touristRepo.findById(id);
		if (opt.isPresent()) {
			Tourist tourist = opt.get();
			tourist.setBudget(tourist.getBudget() + (tourist.getBudget() * hikePercent / 100));
			touristRepo.save(tourist);
			return "Tourist budget is updated";
		} else {
			throw new TouristNotFoundException(id + " Tourist not found");
		}
	}

}
