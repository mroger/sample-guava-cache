package br.org.roger.spring.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chen on 25/11/2014.
 */
@SuppressWarnings("serial")
@Entity
@Table(name="REL_PORTAL_PHONE")
public class RelPortalPhone implements Serializable {

    @EmbeddedId
    @AttributeOverrides( {
            @AttributeOverride(name="portalId", column=@Column(name="EREG_PORTAL_ID", nullable=false, precision=4, scale=0) ),
            @AttributeOverride(name="phoneId", column=@Column(name="PHONE_ID", nullable=false, precision=9, scale=0) ),
            @AttributeOverride(name="portalContactId", column=@Column(name="PORTAL_CONTACT_ID", nullable=false, precision=3, scale=0) ) } )
    private RelPortalPhoneId id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PHONE_ID", nullable=false, insertable=false, updatable=false)
    private Phone phone;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EREG_PORTAL_ID", nullable=false, insertable=false, updatable=false)
    private Portal portal;

    @Column(name="PORTAL_CONTACT_ID",  nullable=false, insertable=false, updatable=false)
    private Integer portalContactId;

    public RelPortalPhoneId getId() {
        return id;
    }

    public void setId(RelPortalPhoneId id) {
        this.id = id;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Portal getPortal() {
        return portal;
    }

    public void setPortal(Portal portal) {
        this.portal = portal;
    }

    public Integer getPortalContactId() {
        return portalContactId;
    }

    public void setPortalContactId(Integer portalContactId) {
        this.portalContactId = portalContactId;
    }
}
