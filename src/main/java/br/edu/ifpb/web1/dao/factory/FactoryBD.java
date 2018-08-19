package br.edu.ifpb.web1.dao.factory;

import br.edu.ifpb.web1.dao.impl.AlocacaoDaoBD;
import br.edu.ifpb.web1.dao.impl.DepartamentoDaoBD;
import br.edu.ifpb.web1.dao.impl.FuncionarioDaoBD;
import br.edu.ifpb.web1.dao.impl.ProjetoDaoBD;
import br.edu.ifpb.web1.dao.interfaces.*;
import br.edu.ifpb.web1.dao.interfaces.*;

import javax.persistence.PersistenceException;
import java.sql.SQLException;

public class FactoryBD implements FactoryDao {

    @Override
    public DepartamentoDao getDaoDepartamento() throws PersistenceException {
        try {
            return new DepartamentoDaoBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FuncionarioDao getDaoFuncionario() throws PersistenceException{
        try{
            return new FuncionarioDaoBD();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProjetoDao getDaoProjeto() throws PersistenceException{
        try{
            return new ProjetoDaoBD();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AlocacaoDao getDaoAlocacao() throws PersistenceException {
        try{
            return new AlocacaoDaoBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
