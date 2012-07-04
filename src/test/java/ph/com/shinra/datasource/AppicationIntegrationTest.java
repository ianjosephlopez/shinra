package ph.com.shinra.datasource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations={"/hibernate-applicationContext.xml", "/datasource-applicationContext.xml"})
public class AppicationIntegrationTest extends AbstractJUnit4SpringContextTests {
	
	@Test
	public void validate() {
		//does nothing, but is useful to run to make sure the applicationContesxt is valid and runnable
	}
}
