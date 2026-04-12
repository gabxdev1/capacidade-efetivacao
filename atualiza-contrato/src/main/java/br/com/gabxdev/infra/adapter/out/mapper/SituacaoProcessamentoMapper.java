package br.com.gabxdev.infra.adapter.out.mapper;

import br.com.gabxdev.domain.model.SituacaoProcessamento;
import br.com.gabxdev.infra.integration.repository.entity.SituacaoProcessamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SituacaoProcessamentoMapper {

    SituacaoProcessamento toDomain(SituacaoProcessamentoEntity entity);

    SituacaoProcessamentoEntity toEntity(SituacaoProcessamento situacaoProcessamento);
}
