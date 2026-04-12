package br.com.gabxdev.domain.port.in;


import br.com.gabxdev.domain.model.SituacaoProcessamento;
import br.com.gabxdev.domain.model.enums.StatusProcessamento;

public interface SituacaoProcessamentoInboundPort {
    SituacaoProcessamento findByIdOrThrowNotFound(String idEfetivacao);

    void atualizarStatusProcessamento(String idEfetivacao, StatusProcessamento status);
}
