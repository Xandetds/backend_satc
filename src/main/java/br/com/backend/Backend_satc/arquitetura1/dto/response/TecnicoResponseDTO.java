package br.com.backend.Backend_satc.arquitetura1.dto.response;

public class TecnicoResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String especialidade;
    private int chamadosAtendidos;

    public TecnicoResponseDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public int getChamadosAtendidos() { return chamadosAtendidos; }
    public void setChamadosAtendidos(int chamadosAtendidos) { this.chamadosAtendidos = chamadosAtendidos; }
}
