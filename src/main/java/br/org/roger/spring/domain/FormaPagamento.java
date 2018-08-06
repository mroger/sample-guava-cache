package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by chen on 14/09/2015.
 */
@javax.persistence.Entity
@Table(name = "FL_FORMA_PAGAMENTO")
public class FormaPagamento {

    public static final Integer BOLETO               = 1;
    public static final Integer DEPOSITO             = 2;
    public static final Integer DEPOSITO_JUDICIAL    = 3;
    public static final Integer TED_JUDICIAL         = 4;
    public static final Integer DEPOSITO_JUDICIAL_SP = 5;
    public static final Integer INVOICE              = 6;
    public static final Integer BOLETO_CAIXA_TJMS    = 7;
    public static final Integer S4PAY                = 8;

    public enum FormaPagamentoEnum {
        BOLETO(1, "Boleto", "banking-billet"),
        DEPOSITO(2, "Depósito", "deposit"),
        DEPOSITO_JUDICIAL(3, "Depósito Judicial", "judicial-deposit"),
        TED_JUDICIAL(4, "Ted Judicial", "judicial-ted"),
        DEPOSITO_JUDICIAL_SP(5, "Depósito Judicial São Paulo", "judicial-deposit-sp"),
        INVOICE(6, "Invoice", "invoice"),
        BOLETO_CAIXA_TJMS(7, "Boleto Caixa TJMS", "caixa-tjms-billet"),
        S4PAY(8, "S4Pay", "s4pay");

        private int    id;
        private String descricao;
        private String key;

        FormaPagamentoEnum(int id, String descricao, String key) {
            this.id = id;
            this.descricao = descricao;
            this.key = key;
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

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public static String getDescById(int id) {
            if (id == 1) {
                return BOLETO.getDescricao();
            } else if (id == 2) {
                return DEPOSITO.getDescricao();
            } else if (id == 3) {
                return DEPOSITO_JUDICIAL.getDescricao();
            } else if (id == 4) {
                return TED_JUDICIAL.getDescricao();
            } else if (id == 5) {
                return DEPOSITO_JUDICIAL_SP.getDescricao();
            } else if (id == 6) {
                return INVOICE.getDescricao();
            } else if (id == 7) {
                return BOLETO_CAIXA_TJMS.getDescricao();
            } else if (id == 8) {
                return S4PAY.getDescricao();
            }
            return "";
        }

        public static String getKeyById(int id) {
            if (id == 1) {
                return BOLETO.getKey();
            } else if (id == 2) {
                return DEPOSITO.getKey();
            } else if (id == 3) {
                return DEPOSITO_JUDICIAL.getKey();
            } else if (id == 4) {
                return TED_JUDICIAL.getKey();
            } else if (id == 5) {
                return DEPOSITO_JUDICIAL_SP.getKey();
            } else if (id == 6) {
                return INVOICE.getKey();
            } else if (id == 7) {
                return BOLETO_CAIXA_TJMS.getKey();
            } else if (id == 8) {
                return S4PAY.getKey();
            }
            return "";
        }
    }

    @Id
    @Column(name = "COD_FORMA_PAGAMENTO", unique = true, nullable = false, precision = 2, scale = 0)
    private Integer id;

    @Column(name = "DESCRICAO_FORMA_PAGAMENTO", length = 30)
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
