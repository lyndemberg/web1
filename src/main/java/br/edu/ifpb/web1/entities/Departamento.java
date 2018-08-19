package br.edu.ifpb.web1.entities;

import java.io.Serializable;

public class Departamento implements Serializable {

    private Integer id;
    private String nome;

    public Departamento() {
    }

    public Departamento(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }



    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
