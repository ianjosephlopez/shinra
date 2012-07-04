package ph.com.shinra.datasource.common.model;

import java.io.Serializable;

public class BusinessCode extends DateExpirable implements Serializable {

	private static final long serialVersionUID = -2766041951015641149L;
	
	private Long id;
	private String code;
	private String codeType;
    private String language;
    private String description;
	
    public Long getId() {
		return id;
	}
	
    public void setId(Long id) {
		this.id = id;
	}
	
    public String getCode() {
		return code;
	}
	
    public void setCode(String code) {
		this.code = code;
	}
	
    public String getCodeType() {
		return codeType;
	}
	
    public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
    public String getLanguage() {
		return language;
	}
	
    public void setLanguage(String language) {
		this.language = language;
	}
	
    public String getDescription() {
		return description;
	}
	
    public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BusinessCode [getId()=" + getId() + ", getCode()=" + getCode()
				+ ", getCodeType()=" + getCodeType() + ", getLanguage()="
				+ getLanguage() + ", getDescription()=" + getDescription()
				+ ", getFromDate()=" + getFromDate() + ", getUntilDate()="
				+ getUntilDate() + "]\n";
	}
}
