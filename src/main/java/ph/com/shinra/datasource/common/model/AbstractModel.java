package ph.com.shinra.datasource.common.model;

import java.io.Serializable;

public abstract class AbstractModel<PK> implements Serializable {

	private static final long serialVersionUID = 7416300721081024252L;
	
	protected static final String CONST_STRING_SEPARATOR = ", ";
	
	private PK id;

	public AbstractModel() {
	}

	public AbstractModel(PK id) {
		this.setId(id);
	}

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}
}
