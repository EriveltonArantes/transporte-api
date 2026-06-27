package com.transporteapi.controller;

import com.transporteapi.model.Veiculo;
import com.transporteapi.model.Motorista;
import com.transporteapi.model.Carga;
import com.transporteapi.model.Entrega;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.transporteapi.repository.VeiculoRepository veiculoRepository;

    @Autowired
    private com.transporteapi.repository.MotoristaRepository motoristaRepository;

    @Autowired
    private com.transporteapi.repository.CargaRepository cargaRepository;

    @Autowired
    private com.transporteapi.repository.EntregaRepository entregaRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalVeiculo", veiculoRepository.count());
        resumo.put("somaCapacidadeKgVeiculo", veiculoRepository.findAll().stream().filter(e -> e.getCapacidadeKg() != null).mapToLong(e -> e.getCapacidadeKg()).sum());
        resumo.put("graficoVeiculo", veiculoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalMotorista", motoristaRepository.count());
        resumo.put("graficoMotorista", motoristaRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalCarga", cargaRepository.count());
        resumo.put("somaValorFreteCarga", cargaRepository.findAll().stream().filter(e -> e.getValorFrete() != null).mapToDouble(e -> e.getValorFrete()).sum());
        resumo.put("totalEntrega", entregaRepository.count());
        resumo.put("graficoEntrega", entregaRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
