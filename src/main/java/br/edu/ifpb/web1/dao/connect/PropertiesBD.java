package br.edu.ifpb.web1.dao.connect;

public class PropertiesBD {

    private String url;
    private String user;
    private String senha;

    public PropertiesBD() {
        this.url = "jdbc:postgresql://127.0.0.1:5432/pweb1";
        this.user = "postgres";
        this.senha = "postgres";
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
