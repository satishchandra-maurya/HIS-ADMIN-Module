package in.satish.service;

import java.util.List;

import in.satish.entity.PlanCategory;

public interface PlanCategoryService {

	public String upsert(PlanCategory planCategory);
	public List<PlanCategory> getAllPlanCategory();
	public PlanCategory getPlanCategoryById(Integer categoryId);
	public String deletePlanCategory(Integer categoryId);
	public boolean changePlanCategoryStatus(Integer categoryId, String status);
}
