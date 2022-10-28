package in.satish.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.satish.entity.PlanCategory;
import in.satish.repo.PlanCategoryRepo;

@Service
public class PlanCategoryServiceImpl implements PlanCategoryService{

	@Autowired
	private PlanCategoryRepo planCategoryRepo;
	
	@Override
	public String upsert(PlanCategory planCategory) {
		Integer categoryId = planCategory.getCategoryId();
		planCategoryRepo.save(planCategory);
		if(categoryId == null) {
			return "Plan Category Saved Successfully !";
		}else {
		return "Plan Category Updated Successfully !";
		}
	}

	@Override
	public List<PlanCategory> getAllPlanCategory() {
		return planCategoryRepo.findAll();
	}

	@Override
	public PlanCategory getPlanCategoryById(Integer categoryId) {
		return planCategoryRepo.findById(categoryId).get();
	}

	@Override
	public String deletePlanCategory(Integer categoryId) {
		planCategoryRepo.deleteById(categoryId);
		return "Plan Category Deleted !";
	}

	@Override
	public boolean changePlanCategoryStatus(Integer categoryId, String status) {
		Optional<PlanCategory> findById = planCategoryRepo.findById(categoryId);
		if(findById.isPresent()) {
			PlanCategory planCategory = findById.get();
			planCategory.setActiveSw(status);
			planCategoryRepo.save(planCategory);
			return true;
		}
		
		return false;
	}

}
