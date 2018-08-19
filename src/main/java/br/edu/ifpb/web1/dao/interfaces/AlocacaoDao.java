package br.edu.ifpb.web1.dao.interfaces;

import br.edu.ifpb.web1.dao.exceptions.PersistenciaException;
import br.edu.ifpb.web1.entities.Funcionario;
import br.edu.ifpb.web1.entities.Projeto;
import br.edu.ifpb.web1.entities.Alocacao;

import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.util.List;

public interface AlocacaoDao {
    Boolean criar(Alocacao alocacao) throws PersistenciaException;
    Boolean deletar(Alocacao alocacao) throws PersistenciaException;
    List<Projeto> listarProjetosFuncionario(Integer matricula) throws PersistenciaException;
    List<Funcionario> alocadosEmProjeto(Integer projeto) throws PersistenciaException;
}
