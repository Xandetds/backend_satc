package br.com.backend.Backend_satc.arquitetura1.dto;

import br.com.backend.Backend_satc.arquitetura1.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class ChamadoDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 3, max = 100, message = "O título deve ter entre 3 e 100 caracteres")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 5, max = 500, message = "A descrição deve ter entre 5 e 500 caracteres")
    private String descricao;

    @NotNull(message = "O status é obrigatório")
    private Status status;

    @NotNull(message = "O cliente é obrigatório")
    private Long idCliente;

    @NotNull(message = "O técnico é obrigatório")
    private Long idTecnico;

    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;

    public ChamadoDTO() {}

    public ChamadoDTO(String titulo, String descricao, Status status,
                      Long idCliente, Long idTecnico,
                      LocalDateTime dataAbertura, LocalDateTime dataFechamento) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.idCliente = idCliente;
        this.idTecnico = idTecnico;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
    }

    // Getters e Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public Long getIdCliente() { return idCliente; }
    public void setIdCliente(Long idCliente) { this.idCliente = idCliente; }
    public Long getIdTecnico() { return idTecnico; }
    public void setIdTecnico(Long idTecnico) { this.idTecnico = idTecnico; }
    public LocalDateTime getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDateTime dataAbertura) { this.dataAbertura = dataAbertura; }
    public LocalDateTime getDataFechamento() { return dataFechamento; }
    public void setDataFechamento(LocalDateTime dataFechamento) { this.dataFechamento = dataFechamento; }
}
