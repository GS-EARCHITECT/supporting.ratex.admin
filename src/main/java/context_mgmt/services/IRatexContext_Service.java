package context_mgmt.services;

import java.util.ArrayList;
import context_mgmt.model.dto.RatexContextDetail_DTO;
import context_mgmt.model.dto.RatexContextMaster_DTO;

public interface IRatexContext_Service 
{
	public RatexContextMaster_DTO newContext(RatexContextMaster_DTO cDTO);
	public ArrayList<RatexContextMaster_DTO> getAllContexts();
	public ArrayList<RatexContextMaster_DTO> getSelectContexts(ArrayList<Long> cList);
	public void updContext(RatexContextMaster_DTO cDTO);
	public void delSelectContexts(ArrayList<Long> cList);
	public void delAllContexts();		
	public RatexContextDetail_DTO newContextDetail(RatexContextDetail_DTO cdDTO);
	public ArrayList<RatexContextDetail_DTO> getAllContextDetails();
	public ArrayList<RatexContextDetail_DTO> getSelectContextDetailsForCompanyUnits(ArrayList<Long> coList);
	public ArrayList<RatexContextDetail_DTO> getSelectContextDetails(ArrayList<Long> coList, ArrayList<Long> cList);
	public void updContextDetail(RatexContextDetail_DTO cDTO);
	public void delSelectContextDetails(ArrayList<Long> coList, ArrayList<Long> cList);
	public void delSelectContextDetailsForCompanyUnits(ArrayList<Long> coList);
	public void delAllContextDetails();
	
}