package context_mgmt.controller;

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
import context_mgmt.model.dto.RatexContextDetail_DTO;
import context_mgmt.model.dto.RatexContextMaster_DTO;
import context_mgmt.services.IRatexContext_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/ratexContextMgmt")
public class RatexContext_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(Customer_Request_Controller.class);

// RATEX CONTEXT MASTER	
	
	@Autowired
	private IRatexContext_Service ratexContextServ;

	@PostMapping("/new")
	public ResponseEntity<RatexContextMaster_DTO> newRequest(@RequestBody RatexContextMaster_DTO ratexContextDTO) 
	{
		RatexContextMaster_DTO ratexContextMaster_DTO = ratexContextServ.newContext(ratexContextDTO);
		HttpHeaders httpHeaders = new HttpHeaders();		
		return new ResponseEntity<>(ratexContextMaster_DTO, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllContexts", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<RatexContextMaster_DTO>> getAllContexts() {
		
		ArrayList<RatexContextMaster_DTO> ratexContextMaster_DTOs = ratexContextServ.getAllContexts();
				return new ResponseEntity<>(ratexContextMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectContexts", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<RatexContextMaster_DTO>> getSelectContexts(@RequestBody ArrayList<Long> cList) {
		
		ArrayList<RatexContextMaster_DTO> ratexContextMaster_DTOs = ratexContextServ.getSelectContexts(cList);
		return new ResponseEntity<>(ratexContextMaster_DTOs, HttpStatus.OK);
	}

	@PutMapping("/updContext")
	public void updContext(@RequestBody RatexContextMaster_DTO ratexContextDTO) 
	{
		ratexContextServ.updContext(ratexContextDTO);		
	}

	@DeleteMapping("/delSelectContexts")
	public void delSelectContexts(@RequestBody ArrayList<Long> cList)
	{
		ratexContextServ.delSelectContexts(cList);
	}
	
	@DeleteMapping("/delAllContexts")
	public void deleteAllContexts() 
	{
		ratexContextServ.delAllContexts();
	}
	
// RATEX CONTEXT DETAILS
	
	@PostMapping("/newDetail")
	public ResponseEntity<RatexContextDetail_DTO> newContextDetail(@RequestBody RatexContextDetail_DTO ratexContextDetailDTO) 
	{
		RatexContextDetail_DTO ratexContextDetail_DTO = ratexContextServ.newContextDetail(ratexContextDetailDTO);
		HttpHeaders httpHeaders = new HttpHeaders();		
		return new ResponseEntity<>(ratexContextDetail_DTO, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllContextDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<RatexContextDetail_DTO>> getAllContextDetails() {
		
		ArrayList<RatexContextDetail_DTO> ratexContextDetail_DTOs = ratexContextServ.getAllContextDetails();
				return new ResponseEntity<>(ratexContextDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectContextDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<RatexContextDetail_DTO>> getSelectContextDetails(@RequestBody ArrayList<Long> coList, @RequestBody ArrayList<Long> rcdtList)
	{
		
		ArrayList<RatexContextDetail_DTO> ratexContextDetail_DTOs = ratexContextServ.getSelectContextDetails(coList, rcdtList);
		return new ResponseEntity<>(ratexContextDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectContextDetailsForCompanyUnits", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<RatexContextDetail_DTO>> getSelectContextDetailsForCompanyUnits(@RequestBody ArrayList<Long> coList)
	{
		
		ArrayList<RatexContextDetail_DTO> ratexContextDetail_DTOs = ratexContextServ.getSelectContextDetailsForCompanyUnits(coList);
		return new ResponseEntity<>(ratexContextDetail_DTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updContextDetail")
	public void updContextDetail(@RequestBody RatexContextDetail_DTO ratexContextDetailDTO) 
	{
		ratexContextServ.updContextDetail(ratexContextDetailDTO);		
	}

	@DeleteMapping("/delSelectContexts")
	public void delSelectContexts(@RequestBody ArrayList<Long> coList, @RequestBody ArrayList<Long> rcdtList)
	{
		ratexContextServ.delSelectContextDetails(coList, rcdtList);
	}
	
	@DeleteMapping("/delSelectContextsForCompanyUnits")
	public void delSelectContextsForCompanyUnits(@RequestBody ArrayList<Long> coList, @RequestBody ArrayList<Long> rcdtList)
	{
		ratexContextServ.delSelectContextDetailsForCompanyUnits(coList);
	}
	
	@DeleteMapping("/delAllContextDetails")
	public void deleteAllContextDetails() 
	{
		ratexContextServ.delAllContextDetails();;
	}
	
}