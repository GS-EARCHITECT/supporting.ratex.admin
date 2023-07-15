package target_mgmt.detail.model.dto;

import java.io.Serializable;

public class RatexTargetDetail_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1784410427088545994L;
	private Long targetSeqNo;
	private Long companyUnitSeqNo;
	private Long targetClassSeqNo;

	public Long getTargetSeqNo() {
		return targetSeqNo;
	}

	public void setTargetSeqNo(Long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
	}

	public Long getCompanyUnitSeqNo() {
		return companyUnitSeqNo;
	}

	public void setCompanyUnitSeqNo(Long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

	public Long getTargetClassSeqNo() {
		return targetClassSeqNo;
	}

	public void setTargetClassSeqNo(Long targetClassSeqNo) {
		this.targetClassSeqNo = targetClassSeqNo;
	}

	public RatexTargetDetail_DTO(Long targetSeqNo, Long companyUnitSeqNo, Long targetClassSeqNo) {
		super();
		this.targetSeqNo = targetSeqNo;
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.targetClassSeqNo = targetClassSeqNo;
	}

	public RatexTargetDetail_DTO() {
		super();
	}

}