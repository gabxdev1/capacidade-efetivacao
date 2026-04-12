package br.com.gabxdev.domain.model;

import br.com.gabxdev.domain.model.enums.Canal;
import br.com.gabxdev.domain.model.enums.StatusContrato;
import br.com.gabxdev.domain.model.enums.TipoMovimento;
import br.com.gabxdev.domain.model.enums.TipoOperacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Contrato {

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


    public Contrato() {
    }

    public Contrato(String idConta, LocalDateTime dataHoraContratacao, StatusContrato status, LocalDateTime dataHoraCancelamento, String motivoCancelamento, TipoMovimento tipoMovimento, TipoOperacao tipoOperacao, Canal canalContracao, BigDecimal valorLimiteContratado, LocalDateTime dataHoraAtualizacao) {
        this.idConta = idConta;
        this.dataHoraContratacao = dataHoraContratacao;
        this.status = status;
        this.dataHoraCancelamento = dataHoraCancelamento;
        this.motivoCancelamento = motivoCancelamento;
        this.tipoMovimento = tipoMovimento;
        this.tipoOperacao = tipoOperacao;
        this.canalContracao = canalContracao;
        this.valorLimiteContratado = valorLimiteContratado;
        this.dataHoraAtualizacao = dataHoraAtualizacao;
    }

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

