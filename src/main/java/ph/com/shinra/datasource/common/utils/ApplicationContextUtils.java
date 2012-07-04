package ph.com.shinra.datasource.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtils {
	
	private static ApplicationContext context;
	private static final String[] contextXml = new String[]{ "hibernate-applicationContext.xml", "datasource-applicationContext.xml" };
	
	public static ApplicationContext getContext() {
		if (context == null) context = new ClassPathXmlApplicationContext(contextXml);
		return context;
	}
	
	public static Object getBean(String beanName) throws BeansException {
		return getContext().getBean(beanName);
	}
	
	public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		return getContext().getBean(name, requiredType);
	}
	
	public static <T> T getBean(Class<T> requiredType) throws BeansException {
		return getContext().getBean(requiredType);
	}
}
