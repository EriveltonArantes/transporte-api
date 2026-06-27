package com.transporteapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String placa;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String marca;
    private Integer anoFabricacao;
    private Long capacidadeKg;
    private Boolean status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
