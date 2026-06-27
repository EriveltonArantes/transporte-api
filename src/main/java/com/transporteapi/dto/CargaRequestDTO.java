package com.transporteapi.dto;

import jakarta.validation.constraints.*;

public class CargaRequestDTO {

    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotNull(message = "peso kg não pode ser nulo")
    private Double pesoKg;
    @NotNull(message = "volume não pode ser nulo")
    private Double volume;
    @NotBlank(message = "origem cidade não pode estar em branco")
    private String origemCidade;
    @NotBlank(message = "destino cidade não pode estar em branco")
    private String destinoCidade;
    @DecimalMin(value = "0.0", message = "valor frete não pode ser negativo")
    @NotNull(message = "valor frete não pode ser nulo")
    private Double valorFrete;
    @NotBlank(message = "cliente nome não pode estar em branco")
    private String clienteNome;

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
