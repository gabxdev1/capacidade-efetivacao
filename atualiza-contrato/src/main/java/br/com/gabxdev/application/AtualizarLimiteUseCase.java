package br.com.gabxdev.application;

import br.com.gabxdev.domain.model.enums.StatusProcessamento;
import br.com.gabxdev.domain.port.in.AtualizarLimiteInboundPort;
import br.com.gabxdev.domain.port.in.SituacaoProcessamentoInboundPort;
import br.com.gabxdev.domain.port.out.ContratoOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class AtualizarLimiteUseCase implements AtualizarLimiteInboundPort {

    private final SituacaoProcessamentoInboundPort situacaoProcessamentoInboundPort;

    private final ContratoOutputPort contratoOutputPort;

    @Override
    public void atualizarLimite(String idEfetivacao) {
        log.info("Iniciando atualização de limite do contrato com idEfetivacao={}", idEfetivacao);

        try {
            var situacaoProcessamento = situacaoProcessamentoInboundPort.findByIdOrThrowNotFound(idEfetivacao);
            var contrato = contratoOutputPort.findByIdOrThrowNotFound(situacaoProcessamento.idConta());

            contrato.setTipoMovimento(situacaoProcessamento.tipoMovimento());
            contrato.setTipoOperacao(situacaoProcessamento.tipoOperacao());
            contrato.setValorLimiteContratado(situacaoProcessamento.valorDelta());
            contrato.setDataHoraAtualizacao(LocalDateTime.now());

            contratoOutputPort.save(contrato);
            situacaoProcessamentoInboundPort.atualizarStatusProcessamento(idEfetivacao, StatusProcessamento.ATUALIZA_CONTRATO_SUCESSO);

        } catch (Exception e) {
            situacaoProcessamentoInboundPort.atualizarStatusProcessamento(idEfetivacao, StatusProcessamento.ATUALIZA_CONTRATO_ERRO);

            log.error("Erro ao atualizar limite contrato com idEfetivacao={}", idEfetivacao, e);
        }
    }
}
