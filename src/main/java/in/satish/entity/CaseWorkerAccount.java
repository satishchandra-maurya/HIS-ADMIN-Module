package in.satish.entity;

import java.time.LocalDateTime;
import java.util.Date;

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
@Table(name="CASE_WORKER_ACCTS")
public class CaseWorkerAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ACCOUNT_ID")
	private Integer accountId;
				
	@Column(name="FULLNAME")
	private String fullName;
					
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="PHONE_NUMBER")
	private Long phoneNo;
					
	@Column(name="GENDER")
	private String gender;				
	
	@Column(name="SSN")
	private Long ssn;
	
	@Column(name="DOB")					
	private Date dob;
	
	@Column(name="WORKER_ACTIVE_SW")
	private String workerActiveSw;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name="UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDateTime updateddate;
}
