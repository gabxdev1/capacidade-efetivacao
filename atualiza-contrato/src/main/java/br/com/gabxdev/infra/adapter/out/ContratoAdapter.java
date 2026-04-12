package br.com.gabxdev.infra.adapter.out;

import br.com.gabxdev.domain.exceptions.NotFoundException;
import br.com.gabxdev.domain.model.Contrato;
import br.com.gabxdev.domain.port.out.ContratoOutputPort;
import br.com.gabxdev.infra.adapter.out.mapper.ContratoMapper;
import br.com.gabxdev.infra.integration.repository.ContratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContratoAdapter implements ContratoOutputPort {

    private final ContratoRepository repository;

    private final ContratoMapper mapper;

    @Override
    public void save(Contrato contrato) {
        var entity = mapper.toEntity(contrato);

        repository.save(entity);
    }

    @Override
    public void update(Contrato contrato) {
        var entity = mapper.toEntity(contrato);

        repository.update(entity);
    }

    @Override
    public Contrato findByIdOrThrowNotFound(String idConta) {
        var entity = repository.findById(idConta)
                .orElseThrow(() -> new NotFoundException("Contrato não encontrado"));

        return mapper.toDomain(entity);
    }
}
