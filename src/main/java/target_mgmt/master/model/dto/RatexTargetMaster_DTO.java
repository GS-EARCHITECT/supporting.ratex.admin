package target_mgmt.master.model.dto;

import java.io.Serializable;

public class RatexTargetMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3578650434377135217L;
	private Long targetClassSeqNo;
	private String targetClass;

	public Long getTargetClassSeqNo() {
		return targetClassSeqNo;
	}

	public void setTargetClassSeqNo(Long targetClassSeqNo) {
		this.targetClassSeqNo = targetClassSeqNo;
	}

	public String getTargetClass() {
		return targetClass;
	}

	public void setTargetClass(String targetClass) {
		this.targetClass = targetClass;
	}

	public RatexTargetMaster_DTO(Long targetClassSeqNo, String targetClass) {
		super();
		this.targetClassSeqNo = targetClassSeqNo;
		this.targetClass = targetClass;
	}

	public RatexTargetMaster_DTO() {
		super();
	}

}