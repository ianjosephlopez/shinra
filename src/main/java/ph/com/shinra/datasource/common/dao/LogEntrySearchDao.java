package ph.com.shinra.datasource.common.dao;

import java.util.Date;
import java.util.List;

import ph.com.shinra.datasource.common.model.LogEntry;

public interface LogEntrySearchDao {
	
	/**
	 * Get all log entries for the entire application
	 * 
	 * @return - list of logs
	 */
	List<LogEntry> searchLogEntries();
	
	/**
	 * Get all log entries for the entire application for a given date range
	 * 
	 * @param fromDate - start date for the log entries to show
	 * @param toDate - end date for the log entries to show
	 * 
	 * @return - list of logs
	 */
	List<LogEntry> searchLogEntriesByDateRange(Date fromDate, Date toDate);
	
	/**
	 * Get all log entries for a specific table
	 * 
	 * @param tableName - table whose logs is desired
	 * 
	 * @return - list of logs
	 */
	List<LogEntry> searchLogEntriesByTableName(String tableName);
	
	/**
	 * Get all log entries for a specific user
	 * 
	 * @param userId - id of the user who made changes to records in the application
	 * 
	 * @return - list of logs
	 */
	List<LogEntry> searchLogEntriesByEmployeeId(Long userId);
	
	/**
	 * Get all log entries for a specific row in a table
	 * 
	 * @param tableName - table whose logs is desired
	 * @param rowId - row whose logs is desired
	 * 
	 * @return - list of logs
	 */
	List<LogEntry> searchLogEntriesByTableNameAndRowId(String tableName, Long rowId);
	
	/**
	 * Get all log entries for a specific table modified by a specific user
	 * 
	 * @param tableName - table whose logs is desired
	 * @param userId - id of the user who made changes to records in the specified table
	 * 
	 * @return - list of logs
	 */
	List<LogEntry> searchLogEntriesByTableNameAndEmployeeId(String tableName, Long userId);
	
}
