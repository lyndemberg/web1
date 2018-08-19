package br.edu.ifpb.web1.entities;

public class Alocacao {
    private Integer codigo_projeto;
    private Integer matricula_funcionario;

    @Override
    public String toString() {
        return "Alocacao{" +
                "codigo_projeto=" + codigo_projeto +
                ", matricula_funcionario='" + matricula_funcionario + '\'' +
                '}';
    }

    public Integer getCodigo_projeto() {
        return codigo_projeto;
    }

    public void setCodigo_projeto(Integer codigo_projeto) {
        this.codigo_projeto = codigo_projeto;
    }

    public Integer getMatricula_funcionario() {
        return matricula_funcionario;
    }

    public void setMatricula_funcionario(Integer matricula_funcionario) {
        this.matricula_funcionario = matricula_funcionario;
    }

    public Alocacao(Integer codigo_projeto, Integer matricula_funcionario) {

        this.codigo_projeto = codigo_projeto;
        this.matricula_funcionario = matricula_funcionario;
    }

    public Alocacao() {

    }
}
