package br.com.gabxdev.infra.integration.repository.entity;

import br.com.gabxdev.domain.model.enums.Canal;
import br.com.gabxdev.domain.model.enums.StatusContrato;
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
public class ContratoEntity {

    private String idConta;
    private LocalDateTime dataHoraContratacao;
    private StatusContrato status;
    private LocalDateTime dataHoraCancelamento;
    private String motivoCancelamento;
    private TipoMovimento tipoMovimento;
    private TipoOperacao tipoOperacao;
    private Canal canalContracao;
    private BigDecimal valorLimiteContratado;
    private LocalDateTime dataHoraAtualizacao;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("idConta")
    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }

    public LocalDateTime getDataHoraContratacao() {
        return dataHoraContratacao;
    }

    public void setDataHoraContratacao(LocalDateTime dataHoraContratacao) {
        this.dataHoraContratacao = dataHoraContratacao;
    }

    public StatusContrato getStatus() {
        return status;
    }

    public void setStatus(StatusContrato status) {
        this.status = status;
    }

    public LocalDateTime getDataHoraCancelamento() {
        return dataHoraCancelamento;
    }

    public void setDataHoraCancelamento(LocalDateTime dataHoraCancelamento) {
        this.dataHoraCancelamento = dataHoraCancelamento;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
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

    public Canal getCanalContracao() {
        return canalContracao;
    }

    public void setCanalContracao(Canal canalContracao) {
        this.canalContracao = canalContracao;
    }

    public BigDecimal getValorLimiteContratado() {
        return valorLimiteContratado;
    }

    public void setValorLimiteContratado(BigDecimal valorLimiteContratado) {
        this.valorLimiteContratado = valorLimiteContratado;
    }

    public LocalDateTime getDataHoraAtualizacao() {
        return dataHoraAtualizacao;
    }

    public void setDataHoraAtualizacao(LocalDateTime dataHoraAtualizacao) {
        this.dataHoraAtualizacao = dataHoraAtualizacao;
    }
}
