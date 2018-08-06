package br.org.roger.spring.dto;

public enum ModalidadeLeilaoEnum {

    LEILAO(1, "leilao"),
    LEILAO_JUDICIAL(2, "leilao.judicial"),
    VENDA_DIRETA(3, "venda.direta"),
    LEADS(4, "leads");

    private int id;
    private String descricao;

    private ModalidadeLeilaoEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ModalidadeLeilaoEnum get(int id){
        for( ModalidadeLeilaoEnum modalidade : ModalidadeLeilaoEnum.values() ){
            if(modalidade.getId() == id){
                return modalidade;
            }
        }
        return null;
    }
}
