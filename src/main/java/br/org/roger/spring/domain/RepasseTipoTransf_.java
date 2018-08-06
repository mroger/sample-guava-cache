package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(RepasseTipoTransf.class)
public abstract class RepasseTipoTransf_ {

	public static volatile SingularAttribute<RepasseTipoTransf, BigDecimal> valorMaximo;
	public static volatile SingularAttribute<RepasseTipoTransf, Integer> id;
	public static volatile SingularAttribute<RepasseTipoTransf, BigDecimal> valorMinimo;
	public static volatile SingularAttribute<RepasseTipoTransf, String> siglaTipoTransf;
	public static volatile SingularAttribute<RepasseTipoTransf, String> desc;

}

