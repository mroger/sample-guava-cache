package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "ENTITY_STATUS")
@NamedQueries({
	
})
public class EntityStatus  implements java.io.Serializable {

	public static final int ATIVO = 1;
	public static final int CADASTRO_COM_RESTRICOES = 2;	
	public static final int BLOQUEADO_AUTOMATICO = 3;
	public static final int NOVO = 4;
	public static final int AGUARDANDO_AVALIACAO = 5;
	public static final int BLOQUEADO_MANUAL = 6;
	public static final int BLOQUEADO_PENDENCIA_FINANCEIRA = 7;
	public static final int Cadastro_alterado =	8;
	public static final int TRANSITORIO_ENVIAR_HABILITE_SE = 999;
	
	public static final class Queries {
    }
    
    @Id     
    @Column(name="ENTITY_STATUS_ID", unique=true, nullable=false, precision=3, scale=0)
 	private Integer statusCode;
	
    @Column(name="ENTITY_STATUS_DESC", nullable=false, length=40)
 	private String statusName;
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getStatusCode() == null) ? 0 : getStatusCode().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		EntityStatus other = (EntityStatus) obj;
		if (getStatusCode() == null) {
			if (other.getStatusCode() != null)
				return false;
		} else if (!getStatusCode().equals(other.getStatusCode()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntityStatus [statusCode=" + statusCode + ", statusName=" + statusName + "]";
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
    
}
