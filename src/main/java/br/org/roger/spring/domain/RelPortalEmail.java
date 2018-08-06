package br.org.roger.spring.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="REL_PORTAL_EMAIL")
@NamedQueries({
}) 
public class RelPortalEmail  implements java.io.Serializable {

	public static final class Queries {
    }
    
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="portalId", column=@Column(name="EREG_PORTAL_ID", nullable=false, precision=4, scale=0) ),
        @AttributeOverride(name="emailId", column=@Column(name="EMAIL_ID", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="portalContactId", column=@Column(name="PORTAL_CONTACT_ID", nullable=false, precision=3, scale=0) ) } )
 	private RelPortalEmailId id; 	
	public RelPortalEmailId getId() {
		return this.id;
    }
    
    public void setId(RelPortalEmailId id) {
        this.id = id;
    }
 
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EMAIL_ID", nullable=false, insertable=false, updatable=false)
 	private Email email;
 
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EREG_PORTAL_ID", nullable=false, insertable=false, updatable=false)
 	private Portal portal;
    
    @Column(name="PORTAL_CONTACT_ID",  nullable=false, insertable=false, updatable=false)
    private Integer portalContactId;
    
	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
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


