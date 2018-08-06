package br.org.roger.spring.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "FL_PROJETO_LEILAO_STATUS")
@NamedQueries({})
public class ProjetoLeilaoStatus implements java.io.Serializable {

	@Id
	@Column(name = "COD_STATUS_PROJETO",nullable = false, precision = 2)
	private Integer id;

	@Column(name = "DESCRICAO_STATUS_PROJETO", nullable = false, length = 20)
	private String desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}