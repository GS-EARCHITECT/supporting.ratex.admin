package target_mgmt.master.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import target_mgmt.master.model.dto.RatexTargetMaster_DTO;
import target_mgmt.master.model.master.RatexTargetMaster;
import target_mgmt.master.model.repo.RatexTargetMaster_Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("ratexTargetServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class RatexTarget_Service implements IRatexTarget_Service 
{	
	//private static final Logger logger = LoggerFactory.getLogger(RatexTarget_Service.class);
	
	@Autowired
    private RatexTargetMaster_Repo ratexTargetRepo;
		
	@Override
	public ArrayList<RatexTargetMaster_DTO> getAllTargets()
    {
    	ArrayList<RatexTargetMaster> rcReqList = null;    	
    	rcReqList =  (ArrayList<RatexTargetMaster>) ratexTargetRepo.findAll();
    	ArrayList<RatexTargetMaster_DTO> lMasters = new ArrayList<RatexTargetMaster_DTO>();
    	lMasters = rcReqList != null ? this.getRatexTargetDtos(rcReqList) : null;        
   		return lMasters;   		
    }
    
    @Override
	public ArrayList<RatexTargetMaster_DTO> getSelectTargets(ArrayList<Long> rciceReqSeqNos)
    {
    	ArrayList<RatexTargetMaster> lMasters = ratexTargetRepo.getSelectTargets(rciceReqSeqNos);
    	ArrayList<RatexTargetMaster_DTO> rcMasterDTOs = lMasters != null ? this.getRatexTargetDtos(lMasters): null;
    	return rcMasterDTOs;
    }
            
    @Override
	public RatexTargetMaster_DTO newTarget(RatexTargetMaster_DTO rcDTO) 
    {    
		RatexTargetMaster_DTO ratexTargetDTO = new RatexTargetMaster_DTO();  		
  		if(!ratexTargetRepo.existsById(rcDTO.getTargetClassSeqNo()))
  		{	
  		RatexTargetMaster ratexTargetMaster = ratexTargetRepo.save(this.setRatexTargetMaster(rcDTO));    
  		ratexTargetDTO = this.getRatexTargetMaster_DTO(ratexTargetMaster);
  		}
  		
        return ratexTargetDTO;
    }

    @Override
	public void updTarget(RatexTargetMaster_DTO rcReqDTO) 
    {
    	if(ratexTargetRepo.existsById(rcReqDTO.getTargetClassSeqNo()))
    	{
        RatexTargetMaster ratexTargetMaster = this.setRatexTargetMaster(rcReqDTO);
        ratexTargetMaster.setTargetClassSeqNo(rcReqDTO.getTargetClassSeqNo());
    	ratexTargetRepo.save(ratexTargetMaster);
    	}
    }
    	
    public void delSelectTargets(ArrayList<Long> cList)
    {
    	ratexTargetRepo.delSelectTargets(cList);
        return;
    }
    
	@Override
	public void delAllTargets() 
    {
  		ratexTargetRepo.deleteAll();      	
        return ;    
    }
    
    private ArrayList<RatexTargetMaster_DTO> getRatexTargetDtos(ArrayList<RatexTargetMaster> rcReqMasters) 
	{
		ArrayList<RatexTargetMaster_DTO> ratexTargetDTOs = new ArrayList<RatexTargetMaster_DTO>(); 
		for(int i=0; i < rcReqMasters.size();i++)
		{		
		ratexTargetDTOs.add(this.getRatexTargetMaster_DTO(rcReqMasters.get(i)));
		}		
		return ratexTargetDTOs;
	}
	
	private RatexTargetMaster_DTO getRatexTargetMaster_DTO(RatexTargetMaster rcReqMaster) 
	{
		RatexTargetMaster_DTO ratexTargetDTO = new RatexTargetMaster_DTO();
		ratexTargetDTO.setTargetClassSeqNo(rcReqMaster.getTargetClassSeqNo());
		ratexTargetDTO.setTargetClass(rcReqMaster.getTargetClass());		
		return ratexTargetDTO;
		}
		
	private RatexTargetMaster setRatexTargetMaster(RatexTargetMaster_DTO ratexTargetDTO) 
	{
		RatexTargetMaster ratexTargetMaster		=	new	RatexTargetMaster();				
		ratexTargetMaster.setTargetClass(ratexTargetDTO.getTargetClass());
		return ratexTargetMaster;
	}

	
}