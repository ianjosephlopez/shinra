package ph.com.shinra.datasource.common.model;

import java.sql.Timestamp;

/**
 * Represents log entries for every INSERT/UPDATE/DELETE operation. 
 * 
 * @author Edwin Bautista
 *
 */
public class LogEntry extends AbstractModel<Long> {

	private static final long serialVersionUID = 6433143984846324373L;
	
	private Timestamp entryStamp;
	private Long rowId;
	private String tableName;
	private Long employeeId;
	private String operationType;
	
	public LogEntry() {
		super();
	}

	public Timestamp getEntryStamp() {
		return entryStamp;
	}
	
	public void setEntryStamp(Timestamp entryStamp) {
		this.entryStamp = entryStamp;
	}
	
	public Long getRowId() {
		return rowId;
	}
	
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@Override
	public String toString() {
		return "LogEntry [" 
				+ "id=" + getId() + CONST_STRING_SEPARATOR
				+ "entryStamp=" + getEntryStamp() + CONST_STRING_SEPARATOR
				+ "tableName=" + getTableName() + CONST_STRING_SEPARATOR
				+ "employeeId=" + getEmployeeId() + CONST_STRING_SEPARATOR 
				+ "operationType=" + getOperationType()
				+ "]\n";
	}
}
