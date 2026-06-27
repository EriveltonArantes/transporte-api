package com.transporteapi.controller;

import com.transporteapi.dto.EntregaRequestDTO;
import com.transporteapi.dto.EntregaResponseDTO;
import com.transporteapi.service.EntregaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Entrega", description = "Gerenciamento de entregas")
@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @Autowired
    private EntregaService service;

    @Operation(summary = "Listar todos os Entrega")
    @GetMapping
    public List<EntregaResponseDTO> listar(@RequestParam(required = false) String observacoes, @RequestParam(required = false) Long cargaId, @RequestParam(required = false) Long veiculoId, @RequestParam(required = false) Long motoristaId) {
        List<EntregaResponseDTO> resultado = service.listar();
        if (observacoes != null && !observacoes.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getObservacoes() != null &&
                item.getObservacoes().toLowerCase().contains(observacoes.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (cargaId != null) {
            resultado = resultado.stream().filter(item -> cargaId.equals(item.getCargaId())).collect(java.util.stream.Collectors.toList());
        }
        if (veiculoId != null) {
            resultado = resultado.stream().filter(item -> veiculoId.equals(item.getVeiculoId())).collect(java.util.stream.Collectors.toList());
        }
        if (motoristaId != null) {
            resultado = resultado.stream().filter(item -> motoristaId.equals(item.getMotoristaId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Entrega por ID")
    @GetMapping("/{id}")
    public EntregaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Entrega")
    @PostMapping
    public ResponseEntity<EntregaResponseDTO> criar(@Valid @RequestBody EntregaRequestDTO entrega) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(entrega));
    }

    @Operation(summary = "Atualizar Entrega")
    @PutMapping("/{id}")
    public EntregaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody EntregaRequestDTO entrega) {
        return service.atualizar(id, entrega);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Entrega")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
