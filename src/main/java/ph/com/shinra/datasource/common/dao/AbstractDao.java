package ph.com.shinra.datasource.common.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.ResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * An abstract class to provide {@link SessionFactory} instance and {@link LoggerFactory} instance.
 * 
 * @author Edwin Bautista
 */
public abstract class AbstractDao implements InitializingBean {

    /**
     * Logging instance made available to subclasses
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * The injected Hibernate {@link SessionFactory}
     */
    private final SessionFactory sessionFactory;

    /**
     * Creates a new {@link AbstractDao} instance with a Hibernate
     * {@link SessionFactory}.
     */
    public AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Checks if all mandatory fields have been set.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(sessionFactory, "SessionFactory has not been set");
    }

    /**
     * Gets the current session from the injected {@link SessionFactory}.
     * Requires a {@link Session} to already be bound to the thread, by using
     * <code>@Transactional</code> annotations, or a transaction advice.
     * 
     * @return the current hibernate Session.
     */
    protected final Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    /**
     * Provides logging in debug mode.
     *  
     * @param log - message to display in the console
     */
    public void setLog(String log) {
		if (logger.isDebugEnabled()) logger.debug(log);
	}
    
	/**
	 * Retrieves an object for given named query and supplied parameters.
	 *  
	 * @param namedQuery The named query as known in Hibernate
	 * @param parameters The parameters to set.
	 * @param resultTransformer The {@link ResultTransformer} to use - can be null
	 * 
	 * @return The {@link List} with results
	 * 
	 * @throws HibernateException When an error occurs or more than one result has been found  
	 */
	@SuppressWarnings("unchecked")
	protected final <T> List<T> retrieveList(String namedQuery, Map<String, Object> parameters, 
			ResultTransformer resultTransformer) {
	    return (List<T>) getNamedQuery(namedQuery, parameters, resultTransformer).list();
	}
	
	/**
	 * Retrieves an object for given named query and supplied parameters.
	 *  
	 * @param namedQuery The named query as known in Hibernate
	 * @param parameters The parameters to set.
	 * @param resultTransformer The {@link ResultTransformer} to use - can be null
	 * 
	 * @return The unique result or null if not found</br>
	 * 
	 * @throws HibernateException When an error occurs or more than one result has been found  
	 */
	@SuppressWarnings("unchecked")
	protected final <T> T retrieveUnique(String namedQuery, Map<String, Object> parameters, ResultTransformer resultTransformer) {
	    return (T) getNamedQuery(namedQuery, parameters, resultTransformer).uniqueResult();
	}
	
	private Query getNamedQuery(String namedQuery, Map<String, Object> parameters, ResultTransformer resultTransformer) {
	    Query query = getSession().getNamedQuery(namedQuery).setProperties(parameters);
	    if (resultTransformer != null) query.setResultTransformer(resultTransformer);
	    
		return query;	
	}
}
