package br.com.backend.Backend_satc.arquitetura1.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class ChamadoRequestDTO {
    @NotBlank(message = "O título é obrigatório")
    @Size(min = 3, max = 100, message = "O título deve ter entre 3 e 100 caracteres")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 5, max = 500, message = "A descrição deve ter entre 5 e 500 caracteres")
    private String descricao;

    @NotNull(message = "O cliente é obrigatório")
    private Long idCliente;

    @NotNull(message = "O técnico é obrigatório")
    private Long idTecnico;

    public ChamadoRequestDTO() {}

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Long getIdCliente() { return idCliente; }
    public void setIdCliente(Long idCliente) { this.idCliente = idCliente; }
    public Long getIdTecnico() { return idTecnico; }
    public void setIdTecnico(Long idTecnico) { this.idTecnico = idTecnico; }
}
