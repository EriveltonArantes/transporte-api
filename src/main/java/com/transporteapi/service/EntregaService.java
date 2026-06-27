package com.transporteapi.service;

import com.transporteapi.dto.EntregaRequestDTO;
import com.transporteapi.dto.EntregaResponseDTO;
import com.transporteapi.exception.ResourceNotFoundException;
import com.transporteapi.mapper.EntregaMapper;
import com.transporteapi.model.Entrega;
import com.transporteapi.repository.EntregaRepository;
import com.transporteapi.repository.CargaRepository;
import com.transporteapi.model.Carga;
import com.transporteapi.repository.VeiculoRepository;
import com.transporteapi.model.Veiculo;
import com.transporteapi.repository.MotoristaRepository;
import com.transporteapi.model.Motorista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EntregaService {

    @Autowired
    private EntregaRepository repository;

    @Autowired
    private EntregaMapper mapper;

    @Autowired
    private CargaRepository cargaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Transactional(readOnly = true)
    public List<EntregaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EntregaResponseDTO buscar(Long id) {
        Entrega entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Entrega não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public EntregaResponseDTO criar(EntregaRequestDTO dto) {
        Entrega entity = mapper.toEntity(dto);
        Carga carga = cargaRepository.findById(dto.getCargaId())
            .orElseThrow(() -> new ResourceNotFoundException("Carga não encontrado com id: " + dto.getCargaId()));
        entity.setCarga(carga);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + dto.getVeiculoId()));
        entity.setVeiculo(veiculo);
        Motorista motorista = motoristaRepository.findById(dto.getMotoristaId())
            .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado com id: " + dto.getMotoristaId()));
        entity.setMotorista(motorista);
        Entrega salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public EntregaResponseDTO atualizar(Long id, EntregaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Entrega não encontrado com id: " + id);
        }
        Entrega entity = mapper.toEntity(dto);
        entity.setId(id);
        Carga carga = cargaRepository.findById(dto.getCargaId())
            .orElseThrow(() -> new ResourceNotFoundException("Carga não encontrado com id: " + dto.getCargaId()));
        entity.setCarga(carga);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + dto.getVeiculoId()));
        entity.setVeiculo(veiculo);
        Motorista motorista = motoristaRepository.findById(dto.getMotoristaId())
            .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado com id: " + dto.getMotoristaId()));
        entity.setMotorista(motorista);
        Entrega salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Entrega não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
