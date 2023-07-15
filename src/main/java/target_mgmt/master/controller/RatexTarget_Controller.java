package target_mgmt.master.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import target_mgmt.master.model.dto.RatexTargetMaster_DTO;
import target_mgmt.master.services.IRatexTarget_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/ratexTargetMgmt")
public class RatexTarget_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(Customer_Target_Controller.class);

	@Autowired
	private IRatexTarget_Service ratexTargetServ;

	@PostMapping("/new")
	public ResponseEntity<RatexTargetMaster_DTO> newTarget(@RequestBody RatexTargetMaster_DTO ratexTargetDTO) 
	{
		RatexTargetMaster_DTO ratexTargetMaster_DTO = ratexTargetServ.newTarget(ratexTargetDTO);
		HttpHeaders httpHeaders = new HttpHeaders();		
		return new ResponseEntity<>(ratexTargetMaster_DTO, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllTargets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<RatexTargetMaster_DTO>> getAllTargets() {
		
		ArrayList<RatexTargetMaster_DTO> ratexTargetMaster_DTOs = ratexTargetServ.getAllTargets();
				return new ResponseEntity<>(ratexTargetMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTargets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<RatexTargetMaster_DTO>> getSelectTargets(@RequestBody ArrayList<Long> cList) {
		
		ArrayList<RatexTargetMaster_DTO> ratexTargetMaster_DTOs = ratexTargetServ.getSelectTargets(cList);
		return new ResponseEntity<>(ratexTargetMaster_DTOs, HttpStatus.OK);
	}

	@PutMapping("/updTarget")
	public void updTarget(@RequestBody RatexTargetMaster_DTO ratexTargetDTO) 
	{
		ratexTargetServ.updTarget(ratexTargetDTO);		
	}

	@DeleteMapping("/delSelectTargets")
	public void delSelectTargets(@RequestBody ArrayList<Long> cList)
	{
		ratexTargetServ.delSelectTargets(cList);
	}
	
	@DeleteMapping("/delAllTargets")
	public void deleteAllTargets() 
	{
		ratexTargetServ.delAllTargets();
	}
	
	
}