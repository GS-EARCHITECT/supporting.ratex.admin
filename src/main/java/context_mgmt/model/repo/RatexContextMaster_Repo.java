package context_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import context_mgmt.model.master.RatexContextMaster;

@Repository("ratexContextRepo")
public interface RatexContextMaster_Repo extends JpaRepository<RatexContextMaster, Long> 
{
@Query(value = "select * FROM RATEX_CONTEXT_MASTER WHERE context_seq_no in :cList order by context_seq_no",nativeQuery = true)
ArrayList<RatexContextMaster> getSelectContexts(@Param("cList") ArrayList<Long> cList);
	
@Query(value = "delete FROM RATEX_CONTEXT_MASTER WHERE context_seq_no in :cList",nativeQuery = true)
void delSelectContexts(@Param("cList") ArrayList<Long> cList);
}