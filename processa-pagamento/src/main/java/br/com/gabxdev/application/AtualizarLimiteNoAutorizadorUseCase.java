package br.com.gabxdev.application;

import br.com.gabxdev.domain.model.SituacaoProcessamento;
import br.com.gabxdev.domain.model.enums.StatusProcessamento;
import br.com.gabxdev.domain.port.in.AtualizarLimiteNoAutorizadorInboundPort;
import br.com.gabxdev.domain.port.in.SituacaoProcessamentoInboundPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AtualizarLimiteNoAutorizadorUseCase implements AtualizarLimiteNoAutorizadorInboundPort {

    private final SituacaoProcessamentoInboundPort situacaoProcessamentoInboundPort;

    @Override
    public void atualizarLimiteNoAutorizadorInboundPort(String idEfetivacao) {
        log.info("Atualizando limite no autorizador para idEfetivacao: {}", idEfetivacao);

        try {
            SituacaoProcessamento byIdOrThrowNotFound = situacaoProcessamentoInboundPort.findByIdOrThrowNotFound(idEfetivacao);

            Thread.sleep(600);

            situacaoProcessamentoInboundPort.atualizarStatusProcessamento(idEfetivacao, StatusProcessamento.ATUALIZA_LIMITE_AUTORIZADOR_SUCESSO);

            log.info("Limite atualizado com sucesso no autorizador para idEfetivacao: {}", idEfetivacao);
        } catch (Exception ex) {
            log.error("Erro ao atualizar limite no autorizador para idEfetivacao: {}", idEfetivacao, ex);

            situacaoProcessamentoInboundPort.atualizarStatusProcessamento(idEfetivacao, StatusProcessamento.ATUALIZA_LIMITE_AUTORIZADOR_ERRO);
        }
    }
}
