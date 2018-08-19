package br.edu.ifpb.web1.command.impl;

import br.edu.ifpb.web1.command.Command;
import br.edu.ifpb.web1.managers.GerenciadorDepartamento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcluirDepartamento implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        GerenciadorDepartamento gerenciadorDepartamento = new GerenciadorDepartamento();
        String idDepartamento = req.getParameter("idDepartamento");
        Boolean deletou = gerenciadorDepartamento.deletar(Integer.valueOf(idDepartamento));
        if(deletou){
            res.setStatus(200);
        }else{
            res.setStatus(400);
            res.setHeader("errorMessage", "Não foi possível remover o departamento");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("departamentos.jsp");
        requestDispatcher.forward(req,res);

    }
}
