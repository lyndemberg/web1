package br.edu.ifpb.web1.command.impl;

import br.edu.ifpb.web1.command.Command;
import br.edu.ifpb.web1.managers.GerenciadorFuncionario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

public class CadastrarFuncionario implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String telefone1 = req.getParameter("telefone1");
        String telefone2 = req.getParameter("telefone2");
        String departamento = req.getParameter("departamento");
        Part part = req.getPart("foto");

        byte[] foto = new byte[(int) part.getSize()];
        InputStream stream = part.getInputStream();
        stream.read(foto);
        stream.close();

        GerenciadorFuncionario gerenciadorFuncionario = new GerenciadorFuncionario();
        Boolean cadastrar = gerenciadorFuncionario.cadastrar(nome, email, Integer.valueOf(departamento), foto, telefone1, telefone2);

        if(cadastrar){
            res.setStatus(200);
        }else{
            res.setStatus(400);
            res.setHeader("errorMessage", "Não foi possível cadastrar o funcionário");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req,res);

    }
}
