package context_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RATEX_CONTEXT_DETAILS database table.
 * 
 */
@Embeddable
public class RatexContextDetailPK implements Serializable 
{

	private static final long serialVersionUID = 1L;

	@Column(name="COMPANY_UNIT_SEQ_NO")
	private Long companyUnitSeqNo;

	@Column(name="CONTEXT_SEQ_NO")
	private Long contextSeqNo;

	public RatexContextDetailPK() {
	}
	public Long getCompanyUnitSeqNo() {
		return this.companyUnitSeqNo;
	}
	public void setCompanyUnitSeqNo(Long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}
	public Long getContextSeqNo() {
		return this.contextSeqNo;
	}
	public void setContextSeqNo(Long contextSeqNo) {
		this.contextSeqNo = contextSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RatexContextDetailPK)) {
			return false;
		}
		RatexContextDetailPK castOther = (RatexContextDetailPK)other;
		return 
			(this.companyUnitSeqNo == castOther.companyUnitSeqNo)
			&& (this.contextSeqNo == castOther.contextSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.companyUnitSeqNo ^ (this.companyUnitSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.contextSeqNo ^ (this.contextSeqNo >>> 32)));
		
		return hash;
	}
	public RatexContextDetailPK(Long companyUnitSeqNo, Long contextSeqNo) {
		super();
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.contextSeqNo = contextSeqNo;
	}
	
	
}