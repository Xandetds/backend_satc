package br.com.backend.Backend_satc.arquitetura1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Tecnico extends Pessoa {

    @Column(nullable = false, length = 100)
    private String especialidade;

    @Column(nullable = false)
    private int chamadosAtendidos;

    public Tecnico() {}

    public Tecnico(String cpf, String nome, String especialidade, int chamadosAtendidos) {
        super(cpf, nome);
        this.especialidade = especialidade;
        this.chamadosAtendidos = chamadosAtendidos;
    }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public int getChamadosAtendidos() { return chamadosAtendidos; }
    public void setChamadosAtendidos(int chamadosAtendidos) { this.chamadosAtendidos = chamadosAtendidos; }
}
