package ph.com.shinra.datasource.admin.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hibernate.PropertyValueException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ph.com.shinra.datasource.admin.model.Department;
import ph.com.shinra.datasource.common.dao.impl.GenericDaoImpl;

@ContextConfiguration(locations={"/test-applicationContext.xml", "/datasource-applicationContext.xml"})
public class DepartmentsDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired(required=true)
	@Qualifier(value="departmentDao")
	private GenericDaoImpl<Department, Long> departmentDao;
	
	@Autowired(required=true)
	private DepartmentDaoImpl searchDao;
	
	private Department department;
	
	@Before
	public void setup() throws Exception {
		setSqlScriptEncoding("UTF-8");
		executeSqlScript("test_datasource.sql", false);
		
		department = new Department("Sales 1", null, new Department("Sales", null, null));
	}
	
	@Test
	public void testRead() {
		Department department = departmentDao.read(1L);
		assertNotNull(department);
	}
	
	@Test
	public void testCreate() {
		Long id = departmentDao.create(department);
		assertNotNull(id);
		
		Department fromDB = departmentDao.read(id);
		assertNotNull(fromDB);
		
		assertEquals(id, fromDB.getId());
		assertEquals(department.getName(), fromDB.getName());
		assertEquals(department.getParent(), fromDB.getParent());
	}
	
	@Test
	public void testUpdate() {
		Long id = departmentDao.create(department);
		
		department.setName("Sales Branch 1");
		departmentDao.update(department);
		
		Department fromDB = departmentDao.read(id);
		assertNotNull(fromDB);
		
		assertEquals(fromDB.getName(), "Sales Branch 1");
		assertNotNull(fromDB.getParent());
	}
	
	@Test
	public void testDelete() {
		departmentDao.delete(1L);
		
		Department fromDB = departmentDao.read(1L);
		assertNull(fromDB);
	}
	
	@Test
	public void testSearch() {
		List<Department> list = searchDao.search();
		
		assertNotNull(list);
		assertEquals(5L, list.size());
	}
	
	@Test(expected=PropertyValueException.class)
	public void testCreateWithNullName() {
		Department newDept = new Department(null, null, departmentDao.read(3L));
		departmentDao.create(newDept);
	}
}
