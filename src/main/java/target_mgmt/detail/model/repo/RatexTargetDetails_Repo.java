package target_mgmt.detail.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import target_mgmt.detail.model.master.RatexTargetDetail;

@Repository("ratexTargetDetailsRepo")
public interface RatexTargetDetails_Repo extends JpaRepository<RatexTargetDetail, Long> 
{
@Query(value = "select * FROM RATEX_TARGET_DETAILS WHERE target_seq_no in :tList order by target_seq_no",nativeQuery = true)
ArrayList<RatexTargetDetail> getSelectTargets(@Param("tList") ArrayList<Long> tList);
	
@Query(value = "select * FROM RATEX_TARGET_DETAILS WHERE target_class_seq_no in :cList order by target_class_seq_no",nativeQuery = true)
ArrayList<RatexTargetDetail> getSelectTargetsForTargetClasses(@Param("cList") ArrayList<Long> cList);

@Query(value = "delete FROM RATEX_TARGET_DETAILS WHERE target_seq_no in :tList",nativeQuery = true)
void delSelectTargets(@Param("tList") ArrayList<Long> tList);
	
@Query(value = "delete FROM RATEX_TARGET_DETAILS WHERE target_class_seq_no in :cList",nativeQuery = true)
void delSelectTargetsForTargetClasses(@Param("cList") ArrayList<Long> cList);

}