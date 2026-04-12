package br.com.gabxdev.application;


import br.com.gabxdev.domain.model.Contrato;
import br.com.gabxdev.domain.model.enums.StatusContrato;
import br.com.gabxdev.domain.model.enums.StatusProcessamento;
import br.com.gabxdev.domain.port.in.ContratacaoInboundPort;
import br.com.gabxdev.domain.port.in.SituacaoProcessamentoInboundPort;
import br.com.gabxdev.domain.port.out.ContratoOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class ContratacaoUseCase implements ContratacaoInboundPort {

    private final SituacaoProcessamentoInboundPort situacaoProcessamentoInboundPort;

    private final ContratoOutputPort contratoOutputPort;

    @Override
    public void efetivarContrato(String idEfetivacao) {
        log.info("Iniciando efetivação do contrato com idEfetivacao={}", idEfetivacao);

        try {
            var situacaoProcessamento = situacaoProcessamentoInboundPort.findByIdOrThrowNotFound(idEfetivacao);

            var now = LocalDateTime.now();

            var contrato = new Contrato(
                    situacaoProcessamento.idConta(),
                    now,
                    StatusContrato.A,
                    null,
                    "",
                    situacaoProcessamento.tipoMovimento(),
                    situacaoProcessamento.tipoOperacao(),
                    situacaoProcessamento.canal(),
                    situacaoProcessamento.valorDelta(),
                    now
            );

            contratoOutputPort.save(contrato);
            situacaoProcessamentoInboundPort.atualizarStatusProcessamento(idEfetivacao, StatusProcessamento.ATUALIZA_CONTRATO_SUCESSO);

            log.info("Contrato com idEfetivacao={} efetivado com sucesso", idEfetivacao);
        } catch (Exception e) {
            situacaoProcessamentoInboundPort.atualizarStatusProcessamento(idEfetivacao, StatusProcessamento.ATUALIZA_CONTRATO_ERRO);

            log.error("Erro ao efetivar contrato com idEfetivacao={}", idEfetivacao, e);
        }
    }
}
