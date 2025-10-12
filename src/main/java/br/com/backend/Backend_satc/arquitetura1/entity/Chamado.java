package br.com.backend.Backend_satc.arquitetura1.entity;

import jakarta.persistence.*;
import br.com.backend.Backend_satc.arquitetura1.enums.Status;
import java.time.LocalDateTime;



@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChamado;

    private String titulo;
    private String descricao;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;

    @Enumerated(EnumType.STRING)
    private Status status;



    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Tecnico tecnico;

    public Chamado() {
    }

    public Chamado(String titulo, String descricao,
                   LocalDateTime dataAbertura,
                   LocalDateTime dataFechamento,
                   Status status, Cliente cliente,
                   Tecnico tecnico) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.status = status;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Long getIdChamado() {
        return idChamado;
    }


}
