package ph.com.shinra.datasource.admin.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import ph.com.shinra.datasource.admin.dao.DepartmentSearchDao;
import ph.com.shinra.datasource.admin.model.Department;
import ph.com.shinra.datasource.admin.service.DepartmentService;
import ph.com.shinra.datasource.common.dao.GenericDao;
import ph.com.shinra.datasource.common.service.impl.GenericServiceImpl;

public class DepartmentServiceImpl extends GenericServiceImpl<Department, Long> implements
		DepartmentService {
	
	private final DepartmentSearchDao searchDao;
	
	public DepartmentServiceImpl(GenericDao<Department, Long> genericDao, DepartmentSearchDao searchDao) {
		super(genericDao);
		this.searchDao = searchDao;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Department> search() {
		return searchDao.search();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		Assert.notNull(searchDao);
	}
}
