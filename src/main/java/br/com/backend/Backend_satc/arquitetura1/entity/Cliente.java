package br.com.backend.Backend_satc.arquitetura1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
public class Cliente extends Pessoa{
    private String email;
    private String endereco;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, String email, String endereco) {
        super(cpf, nome);
        this.email = email;
        this.endereco = endereco;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}

