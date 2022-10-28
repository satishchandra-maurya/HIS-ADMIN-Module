package in.satish.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.satish.entity.PlanCategory;
import in.satish.entity.PlanMaster;
import in.satish.repo.PlanCategoryRepo;
import in.satish.repo.PlanMasterRepository;

@Service
public class PlanMasterServiceImpl implements PlanMasterService{

	@Autowired
	private PlanCategoryRepo planCategoryRepo;
	
	@Autowired
	private PlanMasterRepository planMasterRepo;
	
	@Override
	public Map<Integer, String> getPlanCategory() {
		List<PlanCategory> findAll = planCategoryRepo.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		findAll.forEach(category ->{
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
		});
		
		return categoryMap;
	}

	@Override
	public boolean savePlan(PlanMaster planMaster) {
		PlanMaster save = planMasterRepo.save(planMaster);
		return save.getPlanId()!=null;
	}

	@Override
	public List<PlanMaster> getAllPlan() {
		List<PlanMaster> findAll = planMasterRepo.findAll();
		return findAll;
	}

	@Override
	public PlanMaster getPlanById(Integer planId) {
		Optional<PlanMaster> findById = planMasterRepo.findById(planId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deletePlanMaster(Integer planId) {
		boolean status = false;
		try {
			planMasterRepo.deleteById(planId);
			status = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean updatePlan(PlanMaster planMaster) {
		planMasterRepo.save(planMaster);
		return planMaster.getPlanId()!=null;
	}

	@Override
	public boolean changePlanMasterStatus(Integer planId, String status) {
		Optional<PlanMaster> findById = planMasterRepo.findById(planId);
		if(findById.isPresent()) {
			PlanMaster planMaster = findById.get();
			planMaster.setPlanActiveSw(status);
			planMasterRepo.save(planMaster);
			return true;
		}
		return false;
	}

	
}
