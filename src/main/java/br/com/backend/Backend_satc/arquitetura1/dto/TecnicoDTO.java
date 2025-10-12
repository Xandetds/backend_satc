package br.com.backend.Backend_satc.arquitetura1.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TecnicoDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos")
    private String cpf;

    @NotBlank(message = "A Especialidade é obrigatória.")
    @Size(min = 3, max = 100, message = "A Especialidade deve ter entre 3 e 100 caracteres")
    private String especialidade;


    @Min(value = 0, message = "O número de chamados atendidos não pode ser negativo")
    private int chamadosAtendidos;

    public TecnicoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
