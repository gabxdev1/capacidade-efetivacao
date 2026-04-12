package br.com.gabxdev.domain.model;

import br.com.gabxdev.domain.model.enums.Canal;
import br.com.gabxdev.domain.model.enums.StatusProcessamento;
import br.com.gabxdev.domain.model.enums.TipoMovimento;
import br.com.gabxdev.domain.model.enums.TipoOperacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SituacaoProcessamento(
        String idEfetivacao,
        StatusProcessamento status,
        LocalDateTime inicioEfetivacao,
        LocalDateTime finalEfetivacao,
        String idConta,
        TipoMovimento tipoMovimento,
        TipoOperacao tipoOperacao,
        BigDecimal valorDelta,
        Canal canal
) {
}
