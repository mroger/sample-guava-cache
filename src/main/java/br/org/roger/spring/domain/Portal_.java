package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Portal.class)
public abstract class Portal_ {

	public static volatile SingularAttribute<Portal, Character> blockedComprova;
	public static volatile SingularAttribute<Portal, Character> loginExclusive;
	public static volatile SingularAttribute<Portal, String> portalDefaultLocale;
	public static volatile SingularAttribute<Portal, Long> entityCessionariaId;
	public static volatile SetAttribute<Portal, RelPortalEmail> relPortalEmail;
	public static volatile SingularAttribute<Portal, String> portalDefaultCurrency;
	public static volatile SingularAttribute<Portal, Portal> parentPortal;
	public static volatile SingularAttribute<Portal, String> portalContractNameView;
	public static volatile SingularAttribute<Portal, Integer> countryId;
	public static volatile SetAttribute<Portal, RelPortalPhone> relPortalPhone;
	public static volatile SingularAttribute<Portal, String> callCenterFilter;
	public static volatile SingularAttribute<Portal, String> portalName;
	public static volatile SingularAttribute<Portal, String> eregPortalTitle;
	public static volatile SingularAttribute<Portal, Character> eregPortalRestrict;
	public static volatile SingularAttribute<Portal, Byte> closeTime;
	public static volatile SingularAttribute<Portal, Integer> id;
	public static volatile SingularAttribute<Portal, String> portalFilterList;
	public static volatile SingularAttribute<Portal, String> portalPathFiles;
	public static volatile SingularAttribute<Portal, String> portalOfficialUrl;
	public static volatile SingularAttribute<Portal, Character> portalSerasa;
	public static volatile SingularAttribute<Portal, Character> sendComprova;
	public static volatile SingularAttribute<Portal, Short> ecentryGroupId;
	public static volatile SingularAttribute<Portal, Character> eregPortalStatus;
	public static volatile SingularAttribute<Portal, String> eregPortalDescription;
	public static volatile SingularAttribute<Portal, Short> permissionTypeId;
	public static volatile SingularAttribute<Portal, String> timezoneId;
	public static volatile SingularAttribute<Portal, String> portalContexto;

}

