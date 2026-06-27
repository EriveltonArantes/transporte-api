package com.transporteapi.mapper;

import com.transporteapi.dto.VeiculoRequestDTO;
import com.transporteapi.dto.VeiculoResponseDTO;
import com.transporteapi.model.Veiculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    Veiculo toEntity(VeiculoRequestDTO dto);

    VeiculoResponseDTO toResponseDTO(Veiculo entity);
}
