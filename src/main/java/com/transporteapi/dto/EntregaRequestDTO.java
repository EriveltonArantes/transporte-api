package com.transporteapi.dto;

import jakarta.validation.constraints.*;

public class EntregaRequestDTO {

    @NotNull(message = "CargaId é obrigatório")
    @Positive(message = "CargaId deve ser um ID válido (positivo)")
    private Long cargaId;
    @NotNull(message = "VeiculoId é obrigatório")
    @Positive(message = "VeiculoId deve ser um ID válido (positivo)")
    private Long veiculoId;
    @NotNull(message = "MotoristaId é obrigatório")
    @Positive(message = "MotoristaId deve ser um ID válido (positivo)")
    private Long motoristaId;
    @NotNull(message = "data saida não pode ser nulo")
    private java.time.LocalDateTime dataSaida;
    @NotNull(message = "data previsao não pode ser nulo")
    private java.time.LocalDateTime dataPrevisao;
    @FutureOrPresent(message = "data entrega não pode ser retroativo")
    @NotNull(message = "data entrega não pode ser nulo")
    private java.time.LocalDateTime dataEntrega;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    private String observacoes;

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
