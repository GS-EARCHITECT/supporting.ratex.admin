package context_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RATEX_CONTEXT_DETAILS database table.
 * 
 */
@Entity
@Table(name = "RATEX_CONTEXT_DETAILS")
public class RatexContextDetail implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RatexContextDetailPK id;

	public RatexContextDetail() {
	}

	public RatexContextDetailPK getId() {
		return this.id;
	}

	public void setId(RatexContextDetailPK id) {
		this.id = id;
	}

	public RatexContextDetail(RatexContextDetailPK id) {
		super();
		this.id = id;
	}

}