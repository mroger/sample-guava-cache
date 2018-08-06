package br.org.roger.spring.dao;

import br.org.roger.spring.dto.MessageTemplateDTO;

public interface MessageTemplateDAO {
    MessageTemplateDTO findMessageTemplate(int portalId, int messageEventId, String locale);
}
