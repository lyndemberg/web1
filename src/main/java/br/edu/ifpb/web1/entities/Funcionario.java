package br.edu.ifpb.web1.entities;

import java.util.Arrays;
import java.util.Base64;

public class Funcionario {

    private Integer matricula;
    private byte[] foto;
    private String nome;
    private String email;
    private Integer departamento_id;
    private String telefone1;
    private String telefone2;

    public Funcionario() {
    }

    public Funcionario(Integer matricula, byte[] foto, String nome, String email, Integer departamento_id, String telefone1, String telefone2) {
        this.matricula = matricula;
        this.foto = foto;
        this.nome = nome;
        this.email = email;
        this.departamento_id = departamento_id;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
    }

    public Funcionario(byte[] foto, String nome, String email, Integer departamento_id, String telefone1, String telefone2) {
        this.foto = foto;
        this.nome = nome;
        this.email = email;
        this.departamento_id = departamento_id;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "matricula='" + matricula + '\'' +
                ", foto=" + Arrays.toString(foto) +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", departamento_id=" + departamento_id +
                ", telefone1='" + telefone1 + '\'' +
                ", telefone2='" + telefone2 + '\'' +
                '}';
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(Integer departamento_id) {
        this.departamento_id = departamento_id;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String imageBase64(){
        String base64 = Base64.getEncoder().encodeToString(foto);
        return base64;
    }
}

