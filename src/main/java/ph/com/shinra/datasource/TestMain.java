package ph.com.shinra.datasource;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ph.com.shinra.datasource.admin.model.Department;
import ph.com.shinra.datasource.admin.service.DepartmentService;
import ph.com.shinra.datasource.common.service.GenericService;

public class TestMain {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String[] contextXml = new String[]{ "hibernate-applicationContext.xml", "datasource-applicationContext.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(contextXml);
		
		GenericService<Department, Long> deptService = (GenericService<Department, Long>) ctx.getBean("departmentService");
		deptService.create(new Department("Sub 2", "lkdhsdfbdfkdjgbdfgbjfbgkjbg", null));
		
		DepartmentService deptSearchService = (DepartmentService) ctx.getBean("departmentService");
		List<Department> list = deptSearchService.search();
		
		for (Department department : list) {
			System.out.println(department.getName());
		}
	}

}
