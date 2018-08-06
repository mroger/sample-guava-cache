package br.org.roger.spring.dto;

public enum TipoItemPagamentoEnum {
	
	VALOR_LOTE(1L,"financeiro.itemspagamento.lote"),
	VALOR_COMISSAO_LEILOEIRO(2L,"financeiro.itemspagamento.comissao.leiloeiro"),
	VALOR_COMISSAO_CESSIONARIA(3L,"financeiro.itemspagamento.comissao.buyerspremium"),
	COMISSAO_COMITENTE(4L,"financeiro.itemspagamento.comissao.comitente"),
	VALOR_TAXA_ADMINISTRATIVA(5L,"financeiro.itemspagamento.taxa.administratia"),
	MULTA(6L,"financeiro.itemspagamento.comissao.multa"),
	EDITAL_COMITENTE(7L,"financeiro.itemspagamento.taxa.comitente"),
    VALOR_FIXO_1(8L,"financeiro.itemspagamento.valor.fixo.1"),
    VALOR_FIXO_2(9L,"financeiro.itemspagamento.valor.fixo.2"),
    PORCENTAGEM_1(10L,"financeiro.itemspagamento.porcentagem.1"),
    PORCENTAGEM_2(11L,"financeiro.itemspagamento.porcentagem.2"),
    FAIXA_VALOR_1(12L,"financeiro.itemspagamento.faixa.valor.1"),
    FAIXA_VALOR_2(13L,"financeiro.itemspagamento.faixa.valor.2"),
	SERVICO_TRANSFERENCIA(14L,"financeiro.itemspagamento.servico_transferencia"),
	SOLICITACAO_DE_TRANSFERENCIA(16L,"financeiro.itemspagamento.solicitacao_de_transferencia"),
	IMPOSTO_TESORERIA(17L,"financeiro.itemspagamento.imposto_tesoreria"),
	CONDICIONADOS(18L,"financeiro.itemspagamento.condicionados");

    private Long id;
	private String descricao;
	
	private TipoItemPagamentoEnum(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static String getDescricaoPorTipoId(int id){
		for( TipoItemPagamentoEnum tipo : TipoItemPagamentoEnum.values() ){
			if(tipo.getId() == id){
				return tipo.getDescricao();
			}
		}
		
		return "";
	}

	public static TipoItemPagamentoEnum get(Long id){
		for( TipoItemPagamentoEnum tipo : TipoItemPagamentoEnum.values() ){
			if(tipo.getId() == id){
				return tipo;
			}
		}
		return null;
	}
	
	
	
}
