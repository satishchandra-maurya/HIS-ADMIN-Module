package in.satish.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name="PLAN_CATEGORY")
public class PlanCategory {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName; //Food, Health, ChildCare, UnEmployment etc
	
	@Column(name="ACTIVE_SW")
	private String activeSw;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name="UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
}
