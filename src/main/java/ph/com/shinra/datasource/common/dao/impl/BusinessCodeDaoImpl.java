package ph.com.shinra.datasource.common.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import ph.com.shinra.datasource.common.dao.BusinessCodeSearchDao;
import ph.com.shinra.datasource.common.model.BusinessCode;

public class BusinessCodeDaoImpl extends GenericDaoImpl<BusinessCode, Long> implements
		BusinessCodeSearchDao {

	public BusinessCodeDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory, BusinessCode.class);
	}

	@Override
	public List<BusinessCode> searchCodeByCodeTypeAndLanguage(String codeType, String language) {
		Map<String, Object> queryParam	= new HashMap<String, Object>();
		queryParam.put("codeType", codeType);
		queryParam.put("language", language);
		
		return retrieveList("codeByCodeTypeAndLanguage", queryParam, null);
	}

}
