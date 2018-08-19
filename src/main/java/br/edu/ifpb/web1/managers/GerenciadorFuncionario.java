package br.edu.ifpb.web1.managers;

import br.edu.ifpb.web1.dao.exceptions.PersistenciaException;
import br.edu.ifpb.web1.dao.factory.Factory;
import br.edu.ifpb.web1.dao.interfaces.FactoryDao;
import br.edu.ifpb.web1.dao.interfaces.FuncionarioDao;
import br.edu.ifpb.web1.entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorFuncionario {
    private FactoryDao factory = null;
    private FuncionarioDao dao = null;

    public GerenciadorFuncionario() {
        factory = Factory.createFactory();
        dao = factory.getDaoFuncionario();
    }

    public Boolean cadastrar(String nome, String email, Integer departamento_id,
                             byte[] foto, String telefone1, String telefone2){
        Funcionario funcionario = new Funcionario(foto, nome, email, departamento_id, telefone1, telefone2);
        try {
            return dao.criar(funcionario);
        } catch (PersistenciaException e) {
            return false;
        }
    }

    public Boolean atualizarDados(Integer matricula,String nome, String email, Integer departamento_id,
                                  String telefone1, String telefone2){
        Funcionario funcionario = new Funcionario();
        funcionario.setDepartamento_id(departamento_id);
        funcionario.setEmail(email);
        funcionario.setNome(nome);
        funcionario.setTelefone1(telefone1);
        funcionario.setTelefone2(telefone2);
        try {
            return dao.atualizarDados(matricula,funcionario);
        } catch (PersistenciaException e) {
            return false;
        }
    }

    public Boolean mudarFoto(Integer matricula, byte[] novaFoto){
        try {
            return dao.atualizarFotoPerfil(matricula,novaFoto);
        } catch (PersistenciaException e) {
            return false;
        }
    }

    public Funcionario byMatricula(Integer matricula){
        try {
            return dao.buscarPorMatricula(matricula);
        } catch (PersistenciaException e) {
            return null;
        }
    }

    public List<Funcionario> listFuncionariosDepartamento(Integer dep){
        try {
            return dao.listarFuncionariosDepartamento(dep);
        } catch (PersistenciaException e) {
            return null;
        }
    }
    public List<Funcionario> buscarPeloNome(String busca){
        try {
            return dao.buscarPorNome(busca);
        } catch (PersistenciaException e) {
            return null;
        }
    }
}
