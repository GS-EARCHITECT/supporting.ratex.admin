package context_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import context_mgmt.model.master.RatexContextDetail;
import context_mgmt.model.master.RatexContextDetailPK;

@Repository("ratexContextDetailsRepo")
public interface RatexContextDetails_Repo extends JpaRepository<RatexContextDetail, RatexContextDetailPK> 
{
@Query(value = "select * FROM RATEX_CONTEXT_DETAILS WHERE (company_unit_seq_no in :coList and context_seq_no in :cList) order by company_unit_seq_no, context_seq_no",nativeQuery = true)
ArrayList<RatexContextDetail> getSelectContextDetails(@Param("coList") ArrayList<Long> coList, @Param("cList") ArrayList<Long> cList);
	
@Query(value = "select * FROM RATEX_CONTEXT_DETAILS WHERE company_unit_seq_no in :coList order by company_unit_seq_no, context_seq_no",nativeQuery = true)
ArrayList<RatexContextDetail> getSelectContextDetailsForCompanyUnits(@Param("coList") ArrayList<Long> coList);

@Query(value = "delete FROM RATEX_CONTEXT_DETAILS WHERE (company_unit_seq_no in :coList and context_seq_no in :cList)",nativeQuery = true)
void delSelectContextDetails(@Param("coList") ArrayList<Long> coList, @Param("cList") ArrayList<Long> cList);
	
@Query(value = "delete FROM RATEX_CONTEXT_DETAILS WHERE company_unit_seq_no in :coList",nativeQuery = true)
void delSelectContextDetailsForCompanyUnits(@Param("coList") ArrayList<Long> coList);

}