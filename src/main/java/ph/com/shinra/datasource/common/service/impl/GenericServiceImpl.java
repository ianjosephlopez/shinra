package ph.com.shinra.datasource.common.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import ph.com.shinra.datasource.common.dao.GenericDao;
import ph.com.shinra.datasource.common.service.GenericService;

/**
 * Default implementation of {@link GenericService} handling CRUD actions.
 * 
 * This class has the CRUD actions declared as final, but the class it self is not, 
 * allowing to add additional functionality.
 * 
 * @author Edwin Bautista
 *
 * @param <T> The type
 * @param <PK> The Primary Key of the type
 */
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK>, InitializingBean {
	
	private final GenericDao<T, PK> genericDao;
	
	public GenericServiceImpl(final GenericDao<T, PK> genericDao) {
		this.genericDao = genericDao;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(genericDao);
	}
	
	@Override
	@Transactional(rollbackFor=RuntimeException.class)
	public PK create(T newInstance) {
		return genericDao.create(newInstance);
	}

	@Override
	@Transactional(rollbackFor=RuntimeException.class)
	public final void delete(PK identifier) {
		genericDao.delete(identifier);
	}
	
	@Override
	@Transactional(readOnly=true, rollbackFor=RuntimeException.class)
	public final T read(PK identifier) {
		return genericDao.read(identifier);
	}

	@Override
	@Transactional(rollbackFor=RuntimeException.class)
	public void update(T transientObject) {
		genericDao.update(transientObject);
	}
}
