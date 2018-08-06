package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(ProjetoLeilao.class)
public abstract class ProjetoLeilao_ {

	public static volatile SingularAttribute<ProjetoLeilao, UserEntity> seller;
	public static volatile SingularAttribute<ProjetoLeilao, Date> endDatePrev;
	public static volatile SingularAttribute<ProjetoLeilao, Integer> departamentId;
	public static volatile SingularAttribute<ProjetoLeilao, Boolean> integrated;
	public static volatile SingularAttribute<ProjetoLeilao, Date> createdAt;
	public static volatile SingularAttribute<ProjetoLeilao, Long> sellerId;
	public static volatile SingularAttribute<ProjetoLeilao, Integer> statusId;
	public static volatile SingularAttribute<ProjetoLeilao, Integer> portalId;
	public static volatile SingularAttribute<ProjetoLeilao, Long> businessGroupId;
	public static volatile SingularAttribute<ProjetoLeilao, Long> unitId;
	public static volatile SingularAttribute<ProjetoLeilao, Date> changedAt;
	public static volatile SingularAttribute<ProjetoLeilao, Long> id;
	public static volatile SingularAttribute<ProjetoLeilao, UnidadeNegocio> unidadeNegocio;
	public static volatile SingularAttribute<ProjetoLeilao, String> desc;
	public static volatile SingularAttribute<ProjetoLeilao, ProjetoLeilaoStatus> status;
	public static volatile SingularAttribute<ProjetoLeilao, Long> gestorId;

}

