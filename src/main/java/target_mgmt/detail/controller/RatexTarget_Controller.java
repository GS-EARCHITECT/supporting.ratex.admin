package target_mgmt.detail.controller;

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
import target_mgmt.detail.model.dto.RatexTargetDetail_DTO;
import target_mgmt.detail.services.IRatexTargetDetails_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/ratexTargetDetailsMgmt")
public class RatexTarget_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(Customer_Target_Controller.class);

	@Autowired
	private IRatexTargetDetails_Service ratexTargetDetailsServ;

	@PostMapping("/new")
	public ResponseEntity<RatexTargetDetail_DTO> newTargetDetail(@RequestBody RatexTargetDetail_DTO ratexTargetDTO) 
	{
		RatexTargetDetail_DTO ratexTargetDetail_DTO = ratexTargetDetailsServ.newTargetDetail(ratexTargetDTO);
		HttpHeaders httpHeaders = new HttpHeaders();		
		return new ResponseEntity<>(ratexTargetDetail_DTO, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<RatexTargetDetail_DTO>> getAllTargetDetails() {
		
		ArrayList<RatexTargetDetail_DTO> ratexTargetDetail_DTOs = ratexTargetDetailsServ.getAllTargetDetails();
				return new ResponseEntity<>(ratexTargetDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<RatexTargetDetail_DTO>> getSelectTargetDetails(@RequestBody ArrayList<Long> cList) {
		
		ArrayList<RatexTargetDetail_DTO> ratexTargetDetail_DTOs = ratexTargetDetailsServ.getSelectTargetDetails(cList);
		return new ResponseEntity<>(ratexTargetDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTargetDetailsForClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<RatexTargetDetail_DTO>> getSelectTargetDetailsForClasses(@RequestBody ArrayList<Long> cList) {
		
		ArrayList<RatexTargetDetail_DTO> ratexTargetDetail_DTOs = ratexTargetDetailsServ.getSelectTargetsForTargetClasses(cList);
		return new ResponseEntity<>(ratexTargetDetail_DTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updTargetDetail")
	public void updTargetDetail(@RequestBody RatexTargetDetail_DTO ratexTargetDetailDTO) 
	{
		ratexTargetDetailsServ.updTargetDetail(ratexTargetDetailDTO);		
	}

	@DeleteMapping("/delSelectTargetDetails")
	public void delSelectTargets(@RequestBody ArrayList<Long> cList)
	{
		ratexTargetDetailsServ.delSelectTargetDetails(cList);
	}
	
	@DeleteMapping("/delSelectTargetDetailsForClasses")
	public void delSelectTargetsForClasses(@RequestBody ArrayList<Long> cList)
	{
		ratexTargetDetailsServ.delSelectTargetsForTargetClasses(cList);
	}
	
	@DeleteMapping("/delAllTargetDetails")
	public void deleteAllTargetDetails() 
	{
		ratexTargetDetailsServ.delAllTargetDetails();
	}
	
	
}