package br.edu.ifpb.web1.tags;

import br.edu.ifpb.web1.managers.GerenciadorProjeto;
import br.edu.ifpb.web1.entities.Projeto;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class VerProjetos extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        GerenciadorProjeto gerenciadorProjeto = new GerenciadorProjeto();
        List<Projeto> projetos = gerenciadorProjeto.listarTodos();

        getJspContext().setAttribute("projetos",projetos);

    }
}
