package ph.com.shinra.datasource.common.utils;

import java.util.Calendar;
import java.util.Date;

public class CoreDateUtils {
	
	public static boolean isBefore(Date reference, Date dateUnderTest) {
		Calendar calUnderTest = Calendar.getInstance();
		Calendar calRef = Calendar.getInstance();
		
		calUnderTest.setTime(dateUnderTest);
		calRef.setTime(reference);
        
        if (calUnderTest == null || calRef == null) throw new IllegalArgumentException("The date must not be null");
        
        if (calUnderTest.get(Calendar.YEAR) != calRef.get(Calendar.YEAR)) {
        	if (calUnderTest.get(Calendar.YEAR) < calRef.get(Calendar.YEAR)) return true;
        } else {
        	if (calUnderTest.get(Calendar.DAY_OF_YEAR) < calRef.get(Calendar.DAY_OF_YEAR)) return true;
        }
        
        return false;
	}
	
	public static boolean isAfter(Date reference, Date dateUnderTest) {
		Calendar calUnderTest = Calendar.getInstance();
		Calendar calRef = Calendar.getInstance();
		
		calUnderTest.setTime(dateUnderTest);
		calRef.setTime(reference);
        
        if (calUnderTest == null || calRef == null) throw new IllegalArgumentException("The date must not be null");
        
        if (calUnderTest.get(Calendar.YEAR) != calRef.get(Calendar.YEAR)) {
        	if (calUnderTest.get(Calendar.YEAR) > calRef.get(Calendar.YEAR)) return true;
        } else {
        	if (calUnderTest.get(Calendar.DAY_OF_YEAR) > calRef.get(Calendar.DAY_OF_YEAR)) return true;
        }
        
        return false;
	}
}
