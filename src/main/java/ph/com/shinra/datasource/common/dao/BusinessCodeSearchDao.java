package ph.com.shinra.datasource.common.dao;

import java.util.List;

import ph.com.shinra.datasource.common.model.BusinessCode;

public interface BusinessCodeSearchDao {
	
	List<BusinessCode> searchCodeByCodeTypeAndLanguage(String codeType, String language);
}
