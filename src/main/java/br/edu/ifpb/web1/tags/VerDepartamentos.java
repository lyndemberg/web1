package br.edu.ifpb.web1.tags;

import br.edu.ifpb.web1.managers.GerenciadorDepartamento;
import br.edu.ifpb.web1.entities.Departamento;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class VerDepartamentos  extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        GerenciadorDepartamento gerenciadorDepartamento = new GerenciadorDepartamento();
        List<Departamento> listar = gerenciadorDepartamento.listar();
        getJspContext().setAttribute("departamentos",listar);
    }
}
