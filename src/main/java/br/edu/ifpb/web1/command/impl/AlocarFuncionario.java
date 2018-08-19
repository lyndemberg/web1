package br.edu.ifpb.web1.command.impl;

import br.edu.ifpb.web1.command.Command;
import br.edu.ifpb.web1.managers.GerenciadorAlocacao;
import br.edu.ifpb.web1.managers.GerenciadorFuncionario;
import br.edu.ifpb.web1.entities.Funcionario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AlocarFuncionario implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        GerenciadorAlocacao gerenciadorAlocacao = new GerenciadorAlocacao();
        String matricula = req.getParameter("matricula");
        String projeto = req.getParameter("projeto");

        Boolean alocou = gerenciadorAlocacao.alocar(Integer.valueOf(projeto), Integer.valueOf(matricula));
        if(alocou){
            res.setStatus(200);
        }else{
            res.setHeader("errorMessage","Digite uma matrícula existente!");
            res.setStatus(400);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("projetos.jsp");
        requestDispatcher.forward(req,res);

    }
}
