package br.edu.ifpb.web1.tags;

import br.edu.ifpb.web1.managers.GerenciadorAlocacao;
import br.edu.ifpb.web1.entities.Funcionario;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class ListarFuncionariosProjeto extends SimpleTagSupport {

    private Integer projeto;

    @Override
    public void doTag() throws JspException, IOException {
        GerenciadorAlocacao gerenciadorAlocacao = new GerenciadorAlocacao();
        List<Funcionario> funcionarios = gerenciadorAlocacao.alocadosEmProjeto(projeto);
        getJspContext().setAttribute("funcionariosAlocados", funcionarios);

    }

    public Integer getProjeto() {
        return projeto;
    }

    public void setProjeto(Integer projeto) {
        this.projeto = projeto;
    }
}
