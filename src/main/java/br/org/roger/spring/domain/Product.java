package br.org.roger.spring.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;


@Data
@Entity
@EqualsAndHashCode
@Table(name = "PRODUCT")
public class Product implements java.io.Serializable {

    @Id()
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "EREG_PRODUCT_ID", unique = true, precision = 9, scale = 0)
    private Long id;

    @Column(name = "EREG_PRODUCT_STATUS_CODE", nullable = false, precision = 3, scale = 0)
    private Integer productStatusCode;

    @Column(name = "EREG_CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "EREG_PRODUCT_SHORT_DESC", nullable = false, length = 350)
    private String productShortDesc;

    @Column(name = "EREG_PRODUCT_DETAILED_DESC", length = 4000)
    private String productDetailedDesc;

    @Column(name = "EREG_PRODUCT_YOUR_REF", length = 200)
    private String productYourRef;

    @Column(name = "EREG_PRODUCT_PHOTO_URL")
    private String productPhotoUrl;

    @Column(name = "EREG_PRODUCT_INSPEC_ATTACH_URL")
    private String productInspecAttachUrl;

    @Column(name = "EREG_PRODUCT_DESC_ATTACH_URL", length = 350)
    private String productDescAttachUrl;

    @Column(name = "EREG_PRODUCT_TOUR_ATTACH_URL")
    private String productTourAttachUrl;

    @Column(name = "EREG_PRODUCT_PHOTO_URL2")
    private String productPhotoUrl2;

    @Column(name = "EREG_PRODUCT_PHOTO_URL3")
    private String productPhotoUrl3;

    @Column(name = "EREG_PRODUCT_PHOTO_URL4")
    private String productPhotoUrl4;

    @Column(name = "EREG_PRODUCT_PHOTO_URL5")
    private String productPhotoUrl5;

    @Column(name = "PHOTO_FIRST_PAGE")
    private String photoFirstPage;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "product")
    private ProductFinancial productFinancial;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COMMERCIAL_PROJECT_ID", nullable=false, insertable=false, updatable=false)
    private CommercialProject commercialProject;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    @Column(name = "EREG_PRODUCT_DATE_REGISTRATION", length = 7)
    private Date productDateRegistation;

    @Column(name = "IN_CONDITIONS", length = 1)
    @Type(type = "true_false")
    private Boolean inConditions;

    @Column(name = "PHOTO_ILLUSTRATIVE", length = 1)
    @Type(type = "true_false")
    private Boolean photoIllustrative;

    @Column(name = "LOCAL_REFERENCE", length = 200)
    private String localReference;

    @Column(name = "CATEGORY_ID_OLD", precision = 4, scale = 0)
    private Short categoryIdOld;

    @Column(name = "VIDEO_URL")
    private String videoUrl;

    @Column(name = "DETAILED_DESC_EXT")
    @Lob
    private String detailedDescExt;

    @Column(name = "DETAILED_DESC_COMPL")
    @Lob
    private String detailedDescCompl;

    @Column(name = "MODELO_ID")
    private Integer modelId;

    @Column(name = "EREG_BUSINESS_ID", nullable = false)
    private Long entitySellerId;

    @Column(name = "LOC_NU")
    private Integer cityId;

    @Column(name = "EREF_STATE_CODE")
    private String stateId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private Set<Offer> offers = new HashSet<Offer>(0);

    @Transient
    public Offer getOffer() {
        if (!offers.isEmpty()) {
            return offers.iterator().next();
        }
        return null;
    }

    @Transient
    public String getDetailedDesc() {
        StringBuffer desc = new StringBuffer();
        desc.append("");
        if (getProductDetailedDesc() != null) {
            desc.append(getProductDetailedDesc());
        }
        if (getDetailedDescExt() != null) {
            desc.append(getDetailedDescExt());
        }
        return desc.toString();
    }

    @Transient
    public List<String> getFotos() {
        List<String> fotos = new ArrayList<String>();
        appendFoto(fotos, getProductPhotoUrl());
        appendFoto(fotos, getProductPhotoUrl2());
        appendFoto(fotos, getProductPhotoUrl3());
        appendFoto(fotos, getProductPhotoUrl4());
        appendFoto(fotos, getProductPhotoUrl5());
        return fotos;
    }

    private void appendFoto(List<String> fotos, String foto) {
        if (foto != null && !foto.equals("null")) {
            fotos.add(foto);
        }
    }
}
