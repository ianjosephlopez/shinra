package ph.com.shinra.datasource.common.model;

/**
 * Interface to be use by classes that has activation and expiration period.
 * 
 * @author Edwin Bautista
 *
 */
public interface Expirable {
	
	/**
     * Indicates whether or not the {@link Class} is currently active or not. This is the same</br> 
     * as calling !{@link #isExpired()}
     * 
     * @return <b>true</b> if and only if the {@link Class} is currently active.
     */
	boolean isActive();
	
	/**
     * Determines whether or not the {@link Class} has expired. This is the same as</br>
     * calling !{@link #isActive()}
     * 
     * @return <b>true</b> if and only if this {@link Class} has expired.
     */
    boolean isExpired();
}
