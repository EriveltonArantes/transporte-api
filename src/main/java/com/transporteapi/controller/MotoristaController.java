package com.transporteapi.controller;

import com.transporteapi.dto.MotoristaRequestDTO;
import com.transporteapi.dto.MotoristaResponseDTO;
import com.transporteapi.service.MotoristaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Motorista", description = "Gerenciamento de motoristas")
@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaService service;

    @Operation(summary = "Listar todos os Motorista")
    @GetMapping
    public List<MotoristaResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<MotoristaResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Motorista por ID")
    @GetMapping("/{id}")
    public MotoristaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Motorista")
    @PostMapping
    public ResponseEntity<MotoristaResponseDTO> criar(@Valid @RequestBody MotoristaRequestDTO motorista) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(motorista));
    }

    @Operation(summary = "Atualizar Motorista")
    @PutMapping("/{id}")
    public MotoristaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody MotoristaRequestDTO motorista) {
        return service.atualizar(id, motorista);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Motorista")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
