package context_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RATEX_CONTEXT_MASTER database table.
 * 
 */
@Entity
@Table(name = "RATEX_CONTEXT_MASTER")
public class RatexContextMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ratex_context_sequence")
	@SequenceGenerator(name = "ratex_context_sequence", sequenceName = "ratex_context_sequence", allocationSize = 1)
	@Column(name = "CONTEXT_SEQ_NO")
	private Long contextSeqNo;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SUMMARY")
	private String summary;

	public RatexContextMaster() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setContextSeqNo(Long contextSeqNo) {
		this.contextSeqNo = contextSeqNo;
	}

	public Long getContextSeqNo() {
		return contextSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contextSeqNo == null) ? 0 : contextSeqNo.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RatexContextMaster other = (RatexContextMaster) obj;
		if (contextSeqNo == null) {
			if (other.contextSeqNo != null)
				return false;
		} else if (!contextSeqNo.equals(other.contextSeqNo))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		return true;
	}

	public RatexContextMaster(Long contextSeqNo, String description, String summary) {
		super();
		this.contextSeqNo = contextSeqNo;
		this.description = description;
		this.summary = summary;
	}

}