package br.com.backend.Backend_satc.arquitetura1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Cliente extends Pessoa {

    @Column(nullable = false, length = 120)
    private String email;

    @Column(nullable = false)
    private String endereco;

    public Cliente() {}

    public Cliente(String cpf, String nome, String email, String endereco) {
        super(cpf, nome);
        this.email = email;
        this.endereco = endereco;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}
