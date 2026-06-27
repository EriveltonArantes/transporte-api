package com.transporteapi.dto;

public class CargaResponseDTO {

    private Long id;
    private String descricao;
    private Double pesoKg;
    private Double volume;
    private String origemCidade;
    private String destinoCidade;
    private Double valorFrete;
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
