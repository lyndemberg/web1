package br.edu.ifpb.web1.command.impl;

import br.edu.ifpb.web1.command.Command;
import br.edu.ifpb.web1.managers.GerenciadorProjeto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CriarProjeto implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        GerenciadorProjeto gerenciadorProjeto = new GerenciadorProjeto();
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        Boolean criou = gerenciadorProjeto.criar(nome, descricao);

        if(criou){
            res.setStatus(200);
        }else{
            res.setStatus(400);
            res.setHeader("errorMessage", "Não foi possível criar o projeto!");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("projetos.jsp");
        requestDispatcher.forward(req,res);
    }
}
