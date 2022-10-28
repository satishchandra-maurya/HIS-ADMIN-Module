package in.satish.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satish.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Serializable>{

}
