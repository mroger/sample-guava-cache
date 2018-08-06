package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(GLancIntegracao.class)
public abstract class GLancIntegracao_ {

	public static volatile SingularAttribute<GLancIntegracao, Long> grupoLancamentoId;
	public static volatile SingularAttribute<GLancIntegracao, Long> integracaoTipoId;
	public static volatile SingularAttribute<GLancIntegracao, Long> statusId;
	public static volatile SingularAttribute<GLancIntegracao, GrupoLancamento> grupoLancamento;
	public static volatile SingularAttribute<GLancIntegracao, IntegracaoStatus> integrationStatus;
	public static volatile SingularAttribute<GLancIntegracao, Long> id;
	public static volatile SingularAttribute<GLancIntegracao, IntegracaoTipo> integracaoTipo;

}

