package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(AberturaComitente.class)
public abstract class AberturaComitente_ {

	public static volatile SingularAttribute<AberturaComitente, Long> auctionId;
	public static volatile SingularAttribute<AberturaComitente, String> raizDocumento;
	public static volatile SingularAttribute<AberturaComitente, Integer> statusId;
	public static volatile SingularAttribute<AberturaComitente, String> nomeAberturaComitente;
	public static volatile SingularAttribute<AberturaComitente, Long> comitenteId;
	public static volatile SingularAttribute<AberturaComitente, UserEntity> comitente;
	public static volatile SingularAttribute<AberturaComitente, Long> id;
	public static volatile SingularAttribute<AberturaComitente, Date> dataCriacao;
	public static volatile SingularAttribute<AberturaComitente, Auction> auction;
	public static volatile SingularAttribute<AberturaComitente, Date> dataGeracao;

}

