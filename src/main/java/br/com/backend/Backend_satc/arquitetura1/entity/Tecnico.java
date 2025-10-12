package br.com.backend.Backend_satc.arquitetura1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
public class Tecnico extends Pessoa{

    private String especialidade;
    private int chamadosAtendidos;

    public Tecnico() {
    }

    public Tecnico(String cpf, String nome, String especialidade, int chamadosAtendidos) {
        super(cpf, nome);
        this.especialidade = especialidade;
        this.chamadosAtendidos = chamadosAtendidos;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getChamadosAtendidos() {
        return chamadosAtendidos;
    }

    public void setChamadosAtendidos(int chamadosAtendidos) {
        this.chamadosAtendidos = chamadosAtendidos;
    }
}
