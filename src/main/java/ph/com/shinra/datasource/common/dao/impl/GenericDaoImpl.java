package ph.com.shinra.datasource.common.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;

import ph.com.shinra.datasource.common.dao.AbstractDao;
import ph.com.shinra.datasource.common.dao.GenericDao;

/**
 * This concrete class defines the default implementation of CRUD
 * operations. All DAO classes which will use CRUD operations should
 * extend this class.
 * 
 * @author Edwin Bautista
 *
 * @param <T> - The domain model for the instance of the DAO.
 * @param <PK> - The primary key of the domain model.
 */
@SuppressWarnings("unchecked")
public class GenericDaoImpl<T, PK extends Serializable> extends AbstractDao implements GenericDao<T, PK> {
	
	private final Class<T> type;
	
	public GenericDaoImpl(SessionFactory sessionFactory, Class<T> type) {
		super(sessionFactory);
		this.type = type;
	}
	
	@Override
	public PK create(T newInstance) {
		return (PK) getSession().save(newInstance);
	}

	@Override
	public T read(PK identifier) {
		return (T) getSession().get(this.type, identifier);
	}

	@Override
	public void update(T transientObject) {
		getSession().update(transientObject);
	}

	@Override
	public void delete(PK identifier) {
		getSession().delete(read(identifier));
	}
}
