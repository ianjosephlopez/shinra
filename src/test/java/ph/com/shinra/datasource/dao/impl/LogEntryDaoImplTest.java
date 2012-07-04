package ph.com.shinra.datasource.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ph.com.shinra.datasource.common.dao.impl.LogEntryDaoImpl;
import ph.com.shinra.datasource.common.model.LogEntry;

@ContextConfiguration(locations={"/test-applicationContext.xml", "/datasource-applicationContext.xml"})
public class LogEntryDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired(required=true)
	LogEntryDaoImpl logEntryDaoImpl;
	
	@Before
	public void setUp() throws Exception {
		setSqlScriptEncoding("UTF-8");
		executeSqlScript("test_datasource.sql", false);
	}

	@Test
	public void testSearchLogEntries() {
		List<LogEntry> list = logEntryDaoImpl.searchLogEntries();
		assertNotNull(list);
		assertEquals(5L, list.size());
	}

	@Test
	public void testSearchLogEntriesByDateRange() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fromDate = formatter.parse("2012-05-15");
		Date toDate = formatter.parse("2012-05-27");
		
		List<LogEntry> list = logEntryDaoImpl.searchLogEntriesByDateRange(fromDate, toDate);
		assertNotNull(list);
		assertEquals(4L, list.size());
	}
	
	@Test
	public void testSearchLogEntriesByTableName() {
		List<LogEntry> list = logEntryDaoImpl.searchLogEntriesByTableName("DEPARTMENTS");
		assertNotNull(list);
		assertEquals(5L, list.size());
	}
	
	@Test
	public void testLogEntriesByEmployeeId() {
		List<LogEntry> list = logEntryDaoImpl.searchLogEntriesByEmployeeId(3L);
		assertNotNull(list);
		assertEquals(2L, list.size());
	}
	
	@Test
	public void testLogEntriesByTableNameAndRowId() {
		List<LogEntry> list = logEntryDaoImpl.searchLogEntriesByTableNameAndRowId("DEPARTMENTS", 4L);
		assertNotNull(list);
		assertEquals(2L, list.size());
	}
	
	@Test
	public void testLogEntriesByTableNameAndEmployeeId() {
		List<LogEntry> list = logEntryDaoImpl.searchLogEntriesByTableNameAndEmployeeId("DEPARTMENTS", 1L);
		assertNotNull(list);
		assertEquals(2L, list.size());
	}
}
