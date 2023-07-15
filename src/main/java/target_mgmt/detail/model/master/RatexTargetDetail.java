package target_mgmt.detail.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RATEX_TARGET_DETAILS database table.
 * 
 */
@Entity
@Table(name = "RATEX_TARGET_DETAILS")
public class RatexTargetDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ratex_target_sequence")
	@SequenceGenerator(name = "ratex_target_sequence", sequenceName = "ratex_target_sequence", allocationSize = 1)
	@Column(name = "TARGET_SEQ_NO")
	private Long targetSeqNo;

	@Column(name = "COMPANY_UNIT_SEQ_NO")
	private Long companyUnitSeqNo;

	@Column(name = "TARGET_CLASS_SEQ_NO")
	private Long targetClassSeqNo;

	public RatexTargetDetail() {
	}

	public Long getTargetSeqNo() {
		return this.targetSeqNo;
	}

	public void setTargetSeqNo(Long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
	}

	public Long getCompanyUnitSeqNo() {
		return this.companyUnitSeqNo;
	}

	public void setCompanyUnitSeqNo(Long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

	public Long getTargetClassSeqNo() {
		return this.targetClassSeqNo;
	}

	public void setTargetClassSeqNo(Long targetClassSeqNo) {
		this.targetClassSeqNo = targetClassSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyUnitSeqNo == null) ? 0 : companyUnitSeqNo.hashCode());
		result = prime * result + ((targetClassSeqNo == null) ? 0 : targetClassSeqNo.hashCode());
		result = prime * result + ((targetSeqNo == null) ? 0 : targetSeqNo.hashCode());
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
		RatexTargetDetail other = (RatexTargetDetail) obj;
		if (companyUnitSeqNo == null) {
			if (other.companyUnitSeqNo != null)
				return false;
		} else if (!companyUnitSeqNo.equals(other.companyUnitSeqNo))
			return false;
		if (targetClassSeqNo == null) {
			if (other.targetClassSeqNo != null)
				return false;
		} else if (!targetClassSeqNo.equals(other.targetClassSeqNo))
			return false;
		if (targetSeqNo == null) {
			if (other.targetSeqNo != null)
				return false;
		} else if (!targetSeqNo.equals(other.targetSeqNo))
			return false;
		return true;
	}

	public RatexTargetDetail(Long targetSeqNo, Long companyUnitSeqNo, Long targetClassSeqNo) {
		super();
		this.targetSeqNo = targetSeqNo;
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.targetClassSeqNo = targetClassSeqNo;
	}

}