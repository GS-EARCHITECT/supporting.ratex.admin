package target_mgmt.detail.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import target_mgmt.detail.model.dto.RatexTargetDetail_DTO;
import target_mgmt.detail.model.master.RatexTargetDetail;
import target_mgmt.detail.model.repo.RatexTargetDetails_Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("ratexTargetDetailsServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class RatexTargetDetails_Service implements IRatexTargetDetails_Service 
{	
	//private static final Logger logger = LoggerFactory.getLogger(RatexTarget_Service.class);
	
	@Autowired
    private RatexTargetDetails_Repo ratexTargetDetailsRepo;
		
	@Override
	public ArrayList<RatexTargetDetail_DTO> getAllTargetDetails()
    {
    	ArrayList<RatexTargetDetail> rcReqList = null;    	
    	rcReqList =  (ArrayList<RatexTargetDetail>) ratexTargetDetailsRepo.findAll();
    	ArrayList<RatexTargetDetail_DTO> lDetails = new ArrayList<RatexTargetDetail_DTO>();
    	lDetails = rcReqList != null ? this.getRatexTargetDtos(rcReqList) : null;        
   		return lDetails;   		
    }
    
    @Override
	public ArrayList<RatexTargetDetail_DTO> getSelectTargetDetails(ArrayList<Long> rciceReqSeqNos)
    {
    	ArrayList<RatexTargetDetail> lDetails = ratexTargetDetailsRepo.getSelectTargets(rciceReqSeqNos);
    	ArrayList<RatexTargetDetail_DTO> rcDetailDTOs = lDetails != null ? this.getRatexTargetDtos(lDetails): null;
    	return rcDetailDTOs;
    }

	@Override
	public ArrayList<RatexTargetDetail_DTO> getSelectTargetsForTargetClasses(ArrayList<Long> cList)
    {
    	ArrayList<RatexTargetDetail> lDetails = ratexTargetDetailsRepo.getSelectTargetsForTargetClasses(cList);
    	ArrayList<RatexTargetDetail_DTO> rcDetailDTOs = lDetails != null ? this.getRatexTargetDtos(lDetails): null;
    	return rcDetailDTOs;
    }
	
    @Override
	public RatexTargetDetail_DTO newTargetDetail(RatexTargetDetail_DTO rcDTO) 
    {    
		RatexTargetDetail_DTO ratexTargetDTO = new RatexTargetDetail_DTO();  		
  		if(!ratexTargetDetailsRepo.existsById(rcDTO.getTargetClassSeqNo()))
  		{	
  		RatexTargetDetail ratexTargetDetail = ratexTargetDetailsRepo.save(this.setRatexTargetDetail(rcDTO));    
  		ratexTargetDTO = this.getRatexTargetDetail_DTO(ratexTargetDetail);
  		}
  		
        return ratexTargetDTO;
    }

    @Override
	public void updTargetDetail(RatexTargetDetail_DTO rcReqDTO) 
    {
    	if(ratexTargetDetailsRepo.existsById(rcReqDTO.getTargetClassSeqNo()))
    	{
        RatexTargetDetail ratexTargetDetail = this.setRatexTargetDetail(rcReqDTO);
        ratexTargetDetail.setTargetClassSeqNo(rcReqDTO.getTargetClassSeqNo());
    	ratexTargetDetailsRepo.save(ratexTargetDetail);
    	}
    }
    	
    public void delSelectTargetDetails(ArrayList<Long> cList)
    {
    	ratexTargetDetailsRepo.delSelectTargets(cList);
        return;
    }
    
    public void delSelectTargetsForTargetClasses(ArrayList<Long> cList)
    {
    	ratexTargetDetailsRepo.delSelectTargetsForTargetClasses(cList);
        return;
    }
    
	@Override
	public void delAllTargetDetails() 
    {
  		ratexTargetDetailsRepo.deleteAll();      	
        return ;    
    }
    
    private ArrayList<RatexTargetDetail_DTO> getRatexTargetDtos(ArrayList<RatexTargetDetail> rcReqDetails) 
	{
		ArrayList<RatexTargetDetail_DTO> ratexTargetDTOs = new ArrayList<RatexTargetDetail_DTO>(); 
		for(int i=0; i < rcReqDetails.size();i++)
		{		
		ratexTargetDTOs.add(this.getRatexTargetDetail_DTO(rcReqDetails.get(i)));
		}		
		return ratexTargetDTOs;
	}
	
	private RatexTargetDetail_DTO getRatexTargetDetail_DTO(RatexTargetDetail rcReqDetail) 
	{
		RatexTargetDetail_DTO ratexTargetDTO = new RatexTargetDetail_DTO();
		ratexTargetDTO.setTargetClassSeqNo(rcReqDetail.getTargetClassSeqNo());
		ratexTargetDTO.setTargetSeqNo(rcReqDetail.getTargetSeqNo());
		ratexTargetDTO.setCompanyUnitSeqNo(rcReqDetail.getCompanyUnitSeqNo());
		return ratexTargetDTO;
		}
		
	private RatexTargetDetail setRatexTargetDetail(RatexTargetDetail_DTO ratexTargetDTO) 
	{
		RatexTargetDetail ratexTargetDetail		=	new	RatexTargetDetail();				
		ratexTargetDTO.setTargetClassSeqNo(ratexTargetDTO.getTargetClassSeqNo());
		ratexTargetDTO.setCompanyUnitSeqNo(ratexTargetDTO.getCompanyUnitSeqNo());
		return ratexTargetDetail;
	}

	
}