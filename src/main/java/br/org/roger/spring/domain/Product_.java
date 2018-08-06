package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, Long> entitySellerId;
	public static volatile SingularAttribute<Product, Integer> modelId;
	public static volatile SingularAttribute<Product, Boolean> photoIllustrative;
	public static volatile SingularAttribute<Product, Boolean> inConditions;
	public static volatile SingularAttribute<Product, Integer> cityId;
	public static volatile SingularAttribute<Product, ProductFinancial> productFinancial;
	public static volatile SingularAttribute<Product, String> productDescAttachUrl;
	public static volatile SingularAttribute<Product, String> videoUrl;
	public static volatile SingularAttribute<Product, String> productDetailedDesc;
	public static volatile SingularAttribute<Product, String> productYourRef;
	public static volatile SingularAttribute<Product, Integer> productStatusCode;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, Short> categoryIdOld;
	public static volatile SetAttribute<Product, Offer> offers;
	public static volatile SingularAttribute<Product, Date> productDateRegistation;
	public static volatile SingularAttribute<Product, String> localReference;
	public static volatile SingularAttribute<Product, String> productPhotoUrl5;
	public static volatile SingularAttribute<Product, String> detailedDescExt;
	public static volatile SingularAttribute<Product, String> productPhotoUrl;
	public static volatile SingularAttribute<Product, String> productPhotoUrl4;
	public static volatile SingularAttribute<Product, String> detailedDescCompl;
	public static volatile SingularAttribute<Product, String> stateId;
	public static volatile SingularAttribute<Product, String> productPhotoUrl3;
	public static volatile SingularAttribute<Product, String> productPhotoUrl2;
	public static volatile SingularAttribute<Product, String> photoFirstPage;
	public static volatile SingularAttribute<Product, String> productShortDesc;
	public static volatile SingularAttribute<Product, CommercialProject> commercialProject;
	public static volatile SingularAttribute<Product, String> productTourAttachUrl;
	public static volatile SingularAttribute<Product, String> productInspecAttachUrl;
	public static volatile SingularAttribute<Product, Integer> categoryId;

}

