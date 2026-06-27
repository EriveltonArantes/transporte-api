package com.transporteapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cargas")
public class Carga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    private Double pesoKg;
    private Double volume;
    @Column(nullable = false)
    private String origemCidade;
    @Column(nullable = false)
    private String destinoCidade;
    private Double valorFrete;
    @Column(nullable = false)
    private String clienteNome;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getPesoKg() { return pesoKg; }
    public void setPesoKg(Double pesoKg) { this.pesoKg = pesoKg; }
    public Double getVolume() { return volume; }
    public void setVolume(Double volume) { this.volume = volume; }
    public String getOrigemCidade() { return origemCidade; }
    public void setOrigemCidade(String origemCidade) { this.origemCidade = origemCidade; }
    public String getDestinoCidade() { return destinoCidade; }
    public void setDestinoCidade(String destinoCidade) { this.destinoCidade = destinoCidade; }
    public Double getValorFrete() { return valorFrete; }
    public void setValorFrete(Double valorFrete) { this.valorFrete = valorFrete; }
    public String getClienteNome() { return clienteNome; }
    public void setClienteNome(String clienteNome) { this.clienteNome = clienteNome; }
}
