package com.transporteapi.dto;

import jakarta.validation.constraints.*;

public class VeiculoRequestDTO {

    @NotBlank(message = "placa não pode estar em branco")
    private String placa;
    @NotBlank(message = "modelo não pode estar em branco")
    private String modelo;
    @NotBlank(message = "marca não pode estar em branco")
    private String marca;
    @Min(value = 0, message = "ano fabricacao não pode ser negativo")
    @NotNull(message = "ano fabricacao não pode ser nulo")
    private Integer anoFabricacao;
    @Min(value = 0, message = "capacidade kg não pode ser negativo")
    @NotNull(message = "capacidade kg não pode ser nulo")
    private Long capacidadeKg;
    @NotNull(message = "status não pode ser nulo")
    private Boolean status;

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public Integer getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(Integer anoFabricacao) { this.anoFabricacao = anoFabricacao; }
    public Long getCapacidadeKg() { return capacidadeKg; }
    public void setCapacidadeKg(Long capacidadeKg) { this.capacidadeKg = capacidadeKg; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
