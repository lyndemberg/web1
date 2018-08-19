package br.edu.ifpb.web1.dao.interfaces;

import br.edu.ifpb.web1.dao.exceptions.PersistenciaException;
import br.edu.ifpb.web1.entities.Funcionario;

import javax.persistence.PersistenceException;
import java.util.List;

public interface FuncionarioDao {
    Boolean criar(Funcionario novo) throws PersistenciaException;
    Funcionario buscarPorMatricula(Integer matricula) throws PersistenciaException;
    Boolean atualizarDados(Integer matricula, Funcionario atualizado) throws PersistenciaException;
    Boolean atualizarFotoPerfil(Integer matricula, byte[] fotoNova) throws PersistenciaException;
    Boolean deletar(Integer matricula) throws PersistenciaException;
    List<Funcionario> listarFuncionariosDepartamento(Integer id)throws PersistenciaException;
    List<Funcionario> buscarPorNome(String busca) throws PersistenciaException;
}
