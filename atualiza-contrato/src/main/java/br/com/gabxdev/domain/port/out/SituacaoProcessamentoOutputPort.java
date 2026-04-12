package br.com.gabxdev.domain.port.out;

import br.com.gabxdev.domain.model.SituacaoProcessamento;

public interface SituacaoProcessamentoOutputPort {
    SituacaoProcessamento findByIdOrThrowNotFound(String idEfetivacao);

    void save(SituacaoProcessamento situacaoProcessamento);

    void update(SituacaoProcessamento situacaoProcessamento);
}
