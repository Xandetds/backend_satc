package br.com.backend.Backend_satc.arquitetura1.dto.response;

import br.com.backend.Backend_satc.arquitetura1.enums.Status;
import java.time.LocalDateTime;

public class ChamadoResponseDTO {
    private Long idChamado;
    private String titulo;
    private String descricao;
    private Status status;
    private String clienteNome;
    private String tecnicoNome;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;

    public ChamadoResponseDTO() {}

    public Long getIdChamado() { return idChamado; }
    public void setIdChamado(Long idChamado) { this.idChamado = idChamado; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public String getClienteNome() { return clienteNome; }
    public void setClienteNome(String clienteNome) { this.clienteNome = clienteNome; }
    public String getTecnicoNome() { return tecnicoNome; }
    public void setTecnicoNome(String tecnicoNome) { this.tecnicoNome = tecnicoNome; }
    public LocalDateTime getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDateTime dataAbertura) { this.dataAbertura = dataAbertura; }
    public LocalDateTime getDataFechamento() { return dataFechamento; }
    public void setDataFechamento(LocalDateTime dataFechamento) { this.dataFechamento = dataFechamento; }
}
