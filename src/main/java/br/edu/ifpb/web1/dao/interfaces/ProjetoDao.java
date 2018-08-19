package br.edu.ifpb.web1.dao.interfaces;

import br.edu.ifpb.web1.dao.exceptions.PersistenciaException;
import br.edu.ifpb.web1.entities.Projeto;

import javax.persistence.PersistenceException;
import java.util.List;

public interface ProjetoDao {
    Boolean criar(Projeto novo) throws PersistenciaException;
    Projeto buscarPorCodigo(Integer codigo) throws PersistenciaException;
    Boolean atualizar(Integer codigo, Projeto atualizado) throws PersistenciaException;
    Boolean fecharProjeto(Integer codigo) throws PersistenciaException;
    List<Projeto> listAll() throws PersistenciaException;
}
