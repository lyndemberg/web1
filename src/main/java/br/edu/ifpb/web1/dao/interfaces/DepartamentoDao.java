package br.edu.ifpb.web1.dao.interfaces;

import br.edu.ifpb.web1.dao.exceptions.PersistenciaException;
import br.edu.ifpb.web1.entities.Departamento;

import javax.persistence.PersistenceException;
import java.util.List;

public interface DepartamentoDao {
    Boolean criar(Departamento novo) throws PersistenciaException;
    Departamento buscarPorId(Integer id) throws PersistenciaException;
    Boolean atualizar(Integer id, Departamento atualizado) throws PersistenciaException;
    Boolean deletar(Integer id) throws PersistenciaException;
    List<Departamento> listarTodos() throws PersistenciaException;
}
