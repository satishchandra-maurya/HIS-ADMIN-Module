package in.satish.rest;

import java.util.List;

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

import in.satish.entity.PlanCategory;
import in.satish.service.PlanCategoryService;

@RestController
public class PlanCategoryController {

	@Autowired
	private PlanCategoryService planCategoryService;
	
	@PostMapping("/planCategory")
	public ResponseEntity<String> savePlanCategory(@RequestBody PlanCategory planCategory){
		String msg = planCategoryService.upsert(planCategory);
		return new ResponseEntity<> (msg, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/allPlanCategory")
	public ResponseEntity<List<PlanCategory>> getAllPlanCategory(){
		List<PlanCategory> list = planCategoryService.getAllPlanCategory();
		return new ResponseEntity<> (list, HttpStatus.OK);
	}
	
	@GetMapping("/planCategory/{categoryId}")
	public ResponseEntity<PlanCategory> editPlanCategory(@PathVariable Integer categoryId){
		PlanCategory Entity = planCategoryService.getPlanCategoryById(categoryId);
		return new ResponseEntity<> (Entity, HttpStatus.OK);
		
	}
	
	@PutMapping("/planCategory")
	public ResponseEntity<String> updatePlanCategory(@RequestBody PlanCategory planCategory){
		String msg = planCategoryService.upsert(planCategory);
		return new ResponseEntity<> (msg, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/categoryId/{categoryId}")
	public ResponseEntity<String> deletePlanCategory(@PathVariable Integer categoryId){
		String msg = planCategoryService.deletePlanCategory(categoryId);
		return new ResponseEntity<> (msg, HttpStatus.OK);
	}
	
}
