package target_mgmt.master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import target_mgmt.master.model.master.RatexTargetMaster;

@Repository("ratexTargetRepo")
public interface RatexTargetMaster_Repo extends JpaRepository<RatexTargetMaster, Long> 
{
@Query(value = "select * FROM RATEX_TARGET_MASTER WHERE target_class_seq_no in :cList order by target_class_seq_no",nativeQuery = true)
ArrayList<RatexTargetMaster> getSelectTargets(@Param("cList") ArrayList<Long> cList);
	
@Query(value = "delete FROM RATEX_TARGET_MASTER WHERE target_class_seq_no in :cList",nativeQuery = true)
void delSelectTargets(@Param("cList") ArrayList<Long> cList);
}