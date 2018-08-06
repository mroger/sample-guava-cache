package br.org.roger.spring.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("serial")
@Entity
@Table(name = "PORTAL")
@NamedQueries({
        @NamedQuery(name = Portal.Queries.FIND_PORTAL_INFOS,
                query =
                        " SELECT " +
                                "	new net.s4bdigital.api.auctionfinancial.server.domain.dto.PortalInfosDTO( p.id, p.portalName, " +
                                "  p.portalOfficialUrl, p.portalContexto, p.eregPortalDescription, emailCac.email, phoneFixo, phoneFax, p.countryId) " +
                                " FROM Portal p " +
                                "	left join p.relPortalEmail rpe " +
                                "   left join rpe.email emailCac " +
                                "   left join p.relPortalPhone rpp1 " +
                                "   left join p.relPortalPhone rpp2 " +
                                "   left join rpp1.phone phoneFixo " +
                                "   left join rpp2.phone phoneFax " +
                                " WHERE p.id = :portalId " +
                                " AND rpe.portalContactId = 1 " +
                                " AND rpp1.id.portalContactId = 5 " +
                                " AND rpp2.id.portalContactId = 5 " +
                                " AND phoneFixo.type = 6 " +
                                " AND phoneFax.type = 4 "
        ),
        @NamedQuery(name = Portal.Queries.FIND_PORTAL_DEFAULT_LOCALE,
                query =
                        " SELECT " +
                                "  p.portalDefaultLocale " +
                                " FROM " +
                                "  Portal p " +
                                " WHERE " +
                                "  p.id = :portalId "
        )

})
public class Portal implements java.io.Serializable {

    // SUPERBID NET
    public static final int S4BDIGITAL = 5;
    public static final int SUPERBID = 2;

    public static final class Queries {
        public static final String FIND_PORTAL_INFOS = "FIND_PORTAL_INFOS";
        public static final String FIND_PORTAL_DEFAULT_LOCALE = "FIND_PORTAL_DEFAULT_LOCALE";

    }

    @Id
    @Column(name = "EREG_PORTAL_ID", unique = true, nullable = false, precision = 4, scale = 0)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EREG_PORTAL_PARENT_ID", nullable = false)
    private Portal parentPortal;

    @Column(name = "PORTAL_COUNTRY")
    private Integer countryId;

    @Column(name = "EREG_PORTAL_DESCRIPTION", length = 40)
    private String eregPortalDescription;

    @Column(name = "EREG_PORTAL_TITLE", length = 50)
    private String eregPortalTitle;

    @Column(name = "EREG_PORTAL_STATUS", length = 1)
    private Character eregPortalStatus;

    @Column(name = "PERMISSION_TYPE_ID", precision = 3, scale = 0)
    private Short permissionTypeId;

    @Column(name = "EREG_PORTAL_RESTRICT", length = 1)
    private Character eregPortalRestrict;

    @Column(name = "PORTAL_PATH_FILES", length = 100)
    private String portalPathFiles;

    @Column(name = "SEND_COMPROVA", length = 1)
    private Character sendComprova;

    @Column(name = "CLOSE_TIME", precision = 2, scale = 0)
    private Byte closeTime;

    @Column(name = "PORTAL_NAME", length = 40)
    private String portalName;

    @Column(name = "PORTAL_OFFICIAL_URL", length = 200)
    private String portalOfficialUrl;

    @Column(name = "ENTITY_CESSIONARIA_ID")
    private Long entityCessionariaId;

    @Column(name = "PORTAL_CONTRACT_NAME_VIEW", length = 200)
    private String portalContractNameView;

    @Column(name = "BLOCKED_COMPROVA", length = 1)
    private Character blockedComprova;

    @Column(name = "PORTAL_DEFAULT_LOCALE", length = 5)
    private String portalDefaultLocale;

    @Column(name = "PORTAL_DEFAULT_CURRENCY", length = 3)
    private String portalDefaultCurrency;

    @Column(name = "PORTAL_SERASA", length = 1)
    private Character portalSerasa;

    @Column(name = "LOGIN_EXCLUSIVE", length = 1)
    private Character loginExclusive;

    @Column(name = "TIMEZONE_ID", length = 80)
    private String timezoneId;

    @Column(name = "PORTAL_FILTER_LIST", length = 40)
    private String portalFilterList;

    @Column(name = "ECENTRY_GROUP_ID", precision = 4, scale = 0)
    private Short ecentryGroupId;

    @Column(name = "PORTAL_CONTEXTO", length = 10)
    private String portalContexto;

    @Column(name = "CALL_CENTER_FILTER", length = 40)
    private String callCenterFilter;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "portal")
    private Set<RelPortalEmail> relPortalEmail = new HashSet<RelPortalEmail>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "portal")
    private Set<RelPortalPhone> relPortalPhone = new HashSet<RelPortalPhone>(0);

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Portal other = (Portal) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Portal getParentPortal() {
        return parentPortal;
    }

    public void setParentPortal(Portal parentPortal) {
        this.parentPortal = parentPortal;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getEregPortalDescription() {
        return eregPortalDescription;
    }

    public void setEregPortalDescription(String eregPortalDescription) {
        this.eregPortalDescription = eregPortalDescription;
    }

    public String getEregPortalTitle() {
        return eregPortalTitle;
    }

    public void setEregPortalTitle(String eregPortalTitle) {
        this.eregPortalTitle = eregPortalTitle;
    }

    public Character getEregPortalStatus() {
        return eregPortalStatus;
    }

    public void setEregPortalStatus(Character eregPortalStatus) {
        this.eregPortalStatus = eregPortalStatus;
    }

    public Short getPermissionTypeId() {
        return permissionTypeId;
    }

    public void setPermissionTypeId(Short permissionTypeId) {
        this.permissionTypeId = permissionTypeId;
    }

    public Character getEregPortalRestrict() {
        return eregPortalRestrict;
    }

    public void setEregPortalRestrict(Character eregPortalRestrict) {
        this.eregPortalRestrict = eregPortalRestrict;
    }

    public String getPortalPathFiles() {
        return portalPathFiles;
    }

    public void setPortalPathFiles(String portalPathFiles) {
        this.portalPathFiles = portalPathFiles;
    }

    public Character getSendComprova() {
        return sendComprova;
    }

    public void setSendComprova(Character sendComprova) {
        this.sendComprova = sendComprova;
    }

    public Byte getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Byte closeTime) {
        this.closeTime = closeTime;
    }

    public String getPortalName() {
        return portalName;
    }

    public void setPortalName(String portalName) {
        this.portalName = portalName;
    }

    public String getPortalOfficialUrl() {
        return portalOfficialUrl;
    }

    public void setPortalOfficialUrl(String portalOfficialUrl) {
        this.portalOfficialUrl = portalOfficialUrl;
    }

    public Long getEntityCessionariaId() {
        return entityCessionariaId;
    }

    public void setEntityCessionariaId(Long entityCessionariaId) {
        this.entityCessionariaId = entityCessionariaId;
    }

    public String getPortalContractNameView() {
        return portalContractNameView;
    }

    public void setPortalContractNameView(String portalContractNameView) {
        this.portalContractNameView = portalContractNameView;
    }

    public Character getBlockedComprova() {
        return blockedComprova;
    }

    public void setBlockedComprova(Character blockedComprova) {
        this.blockedComprova = blockedComprova;
    }

    public String getPortalDefaultLocale() {
        return portalDefaultLocale;
    }

    public void setPortalDefaultLocale(String portalDefaultLocale) {
        this.portalDefaultLocale = portalDefaultLocale;
    }

    public Character getPortalSerasa() {
        return portalSerasa;
    }

    public void setPortalSerasa(Character portalSerasa) {
        this.portalSerasa = portalSerasa;
    }

    public Character getLoginExclusive() {
        return loginExclusive;
    }

    public void setLoginExclusive(Character loginExclusive) {
        this.loginExclusive = loginExclusive;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public String getPortalFilterList() {
        return portalFilterList;
    }

    public void setPortalFilterList(String portalFilterList) {
        this.portalFilterList = portalFilterList;
    }

    public Short getEcentryGroupId() {
        return ecentryGroupId;
    }

    public void setEcentryGroupId(Short ecentryGroupId) {
        this.ecentryGroupId = ecentryGroupId;
    }

    public String getPortalContexto() {
        return portalContexto;
    }

    public void setPortalContexto(String portalContexto) {
        this.portalContexto = portalContexto;
    }

    public String getCallCenterFilter() {
        return callCenterFilter;
    }

    public void setCallCenterFilter(String callCenterFilter) {
        this.callCenterFilter = callCenterFilter;
    }

    public String getPortalDefaultCurrency() {
        return portalDefaultCurrency;
    }

    public void setPortalDefaultCurrency(String portalDefaultCurrency) {
        this.portalDefaultCurrency = portalDefaultCurrency;
    }

    public Set<RelPortalEmail> getRelPortalEmail() {
        return relPortalEmail;
    }

    public void setRelPortalEmail(Set<RelPortalEmail> relPortalEmail) {
        this.relPortalEmail = relPortalEmail;
    }

    public Set<RelPortalPhone> getRelPortalPhone() {
        return relPortalPhone;
    }

    public void setRelPortalPhone(Set<RelPortalPhone> relPortalPhone) {
        this.relPortalPhone = relPortalPhone;
    }
}
