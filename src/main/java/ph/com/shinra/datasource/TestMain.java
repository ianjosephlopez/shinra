package ph.com.shinra.datasource;

import java.util.List;

import ph.com.shinra.datasource.admin.model.Department;
import ph.com.shinra.datasource.admin.service.DepartmentService;
import ph.com.shinra.datasource.common.service.GenericService;
import ph.com.shinra.datasource.utils.ApplicationContextUtils;

public class TestMain {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		GenericService<Department, Long> deptService = (GenericService<Department, Long>) ApplicationContextUtils.getBean("departmentService");
		deptService.create(new Department("Sub 3", "lkdhsdfbdfkdjgbdfgbjfbgkjbg", null));
		
		DepartmentService deptSearchService = (DepartmentService) ApplicationContextUtils.getBean("departmentService");
		List<Department> list = deptSearchService.search();
		
		for (Department department : list) {
			System.out.println(department.getName());
		}
	}

}
