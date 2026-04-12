package br.com.gabxdev.application;

import br.com.gabxdev.domain.model.SituacaoProcessamento;
import br.com.gabxdev.domain.model.enums.StatusProcessamento;
import br.com.gabxdev.domain.port.in.SituacaoProcessamentoInboundPort;
import br.com.gabxdev.domain.port.out.SituacaoProcessamentoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SituacaoProcessamentoUseCase implements SituacaoProcessamentoInboundPort {
    private final SituacaoProcessamentoOutputPort situacaoProcessamentoOutputPort;

    @Override
    public SituacaoProcessamento findByIdOrThrowNotFound(String idEfetivacao) {
        return situacaoProcessamentoOutputPort.findByIdOrThrowNotFound(idEfetivacao);
    }

    @Override
    public void atualizarStatusProcessamento(String idEfetivacao, StatusProcessamento status) {
        var situacaoProcessamento = new SituacaoProcessamento(
                idEfetivacao,
                status,
                null,
                LocalDateTime.now(),
                null,
                null,
                null,
                null,
                null
        );

        situacaoProcessamentoOutputPort.update(situacaoProcessamento);
    }
}
