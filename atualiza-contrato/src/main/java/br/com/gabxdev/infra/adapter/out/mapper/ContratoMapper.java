package br.com.gabxdev.infra.adapter.out.mapper;

import br.com.gabxdev.domain.model.Contrato;
import br.com.gabxdev.infra.integration.repository.entity.ContratoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContratoMapper {

    Contrato toDomain(ContratoEntity entity);

    ContratoEntity toEntity(Contrato contrato);
}
