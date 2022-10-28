package in.satish.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satish.entity.CaseWorkerAccount;

public interface CaseWorkerAccountRepo extends JpaRepository<CaseWorkerAccount, Serializable>{

}
