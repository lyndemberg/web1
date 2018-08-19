package br.edu.ifpb.web1.command.impl;

import br.edu.ifpb.web1.command.Command;
import br.edu.ifpb.web1.managers.GerenciadorDepartamento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CriarDepartamento implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        GerenciadorDepartamento gerenciadorDepartamento = new GerenciadorDepartamento();
        Boolean criou = gerenciadorDepartamento.novo(req.getParameter("nomeDepartamento"));
        if(criou){
            res.setStatus(200);
        }else{
            res.setStatus(400);
            res.setHeader("errorMessage", "Não foi possível cadastrar o departamento");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("departamentos.jsp");
        requestDispatcher.forward(req,res);
    }
}
