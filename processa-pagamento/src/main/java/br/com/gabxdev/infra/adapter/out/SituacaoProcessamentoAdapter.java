package br.com.gabxdev.infra.adapter.out;

import br.com.gabxdev.domain.exceptions.NotFoundException;
import br.com.gabxdev.domain.model.SituacaoProcessamento;
import br.com.gabxdev.domain.port.out.SituacaoProcessamentoOutputPort;
import br.com.gabxdev.infra.adapter.out.mapper.SituacaoProcessamentoMapper;
import br.com.gabxdev.infra.integration.repository.SituacaoProcessamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SituacaoProcessamentoAdapter implements SituacaoProcessamentoOutputPort {

    private final SituacaoProcessamentoRepository repository;

    private final SituacaoProcessamentoMapper mapper;

    @Override
    public SituacaoProcessamento findByIdOrThrowNotFound(String idEfetivacao) {
        var entity = repository.findById(idEfetivacao)
                .orElseThrow(() -> new NotFoundException("Situacao processamento não encontrado"));

        return mapper.toDomain(entity);
    }

    @Override
    public void save(SituacaoProcessamento situacaoProcessamento) {
        var entity = mapper.toEntity(situacaoProcessamento);

        repository.save(entity);
    }

    @Override
    public void update(SituacaoProcessamento situacaoProcessamento) {
        var entity = mapper.toEntity(situacaoProcessamento);

        repository.update(entity);
    }
}
