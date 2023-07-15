package context_mgmt.model.dto;

import java.io.Serializable;

public class RatexContextMaster_DTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5069013533334924987L;
	private Long contextSeqNo;
	private String description;
	private String summary;

	public Long getContextSeqNo() {
		return contextSeqNo;
	}

	public void setContextSeqNo(Long contextSeqNo) {
		this.contextSeqNo = contextSeqNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public RatexContextMaster_DTO(Long contextSeqNo, String description, String summary) {
		super();
		this.contextSeqNo = contextSeqNo;
		this.description = description;
		this.summary = summary;
	}

	public RatexContextMaster_DTO() {
		super();
	}

}