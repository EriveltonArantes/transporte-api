package com.transporteapi.dto;

import jakarta.validation.constraints.*;

public class MotoristaRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cnh não pode estar em branco")
    private String cnh;
    @NotBlank(message = "categoria cnh não pode estar em branco")
    private String categoriaCnh;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotNull(message = "status não pode ser nulo")
    private Boolean status;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCnh() { return cnh; }
    public void setCnh(String cnh) { this.cnh = cnh; }
    public String getCategoriaCnh() { return categoriaCnh; }
    public void setCategoriaCnh(String categoriaCnh) { this.categoriaCnh = categoriaCnh; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
