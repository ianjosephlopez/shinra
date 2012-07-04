package ph.com.shinra.datasource.admin.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import ph.com.shinra.datasource.common.model.AbstractModel;

public class Employee extends AbstractModel<Long> {

	private static final long serialVersionUID = 4267101002284066008L;
	
	private String lastName;
	private String firstName;
	private String middleName;
	
	private Date dateHired;
	private Date dateResigned;
	private Date dateOfBirth;
	
	private String externalId;
	
	private Character gender;
	private Character civilStatus;
	
	private String tinNumber;
	
	private Collection<EmployeeContact> employeeContact = Collections.emptySet();
	
	public Employee() {
		super();
	}

	public Employee(String lastName, String firstName, String middleName,
			Date dateHired, Date dateResigned, Date dateOfBirth,
			String externalId, Character gender, Character civilStatus,
			String tinNumber) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.dateHired = dateHired;
		this.dateResigned = dateResigned;
		this.dateOfBirth = dateOfBirth;
		this.externalId = externalId;
		this.gender = gender;
		this.civilStatus = civilStatus;
		this.tinNumber = tinNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}

	public Date getDateResigned() {
		return dateResigned;
	}

	public void setDateResigned(Date dateResigned) {
		this.dateResigned = dateResigned;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Character getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(Character civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getTinNumber() {
		return tinNumber;
	}

	public void setTinNumber(String tinNumber) {
		this.tinNumber = tinNumber;
	}

	public Collection<EmployeeContact> getEmployeeContact() {
		return employeeContact;
	}

	public void setEmployeeContact(Collection<EmployeeContact> employeeContact) {
		this.employeeContact = employeeContact;
	}

	@Override
	public String toString() {
		return "Employee [" 
				+ "id=" + getId() + CONST_STRING_SEPARATOR
				+ "lastName=" + getLastName() + CONST_STRING_SEPARATOR
				+ "firstName=" + getFirstName() + CONST_STRING_SEPARATOR
				+ "middleName=" + getMiddleName() + CONST_STRING_SEPARATOR 
				+ "dateHired=" + getDateHired() + CONST_STRING_SEPARATOR
				+ "dateResigned=" + getDateResigned() + CONST_STRING_SEPARATOR
				+ "dateOfBirth=" + getDateOfBirth() + CONST_STRING_SEPARATOR
				+ "externalId=" + getExternalId() + CONST_STRING_SEPARATOR
				+ "gender=" + getGender() + CONST_STRING_SEPARATOR
				+ "civilStatus=" + getCivilStatus() + CONST_STRING_SEPARATOR
				+ "tinNumber=" + getTinNumber()
				+ "]\n";
	}
}
