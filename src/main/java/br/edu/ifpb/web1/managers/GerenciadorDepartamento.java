package br.edu.ifpb.web1.managers;

import br.edu.ifpb.web1.dao.exceptions.PersistenciaException;
import br.edu.ifpb.web1.dao.factory.Factory;
import br.edu.ifpb.web1.dao.interfaces.DepartamentoDao;
import br.edu.ifpb.web1.dao.interfaces.FactoryDao;
import br.edu.ifpb.web1.entities.Departamento;

import java.util.List;

public class GerenciadorDepartamento {
    private FactoryDao factory = null;
    private DepartamentoDao dao = null;

    public GerenciadorDepartamento(){
        factory = Factory.createFactory();
        dao = factory.getDaoDepartamento();
    }

    public Boolean novo(String nome){
        Departamento departamento = new Departamento();
        departamento.setNome(nome);
        try {
            return dao.criar(departamento);
        } catch (PersistenciaException e) {
            return false;
        }
    }

    public Boolean atualizar(Integer id, String nome){
        Departamento departamento = new Departamento();
        departamento.setNome(nome);
        try {
            return dao.atualizar(id, departamento);
        } catch (PersistenciaException e) {
            return false;
        }
    }

    public List<Departamento> listar(){
        try {
            return dao.listarTodos();
        } catch (PersistenciaException e) {
            return null;
        }
    }

    public Departamento buscar(Integer id){
        try {
            return dao.buscarPorId(id);
        } catch (PersistenciaException e) {
            return null;
        }
    }
    public Boolean deletar(Integer id){
        try {
            return dao.deletar(id);
        } catch (PersistenciaException e) {
            return false;
        }
    }



}
