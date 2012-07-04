package ph.com.shinra.datasource.common.dao;

import java.io.Serializable;

/**
 * The foundation for a generic DAO is its CRUD operations. This
 * interface defines the methods for a generic DAO.
 * 
 * @author Edwin Bautista
 * 
 * @param <T> - The domain model for the instance of the DAO.
 * @param <PK> - The primary key of the domain model.
 */
public interface GenericDao<T, PK extends Serializable> {

    /**
     * Persist the newInstance object into database.
     * 
     * @param newInstance
     *            The object to be persisted into the database.
     * @return The primary key of the persisted object.
     */
    PK create(T newInstance);

    /**
     * Retrieve an object that was previously persisted to the database using
     * the indicated id as primary key.
     * 
     * @param identifier
     *            The primary key of the object to be retrieved.
     * @return The retrieved object.
     */
    T read(PK identifier);

    /**
     * Save changes made to a persistent object.
     * 
     * @param transientObject
     *            The object to be updated.
     */
    void update(T transientObject);

    /**
     * Remove an object from persistent storage in the database.
     * 
     * @param persistentObject
     *            The object to be deleted.
     */
    void delete(PK identifier);

}