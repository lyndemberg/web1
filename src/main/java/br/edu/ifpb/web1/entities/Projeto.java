package br.edu.ifpb.web1.entities;

public class Projeto {

    private Integer codigo;
    private String nome;
    private String descricao;
    private Boolean concluido;

    @Override
    public String toString() {
        return "Projeto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", concluido=" + concluido +
                '}';
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    public Projeto(Integer codigo, String nome, String descricao, Boolean concluido) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.concluido = concluido;
    }

    public Projeto() {

    }
}
