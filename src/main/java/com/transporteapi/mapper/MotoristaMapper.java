package com.transporteapi.mapper;

import com.transporteapi.dto.MotoristaRequestDTO;
import com.transporteapi.dto.MotoristaResponseDTO;
import com.transporteapi.model.Motorista;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MotoristaMapper {

    Motorista toEntity(MotoristaRequestDTO dto);

    MotoristaResponseDTO toResponseDTO(Motorista entity);
}
