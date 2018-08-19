package br.edu.ifpb.web1.managers;

import br.edu.ifpb.web1.dao.exceptions.PersistenciaException;
import br.edu.ifpb.web1.dao.factory.Factory;
import br.edu.ifpb.web1.dao.interfaces.AlocacaoDao;
import br.edu.ifpb.web1.dao.interfaces.FactoryDao;
import br.edu.ifpb.web1.entities.Alocacao;
import br.edu.ifpb.web1.entities.Funcionario;
import br.edu.ifpb.web1.entities.Projeto;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorAlocacao {
    private FactoryDao factory = null;
    private AlocacaoDao dao = null;

    public GerenciadorAlocacao() {
        factory = Factory.createFactory();
        dao = factory.getDaoAlocacao();
    }

    public Boolean alocar(Integer projeto, Integer matricula) {
        Alocacao alocacao = new Alocacao(projeto,matricula);
        try {
            return dao.criar(alocacao);
        } catch (PersistenciaException e) {
            return false;
        }

    }

    public List<Funcionario> alocadosEmProjeto(Integer projeto){
        try {
            return dao.alocadosEmProjeto(projeto);
        } catch (PersistenciaException e) {
            return null;
        }

    }

    public List<Projeto> projetosFuncionario(Integer matricula){
        try {
            return dao.listarProjetosFuncionario(matricula);
        } catch (PersistenciaException e) {
            return null;
        }
    }
}
