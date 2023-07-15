package context_mgmt.model.dto;

import java.io.Serializable;

public class RatexContextDetail_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4097551080051212014L;
	private Long companyUnitSeqNo;
	private Long contextSeqNo;

	public Long getCompanyUnitSeqNo() {
		return companyUnitSeqNo;
	}

	public void setCompanyUnitSeqNo(Long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

	public Long getContextSeqNo() {
		return contextSeqNo;
	}

	public void setContextSeqNo(Long contextSeqNo) {
		this.contextSeqNo = contextSeqNo;
	}

	public RatexContextDetail_DTO(Long companyUnitSeqNo, Long contextSeqNo) {
		super();
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.contextSeqNo = contextSeqNo;
	}

	public RatexContextDetail_DTO() {
		super();
	}

}