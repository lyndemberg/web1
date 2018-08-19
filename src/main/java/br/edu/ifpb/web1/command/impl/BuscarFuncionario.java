package br.edu.ifpb.web1.command.impl;

import br.edu.ifpb.web1.command.Command;
import br.edu.ifpb.web1.managers.GerenciadorFuncionario;
import br.edu.ifpb.web1.entities.Funcionario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BuscarFuncionario implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String busca = req.getParameter("busca");
        GerenciadorFuncionario gerenciadorFuncionario = new GerenciadorFuncionario();
        List<Funcionario> funcionarios = gerenciadorFuncionario.buscarPeloNome(busca);

        req.setAttribute("funcionariosBusca", funcionarios);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req,res);


    }
}
