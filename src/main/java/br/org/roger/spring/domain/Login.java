package br.org.roger.spring.domain;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "LOGIN")
public class Login implements java.io.Serializable {
	
	public static final class Queries {
		public static final String FIND_LOGIN_ADMINISTRATIVO = "FIND_LOGIN_ADMINISTRATIVO";
		public static final String FIND_LOGIN_BY_ENTITY_ID = "FIND_LOGIN_BY_ENTITY_ID";
	}

	@Id
	@Column(name = "LOGIN_NAME")
	@NotNull
	@Length(max=10)
	private String loginName;

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTITY_ID")
	private UserEntity entity;
	
	@Column(name = "ENTITY_ID", insertable=false, updatable= false)	
	private Long entityId;

	@Column(name = "LOGIN_PASSWORD", length=15)
	private String loginPassword;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Login other = (Login) obj;
		if (getLoginName() == null) {
			if (other.getLoginName() != null)
				return false;
		} else if (!getLoginName().equals(other.getLoginName()))
			return false;
		return true;
	}
	
	

	public UserEntity getEntity() {
        return this.entity;
    }

	public void setEntity(UserEntity entity) {
        this.entity = entity;
    }

	public String getLoginPassword() {
        return this.loginPassword;
    }

	public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

}
