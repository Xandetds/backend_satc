package br.com.backend.Backend_satc.arquitetura1.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, length = 100)
    private String nome;

    public Pessoa() {}

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Long getId() { return id; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(id, pessoa.id);
    }
    @Override public int hashCode() { return Objects.hash(id); }
}
