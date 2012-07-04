package ph.com.shinra.datasource.admin.model;

import ph.com.shinra.datasource.common.model.AbstractModel;
import ph.com.shinra.datasource.common.model.BusinessCode;

public class EmployeeContact extends AbstractModel<Long> {

	private static final long serialVersionUID = 2754148962548984468L;
	
	private Employee employee;
	private BusinessCode type;
	private String details;
	
	public EmployeeContact() {
		super();
	}

	public EmployeeContact(Employee employee, BusinessCode type, String details) {
		super();
		this.employee = employee;
		this.type = type;
		this.details = details;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public BusinessCode getType() {
		return type;
	}

	public void setType(BusinessCode type) {
		this.type = type;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
