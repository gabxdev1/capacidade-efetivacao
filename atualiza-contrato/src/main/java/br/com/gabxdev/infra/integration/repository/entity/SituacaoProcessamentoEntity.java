package br.com.gabxdev.infra.integration.repository.entity;

import br.com.gabxdev.domain.model.enums.Canal;
import br.com.gabxdev.domain.model.enums.StatusProcessamento;
import br.com.gabxdev.domain.model.enums.TipoMovimento;
import br.com.gabxdev.domain.model.enums.TipoOperacao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class SituacaoProcessamentoEntity {

    private String idEfetivacao;
    private StatusProcessamento status;
    private LocalDateTime inicioEfetivacao;
    private LocalDateTime finalEfetivacao;
    private String idConta;
    TipoMovimento tipoMovimento;
    TipoOperacao tipoOperacao;
    private BigDecimal valorDelta;
    private Canal canal;


    @DynamoDbPartitionKey
    @DynamoDbAttribute("idEfetivacao")
    public String getIdEfetivacao() {
        return idEfetivacao;
    }

    public void setIdEfetivacao(String idEfetivacao) {
        this.idEfetivacao = idEfetivacao;
    }

    public StatusProcessamento getStatus() {
        return status;
    }

    public void setStatus(StatusProcessamento status) {
        this.status = status;
    }

    public LocalDateTime getInicioEfetivacao() {
        return inicioEfetivacao;
    }

    public void setInicioEfetivacao(LocalDateTime inicioEfetivacao) {
        this.inicioEfetivacao = inicioEfetivacao;
    }

    public LocalDateTime getFinalEfetivacao() {
        return finalEfetivacao;
    }

    public void setFinalEfetivacao(LocalDateTime finalEfetivacao) {
        this.finalEfetivacao = finalEfetivacao;
    }

    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }

    public TipoMovimento getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TipoMovimento tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public BigDecimal getValorDelta() {
        return valorDelta;
    }

    public void setValorDelta(BigDecimal valorDelta) {
        this.valorDelta = valorDelta;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }
}
