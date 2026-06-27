package com.transporteapi.dto;

public class EntregaResponseDTO {

    private Long id;
    private Long cargaId;
    private Long veiculoId;
    private Long motoristaId;
    private java.time.LocalDateTime dataSaida;
    private java.time.LocalDateTime dataPrevisao;
    private java.time.LocalDateTime dataEntrega;
    private String status;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCargaId() { return cargaId; }
    public void setCargaId(Long cargaId) { this.cargaId = cargaId; }
    public Long getVeiculoId() { return veiculoId; }
    public void setVeiculoId(Long veiculoId) { this.veiculoId = veiculoId; }
    public Long getMotoristaId() { return motoristaId; }
    public void setMotoristaId(Long motoristaId) { this.motoristaId = motoristaId; }
    public java.time.LocalDateTime getDataSaida() { return dataSaida; }
    public void setDataSaida(java.time.LocalDateTime dataSaida) { this.dataSaida = dataSaida; }
    public java.time.LocalDateTime getDataPrevisao() { return dataPrevisao; }
    public void setDataPrevisao(java.time.LocalDateTime dataPrevisao) { this.dataPrevisao = dataPrevisao; }
    public java.time.LocalDateTime getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(java.time.LocalDateTime dataEntrega) { this.dataEntrega = dataEntrega; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
