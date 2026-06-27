package com.transporteapi.service;

import com.transporteapi.dto.MotoristaRequestDTO;
import com.transporteapi.dto.MotoristaResponseDTO;
import com.transporteapi.exception.ResourceNotFoundException;
import com.transporteapi.mapper.MotoristaMapper;
import com.transporteapi.model.Motorista;
import com.transporteapi.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MotoristaService {

    @Autowired
    private MotoristaRepository repository;

    @Autowired
    private MotoristaMapper mapper;

    @Transactional(readOnly = true)
    public List<MotoristaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MotoristaResponseDTO buscar(Long id) {
        Motorista entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public MotoristaResponseDTO criar(MotoristaRequestDTO dto) {
        Motorista entity = mapper.toEntity(dto);
        Motorista salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public MotoristaResponseDTO atualizar(Long id, MotoristaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Motorista não encontrado com id: " + id);
        }
        Motorista entity = mapper.toEntity(dto);
        entity.setId(id);
        Motorista salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Motorista não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
