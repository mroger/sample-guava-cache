package br.org.roger.spring.domain.dto;


import br.org.roger.spring.domain.Phone;

public class PortalInfosDTO {

	private Integer portalId;
	private String portalName;
	private String portalOfficialURL;
	private String portalAppContext;
	private String portalDescription;
	private String cacEmail;
	private Phone phoneFax;
	private Phone phoneFixo;
	private Integer countryId;
	
	public PortalInfosDTO(Integer portalId, String portalName,
                          String portalOfficialURL, String portalAppContext,
                          String portalDescription, String cacEmail,
                          Phone phoneFixo,
                          Phone phoneFax) {
		super();
		this.portalId = portalId;
		this.portalName = portalName;
		this.portalOfficialURL = portalOfficialURL;
		this.portalAppContext = portalAppContext;
		this.portalDescription = portalDescription;
		this.cacEmail = cacEmail;
		this.phoneFixo = phoneFixo;
		this.phoneFax = phoneFax;
	}

	public PortalInfosDTO(Integer portalId, String portalName,
                          String portalOfficialURL, String portalAppContext,
                          String portalDescription, String cacEmail,
                          Phone phoneFixo,
                          Phone phoneFax,
                          Integer countryId) {
		super();
		this.portalId = portalId;
		this.portalName = portalName;
		this.portalOfficialURL = portalOfficialURL;
		this.portalAppContext = portalAppContext;
		this.portalDescription = portalDescription;
		this.cacEmail = cacEmail;
		this.phoneFixo = phoneFixo;
		this.phoneFax = phoneFax;
		this.countryId = countryId;
	}
	

	public Integer getPortalId() {
		return portalId;
	}

	public void setPortalId(Integer portalId) {
		this.portalId = portalId;
	}

	public String getPortalName() {
		return portalName;
	}
	public void setPortalName(String portalName) {
		this.portalName = portalName;
	}
	public String getPortalOfficialURL() {
		return portalOfficialURL;
	}
	public void setPortalOfficialURL(String portalOfficialURL) {
		this.portalOfficialURL = portalOfficialURL;
	}
	public String getPortalAppContext() {
		return portalAppContext;
	}
	public void setPortalAppContext(String portalAppContext) {
		this.portalAppContext = portalAppContext;
	}
	public String getPortalDescription() {
		return portalDescription;
	}
	public void setPortalDescription(String portalDescription) {
		this.portalDescription = portalDescription;
	}
	public String getCacEmail() {
		return cacEmail;
	}
	public void setCacEmail(String cacEmail) {
		this.cacEmail = cacEmail;
	}

	public Phone getPhoneFax() {
		return phoneFax;
	}

	public void setPhoneFax(Phone phoneFax) {
		this.phoneFax = phoneFax;
	}

	public Phone getPhoneFixo() {
		return phoneFixo;
	}

	public void setPhoneFixo(Phone phoneFixo) {
		this.phoneFixo = phoneFixo;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "PortalInfosDTO [portalId=" + portalId + ", portalName="
				+ portalName + ", portalOfficialURL=" + portalOfficialURL
				+ ", portalAppContext=" + portalAppContext
				+ ", portalDescription=" + portalDescription + ", cacEmail="
				+ cacEmail + "]";
	}
	
	
	
}
