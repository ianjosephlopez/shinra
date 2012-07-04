package ph.com.shinra.datasource.common.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import ph.com.shinra.datasource.common.dao.AbstractDao;
import ph.com.shinra.datasource.common.dao.LogEntrySearchDao;
import ph.com.shinra.datasource.common.model.LogEntry;

public class LogEntryDaoImpl extends AbstractDao implements LogEntrySearchDao {
	
	private Map<String, Object> queryParam = new HashMap<String, Object>();
	
	public LogEntryDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public List<LogEntry> searchLogEntries() {
		return retrieveList("logEntries", null, null);
	}

	@Override
	public List<LogEntry> searchLogEntriesByDateRange(Date fromDate, Date toDate) {
		queryParam.put("fromDate", fromDate);
		queryParam.put("toDate", toDate);
		
		return retrieveList("logEntriesByDateRange", queryParam, null);
	}

	@Override
	public List<LogEntry> searchLogEntriesByTableName(String tableName) {
		queryParam.put("tableName", tableName);
		
		return retrieveList("logEntriesByTableName", queryParam, null);
	}

	@Override
	public List<LogEntry> searchLogEntriesByEmployeeId(Long employeeId) {
		queryParam.put("employeeId", employeeId);
		
		return retrieveList("logEntriesByEmployeeId", queryParam, null);
	}

	@Override
	public List<LogEntry> searchLogEntriesByTableNameAndRowId(String tableName, Long rowId) {
		queryParam.put("tableName", tableName);
		queryParam.put("rowId", rowId);
		
		return retrieveList("logEntriesByTableNameAndRowId", queryParam, null);
	}

	@Override
	public List<LogEntry> searchLogEntriesByTableNameAndEmployeeId(String tableName, Long employeeId) {
		queryParam.put("tableName", tableName);
		queryParam.put("employeeId", employeeId);
		
		return retrieveList("logEntriesByTableNameAndEmployeeId", queryParam, null);
	}
}
