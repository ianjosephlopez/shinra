package ph.com.shinra.datasource.admin.model;

import ph.com.shinra.datasource.common.model.AbstractModel;

public class Department extends AbstractModel<Long> {
	
	private static final long serialVersionUID = 6626837987001877525L;
	
	private String name;
	private String description;
	private Department parent;
	
	public Department() {
		super();
	}

	public Department(String name, String description, Department parent) {
		super();
		this.name = name;
		this.description = description;
		this.parent = parent;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getParent() {
		return parent;
	}
	
	public void setParent(Department parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Department [" 
				+ "Id=" + getId() + CONST_STRING_SEPARATOR 
				+ "name=" + getName() + CONST_STRING_SEPARATOR 
				+ "description=" + getDescription() + CONST_STRING_SEPARATOR
				+ "parent=" + getParent()
				+ "]\n";
	}
}
