package br.com.gabxdev.domain.port.out;

import br.com.gabxdev.domain.model.Contrato;

public interface ContratoOutputPort {
    Contrato findByIdOrThrowNotFound(String idConta);

    void save(Contrato contrato);

    void update(Contrato contrato);
}
