package br.org.roger.spring.dto;

import lombok.Data;

@Data
public class MessageTemplateDTO {
    private String messageBody;
    private String messageSubject;
    private Object messageFromAddress;
    private Object messageFromName;
    private boolean comprovaSufixo;
    private boolean ativo;
    private String localeId;
    private String messageToAddress;
    private String messageToName;
    private int portalId;
}
