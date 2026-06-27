package com.transporteapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entregas")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carga_id")
    private Carga carga;
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;
    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;
    private java.time.LocalDateTime dataSaida;
    private java.time.LocalDateTime dataPrevisao;
    private java.time.LocalDateTime dataEntrega;
    @Column(nullable = false)
    private String status;
    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Carga getCarga() { return carga; }
    public void setCarga(Carga carga) { this.carga = carga; }
    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }
    public Motorista getMotorista() { return motorista; }
    public void setMotorista(Motorista motorista) { this.motorista = motorista; }
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
