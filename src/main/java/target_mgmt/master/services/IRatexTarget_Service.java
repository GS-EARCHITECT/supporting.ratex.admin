package target_mgmt.master.services;

import java.util.ArrayList;

import target_mgmt.master.model.dto.RatexTargetMaster_DTO;

public interface IRatexTarget_Service 
{
	public RatexTargetMaster_DTO newTarget(RatexTargetMaster_DTO cDTO);
	public ArrayList<RatexTargetMaster_DTO> getAllTargets();
	public ArrayList<RatexTargetMaster_DTO> getSelectTargets(ArrayList<Long> cList);
	public void updTarget(RatexTargetMaster_DTO cDTO);
	public void delSelectTargets(ArrayList<Long> cList);
	public void delAllTargets();	
			
}