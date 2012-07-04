package ph.com.shinra.datasource.admin.dao;

import java.util.List;

import ph.com.shinra.datasource.admin.model.Department;

public interface DepartmentSearchDao {
	List<Department> search();
}
