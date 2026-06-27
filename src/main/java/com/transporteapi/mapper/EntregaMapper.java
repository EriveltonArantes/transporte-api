package com.transporteapi.mapper;

import com.transporteapi.dto.EntregaRequestDTO;
import com.transporteapi.dto.EntregaResponseDTO;
import com.transporteapi.model.Entrega;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntregaMapper {

    @Mapping(target = "carga", ignore = true)
    @Mapping(target = "veiculo", ignore = true)
    @Mapping(target = "motorista", ignore = true)
    Entrega toEntity(EntregaRequestDTO dto);

    @Mapping(target = "cargaId", source = "carga.id")
    @Mapping(target = "veiculoId", source = "veiculo.id")
    @Mapping(target = "motoristaId", source = "motorista.id")
    EntregaResponseDTO toResponseDTO(Entrega entity);
}
