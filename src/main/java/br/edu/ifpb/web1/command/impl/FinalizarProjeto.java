package br.edu.ifpb.web1.command.impl;

import br.edu.ifpb.web1.command.Command;
import br.edu.ifpb.web1.managers.GerenciadorProjeto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FinalizarProjeto implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        GerenciadorProjeto gerenciadorProjeto = new GerenciadorProjeto();
        String codigo = req.getParameter("codigo");
        Boolean finalizou = gerenciadorProjeto.finalizar(Integer.valueOf(codigo));
        if(finalizou){
            res.setStatus(200);
        }else{
            res.setStatus(400);
            res.setHeader("errorMessage", "Não foi possível finalizar o projeto!");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("projetos.jsp");
        requestDispatcher.forward(req,res);
    }
}
