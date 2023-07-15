package target_mgmt.master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RATEX_TARGET_MASTER database table.
 * 
 */
@Entity
@Table(name = "RATEX_TARGET_MASTER")
public class RatexTargetMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ratex_targetclass_sequence")
	@SequenceGenerator(name = "ratex_targetclass_sequence", sequenceName = "ratex_targetclass_sequence", allocationSize = 1)
	@Column(name = "TARGET_CLASS_SEQ_NO")
	private Long targetClassSeqNo;

	@Column(name = "TARGET_CLASS")
	private String targetClass;

	public RatexTargetMaster() {
	}

	public Long getTargetClassSeqNo() {
		return this.targetClassSeqNo;
	}

	public void setTargetClassSeqNo(Long targetClassSeqNo) {
		this.targetClassSeqNo = targetClassSeqNo;
	}

	public String getTargetClass() {
		return this.targetClass;
	}

	public void setTargetClass(String targetClass) {
		this.targetClass = targetClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((targetClass == null) ? 0 : targetClass.hashCode());
		result = prime * result + (int) (targetClassSeqNo ^ (targetClassSeqNo >>> 32));
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
		RatexTargetMaster other = (RatexTargetMaster) obj;
		if (targetClass == null) {
			if (other.targetClass != null)
				return false;
		} else if (!targetClass.equals(other.targetClass))
			return false;
		if (targetClassSeqNo != other.targetClassSeqNo)
			return false;
		return true;
	}

	public RatexTargetMaster(Long targetClassSeqNo, String targetClass) {
		super();
		this.targetClassSeqNo = targetClassSeqNo;
		this.targetClass = targetClass;
	}

}