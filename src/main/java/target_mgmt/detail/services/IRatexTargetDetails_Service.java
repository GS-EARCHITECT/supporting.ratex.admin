package target_mgmt.detail.services;

import java.util.ArrayList;
import target_mgmt.detail.model.dto.RatexTargetDetail_DTO;

public interface IRatexTargetDetails_Service 
{
	public RatexTargetDetail_DTO newTargetDetail(RatexTargetDetail_DTO cDTO);
	public ArrayList<RatexTargetDetail_DTO> getAllTargetDetails();
	public ArrayList<RatexTargetDetail_DTO> getSelectTargetDetails(ArrayList<Long> tList);
	public ArrayList<RatexTargetDetail_DTO> getSelectTargetsForTargetClasses(ArrayList<Long> cList);
	public void updTargetDetail(RatexTargetDetail_DTO cDTO);
	public void delSelectTargetDetails(ArrayList<Long> cList);
	public void delSelectTargetsForTargetClasses(ArrayList<Long> cList);
	public void delAllTargetDetails();
			
}