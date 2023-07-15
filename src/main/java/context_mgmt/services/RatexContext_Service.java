package context_mgmt.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import context_mgmt.model.dto.RatexContextDetail_DTO;
import context_mgmt.model.dto.RatexContextMaster_DTO;
import context_mgmt.model.master.RatexContextDetail;
import context_mgmt.model.master.RatexContextDetailPK;
import context_mgmt.model.master.RatexContextMaster;
import context_mgmt.model.repo.RatexContextDetails_Repo;
import context_mgmt.model.repo.RatexContextMaster_Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("ratexContextServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class RatexContext_Service implements IRatexContext_Service 
{	
	private static final Logger logger = LoggerFactory.getLogger(RatexContext_Service.class);
	
	@Autowired
    private RatexContextMaster_Repo ratexContextRepo;
		
	@Autowired
    private RatexContextDetails_Repo ratexContextDetailsRepo;

//	RATEX MASTER	
	
    @Override
	public ArrayList<RatexContextMaster_DTO> getAllContexts()
    {
    	ArrayList<RatexContextMaster> rcReqList = null;    	
    	rcReqList =  (ArrayList<RatexContextMaster>) ratexContextRepo.findAll();
    	ArrayList<RatexContextMaster_DTO> lMasters = new ArrayList<RatexContextMaster_DTO>();
    	lMasters = rcReqList != null ? this.getRatexContextDtos(rcReqList) : null;        
   		return lMasters;   		
    }
    
    @Override
	public ArrayList<RatexContextMaster_DTO> getSelectContexts(ArrayList<Long> rciceReqSeqNos)
    {
    	ArrayList<RatexContextMaster> lMasters = ratexContextRepo.getSelectContexts(rciceReqSeqNos);
    	ArrayList<RatexContextMaster_DTO> rcMasterDTOs = lMasters != null ? this.getRatexContextDtos(lMasters): null;
    	return rcMasterDTOs;
    }
            
    @Override
	public RatexContextMaster_DTO newContext(RatexContextMaster_DTO rcDTO) 
    {    
		RatexContextMaster_DTO ratexContextDTO = new RatexContextMaster_DTO();  		
  		if(!ratexContextRepo.existsById(rcDTO.getContextSeqNo()))
  		{	
  		RatexContextMaster ratexContextMaster = ratexContextRepo.save(this.setRatexContextMaster(rcDTO));    
  		ratexContextDTO = this.getRatexContextMaster_DTO(ratexContextMaster);
  		}
  		
        return ratexContextDTO;
    }

    @Override
	public void updContext(RatexContextMaster_DTO rcReqDTO) 
    {
    	if(ratexContextRepo.existsById(rcReqDTO.getContextSeqNo()))
    	{
        RatexContextMaster ratexContextMaster = this.setRatexContextMaster(rcReqDTO);
        ratexContextMaster.setContextSeqNo(rcReqDTO.getContextSeqNo());
    	ratexContextRepo.save(ratexContextMaster);
    	}
    }
    	
    public void delSelectContexts(ArrayList<Long> cList)
    {
    	ratexContextRepo.delSelectContexts(cList);
        return;
    }
    
	@Override
	public void delAllContexts() 
    {
  		ratexContextRepo.deleteAll();      	
        return ;    
    }
    
    private ArrayList<RatexContextMaster_DTO> getRatexContextDtos(ArrayList<RatexContextMaster> rcReqMasters) 
	{
		ArrayList<RatexContextMaster_DTO> ratexContextDTOs = new ArrayList<RatexContextMaster_DTO>(); 
		for(int i=0; i < rcReqMasters.size();i++)
		{		
		ratexContextDTOs.add(this.getRatexContextMaster_DTO(rcReqMasters.get(i)));
		}		
		return ratexContextDTOs;
	}
	
	private RatexContextMaster_DTO getRatexContextMaster_DTO(RatexContextMaster rcReqMaster) 
	{
		RatexContextMaster_DTO ratexContextDTO = new RatexContextMaster_DTO();
		ratexContextDTO.setContextSeqNo(rcReqMaster.getContextSeqNo());
		ratexContextDTO.setDescription(rcReqMaster.getDescription());
		ratexContextDTO.setSummary(rcReqMaster.getSummary());
		return ratexContextDTO;
		}
		
	private RatexContextMaster setRatexContextMaster(RatexContextMaster_DTO ratexContextDTO) 
	{
		RatexContextMaster ratexContextMaster		=	new	RatexContextMaster();				
		ratexContextMaster.setDescription(ratexContextDTO.getDescription());
		ratexContextMaster.setSummary(ratexContextDTO.getSummary());		
		return ratexContextMaster;
	}

//	RATEX DETAILS
	
    @Override
	public ArrayList<RatexContextDetail_DTO> getAllContextDetails()
    {
    	ArrayList<RatexContextDetail> rcReqList = null;    	
    	rcReqList =  (ArrayList<RatexContextDetail>) ratexContextDetailsRepo.findAll();
    	ArrayList<RatexContextDetail_DTO> lDetails = new ArrayList<RatexContextDetail_DTO>();
    	lDetails = rcReqList != null ? this.getRatexContextDetailsDtos(rcReqList) : null;        
   		return lDetails;   		
    }
    
    @Override
	public ArrayList<RatexContextDetail_DTO> getSelectContextDetails(ArrayList<Long> coSeqNos, ArrayList<Long> rcSeqNos)
    {
    	ArrayList<RatexContextDetail> lDetails = ratexContextDetailsRepo.getSelectContextDetails(coSeqNos,rcSeqNos);
    	ArrayList<RatexContextDetail_DTO> rcDetailsDTOs = lDetails != null ? this.getRatexContextDetailsDtos(lDetails): null;
    	return rcDetailsDTOs;
    }
	
	@Override
	public ArrayList<RatexContextDetail_DTO> getSelectContextDetailsForCompanyUnits(ArrayList<Long> coSeqNos)
    {
    	ArrayList<RatexContextDetail> lDetails = ratexContextDetailsRepo.getSelectContextDetailsForCompanyUnits(coSeqNos);
    	ArrayList<RatexContextDetail_DTO> rcDetailsDTOs = lDetails != null ? this.getRatexContextDetailsDtos(lDetails): null;
    	return rcDetailsDTOs;
    }
            
    @Override
	public RatexContextDetail_DTO newContextDetail(RatexContextDetail_DTO rcdtDTO) 
    {    
		RatexContextDetailPK ratexContextDetailPK = new RatexContextDetailPK();
		ratexContextDetailPK.setCompanyUnitSeqNo(rcdtDTO.getCompanyUnitSeqNo());
		ratexContextDetailPK.setContextSeqNo(rcdtDTO.getContextSeqNo());    	
    	RatexContextDetail_DTO ratexContextDetailDTO = new RatexContextDetail_DTO();
		
  		if(!ratexContextDetailsRepo.existsById(ratexContextDetailPK))
  		{	
  		RatexContextDetail ratexContextDetail = ratexContextDetailsRepo.save(this.setRatexContextDetails(rcdtDTO));    
  		ratexContextDetailDTO = this.getRatexContextDetails_DTO(ratexContextDetail);
  		}
  		
        return ratexContextDetailDTO;
    }

    @Override
	public void updContextDetail(RatexContextDetail_DTO rcdtDTO) 
    {
		RatexContextDetailPK ratexContextDetailPK = new RatexContextDetailPK();
		ratexContextDetailPK.setCompanyUnitSeqNo(rcdtDTO.getCompanyUnitSeqNo());
		ratexContextDetailPK.setContextSeqNo(rcdtDTO.getContextSeqNo());    	
    	    	
    	if(ratexContextDetailsRepo.existsById(ratexContextDetailPK))    			
    	{
        RatexContextDetail ratexContextDetail = this.setRatexContextDetails(rcdtDTO);
        ratexContextDetailsRepo.save(ratexContextDetail);
    	}
    }
    	
    public void delSelectContextDetails(ArrayList<Long> coList, ArrayList<Long> rcdtList)
    {
    	ratexContextDetailsRepo.delSelectContextDetails(coList,rcdtList);
        return;
    }
    
    public void delSelectContextDetailsForCompanyUnits(ArrayList<Long> coList)
    {
    	ratexContextDetailsRepo.delSelectContextDetailsForCompanyUnits(coList);
        return;
    }
    
	@Override
	public void delAllContextDetails() 
    {
  		ratexContextRepo.deleteAll();      	
        return ;    
    }
    
    private ArrayList<RatexContextDetail_DTO> getRatexContextDetailsDtos(ArrayList<RatexContextDetail> rcReqlDetails) 
	{
		ArrayList<RatexContextDetail_DTO> ratexContextDTOs = new ArrayList<RatexContextDetail_DTO>(); 
		for(int i=0; i < rcReqlDetails.size();i++)
		{		
		ratexContextDTOs.add(this.getRatexContextDetails_DTO(rcReqlDetails.get(i)));
		}		
		return ratexContextDTOs;
	}
	
	private RatexContextDetail_DTO getRatexContextDetails_DTO(RatexContextDetail rcReqDetail) 
	{
		RatexContextDetail_DTO ratexContextDTO = new RatexContextDetail_DTO();
		ratexContextDTO.setCompanyUnitSeqNo(rcReqDetail.getId().getCompanyUnitSeqNo());
		ratexContextDTO.setContextSeqNo(rcReqDetail.getId().getContextSeqNo());
		return ratexContextDTO;
		}
		
	private RatexContextDetail setRatexContextDetails(RatexContextDetail_DTO ratexContextDetailDTO) 
	{
		RatexContextDetail ratexContextDetail		=	new	RatexContextDetail();
		RatexContextDetailPK ratexContextDetailPK = new RatexContextDetailPK();
		ratexContextDetailPK.setCompanyUnitSeqNo(ratexContextDetailDTO.getCompanyUnitSeqNo());
		ratexContextDetailPK.setContextSeqNo(ratexContextDetailDTO.getContextSeqNo());
		ratexContextDetail.setId(ratexContextDetailPK);				
		return ratexContextDetail;
	}
	
	
}