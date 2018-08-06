package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by chen on 25/11/2014.
 */
@SuppressWarnings("serial")
@Embeddable
public class RelPortalPhoneId implements Serializable {

    @Column(name="EREG_PORTAL_ID", nullable=false, precision=4, scale=0)
    private int portalId;


    @Column(name="PHONE_ID", nullable=false, precision=9, scale=0)
    private int phoneId;


    @Column(name="PORTAL_CONTACT_ID", nullable=false, precision=3, scale=0)
    private short portalContactId;

    public int getPortalId() {
        return portalId;
    }

    public void setPortalId(int portalId) {
        this.portalId = portalId;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public short getPortalContactId() {
        return portalContactId;
    }

    public void setPortalContactId(short portalContactId) {
        this.portalContactId = portalContactId;
    }
}
