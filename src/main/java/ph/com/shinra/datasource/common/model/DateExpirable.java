package ph.com.shinra.datasource.common.model;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import ph.com.shinra.datasource.common.utils.CoreDateUtils;

/**
 * {@link Date} based implementation of the {@link Expirable} interface.</br>
 * 
 * {@link DateExpirable} is <b>inclusive</b> of the fromDate and untilDate.</br>
 * 
 * @author Edwin Bautista
 *
 */
public class DateExpirable implements Expirable {
	
	private Date fromDate, untilDate;
	
	protected static final String CONST_STRING_SEPARATOR = ", ";
	
	/**
	 * Constructs an {@link Expirable} that never expires.
	 */
	public DateExpirable() {
		this(null, null);
	}

	public DateExpirable(Date fromDate, Date untilDate) {
		if (fromDate != null && untilDate != null) {
			if (CoreDateUtils.isAfter(untilDate, fromDate)) {
				throw new IllegalArgumentException("From Date can never be later than Until Date");
			}
		}
		
		this.fromDate = fromDate;
		this.untilDate = untilDate;
	}
	
	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getUntilDate() {
		return untilDate;
	}

	public void setUntilDate(Date untilDate) {
		this.untilDate = untilDate;
	}

	@Override
	public boolean isActive() {
		return isActive(new Date());
	}

	@Override
	public boolean isExpired() {
		return !isActive();
	}
	
	public boolean isActive(Date date) {
		final boolean afterFrom = (fromDate == null) ? false : 
			CoreDateUtils.isAfter(fromDate, date) || DateUtils.isSameDay(fromDate, date);
		final boolean beforeUntil = (untilDate == null) ? true : 
			CoreDateUtils.isBefore(untilDate, date) || DateUtils.isSameDay(fromDate, date);
		
		return afterFrom && beforeUntil;
	}
}
