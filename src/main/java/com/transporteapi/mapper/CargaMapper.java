package com.transporteapi.mapper;

import com.transporteapi.dto.CargaRequestDTO;
import com.transporteapi.dto.CargaResponseDTO;
import com.transporteapi.model.Carga;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CargaMapper {

    Carga toEntity(CargaRequestDTO dto);

    CargaResponseDTO toResponseDTO(Carga entity);
}
