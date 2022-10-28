package in.satish.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.satish.entity.PlanMaster;
import in.satish.service.PlanMasterService;

@RestController
public class PlanMasterController {

	@Autowired
	private PlanMasterService pms;
	
	@GetMapping("/planCategory")
	public ResponseEntity<Map<Integer, String>> getPlanCategory(){
		Map<Integer, String> planCategory = pms.getPlanCategory();
		return new ResponseEntity<> (planCategory, HttpStatus.OK);
		
	} 
	
	@PostMapping("/savePlan")
	public ResponseEntity<String> savePlan(@RequestBody PlanMaster planMaster){
		boolean savePlan = pms.savePlan(planMaster);
		if(savePlan) {
			return new ResponseEntity<> ("Plan Saved Successfully !", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<> ("Plan Not Saved", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/allPlan")
	public ResponseEntity<List<PlanMaster>> getAllPlan(){
		List<PlanMaster> allPlan = pms.getAllPlan();
		return new ResponseEntity<> (allPlan, HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<PlanMaster> editPlan(@PathVariable Integer planId){
		PlanMaster plan = pms.getPlanById(planId);
		return new ResponseEntity<> (plan, HttpStatus.OK);
	}
	
	@PutMapping("/updatePlan")
	public ResponseEntity<String> updatePlan(@RequestBody PlanMaster planMaster){
		boolean updatePlan = pms.updatePlan(planMaster);
		if(updatePlan) {
			return new ResponseEntity<> ("Plan Update Successfully !", HttpStatus.OK);
		}else {
			return new ResponseEntity<> ("Plan Not Update !", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deletePlan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean deletePlanMaster = pms.deletePlanMaster(planId);
		if(deletePlanMaster) {
			return new ResponseEntity<> ("Plan Deleted Successfully !", HttpStatus.OK);
		}else {
			return new ResponseEntity<> ("Not Deleted !", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/status/{planId}/{status}")
	public ResponseEntity<String> planStatusChange
		(@PathVariable Integer planId, @PathVariable String status){
		
		boolean changePlanMasterStatus = pms.changePlanMasterStatus(planId, status);
		if(changePlanMasterStatus) {
			return new ResponseEntity<> ("Plan Status Changed Successfully!" , HttpStatus.OK);
		}else {
			return new ResponseEntity<> ("Plan Status Not Changed !" , HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
