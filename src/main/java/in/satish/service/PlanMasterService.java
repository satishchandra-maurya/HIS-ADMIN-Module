package in.satish.service;

import java.util.List;
import java.util.Map;

import in.satish.entity.PlanMaster;

public interface PlanMasterService {

	public Map<Integer, String> getPlanCategory();
	public boolean savePlan(PlanMaster planMaster);
	public List<PlanMaster> getAllPlan();
	public PlanMaster getPlanById(Integer planId);
	public boolean deletePlanMaster(Integer planId);
	public boolean updatePlan(PlanMaster planMaster);
	public boolean changePlanMasterStatus(Integer planId, String status);
	
}
