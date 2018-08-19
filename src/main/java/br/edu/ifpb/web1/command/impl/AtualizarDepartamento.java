package br.edu.ifpb.web1.command.impl;

import br.edu.ifpb.web1.command.Command;
import br.edu.ifpb.web1.managers.GerenciadorDepartamento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AtualizarDepartamento implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String idDepartamento = req.getParameter("idDepartamento");
        String nome = req.getParameter("nome");

        GerenciadorDepartamento gerenciadorDepartamento = new GerenciadorDepartamento();
        Boolean atualizou = gerenciadorDepartamento.atualizar(Integer.valueOf(idDepartamento), nome);

        if(atualizou){
            res.setStatus(200);
        }else{
            res.setHeader("errorMessage","Não foi possível atualizar o departamento!");
            res.setStatus(400);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("departamentos.jsp");
        requestDispatcher.forward(req,res);

    }
}
